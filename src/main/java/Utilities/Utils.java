package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.dom4j.Branch;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


public class Utils extends Browser_Base{

    //Generate Extent Report start
    static ExtentTest test;
    static ExtentReports report;

    public Utils() throws IOException {
    }

    @Parameters ({"Branch", "Module"})
    @BeforeSuite
    public static void startTest(String Branch, String Module) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now) + ": Test suite started ");
        report = new ExtentReports(System.getProperty("user.dir") + "/Extent_Reports/Test_Result.html", true);
        test = report.startTest(Module + Branch);

    }
    //Generate Extent Report end


    //Implicit Wait start
    @BeforeMethod
    public static void implicitwait () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    //Implicit Wait end

    //Explicit Wait ElementVisible
    public void explicitWaitElementVisible(WebElement element) {
        WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitwait.until(ExpectedConditions.visibilityOf(element ));
    }

    //Explicit Wait ElementClickable
    public void explicitWaitElementClickable(WebElement element) {
        WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Fluent Wait ElementVisible
    public void fluentWaitElementVisible(String xpath) {
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }


    //On mouse Hover
    public void mouseHover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    //Click
    public void click(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void doubleClick (WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }



    public void appPropertyAccess () throws IOException {
        //Load Property File
        File src = new File(System.getProperty("user.dir") + "/App.properties");
        FileInputStream objfile = new FileInputStream(src);
        Properties obj = new Properties();
        obj.load(objfile);
        String setProjectPath = obj.getProperty("ProjectPath");

    }


    //Capture Screen Shots start
        @Parameters({ "browser"})
        @AfterMethod

        public void tearDown(ITestResult result, String browser) throws IOException {

        test.log(LogStatus.INFO, driver + " - Test Case " + result.getName() + " Running");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("This need to be run per each test methos / case");

        if (ITestResult.FAILURE == result.getStatus()) {
            test.log(LogStatus.FAIL, driver + " - Test Case " + result.getName() + " Faild");

            try {
                TakesScreenshot ts = (TakesScreenshot) driver;

                File source = ts.getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "/Screen_Capture_Result/Failure_Screen_Capture/" + result.getName() + " On " + browser + ".png"));

                System.out.println("Running the Test Case : " + result.getName() + " On " + browser);
                System.out.println("Test Failed Screenshot taken " + result.getName() + " On " + browser);

            } catch (Exception e) {

                System.out.println("Exception while taking screenshot " + e.getMessage());
            }


        } else if (ITestResult.SUCCESS == result.getStatus()) {
            test.log(LogStatus.PASS, driver + " - Test Case " + result.getName() + " Passed");

            try {
                TakesScreenshot ts = (TakesScreenshot) driver;

                File source = ts.getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(source, new File(System.getProperty("user.dir") +  "/Screen_Capture_Result/Success_Screen_Capture/" + result.getName() + " On " + browser + ".png"));

                System.out.println("Running the Test Case : " + result.getName()+ " On " + browser);
                System.out.println("Test Passed Screenshot taken " + result.getName()+ " On " + browser);
            } catch (Exception e) {

                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        } else if (ITestResult.SKIP == result.getStatus()) {
            test.log(LogStatus.SKIP, driver + " - Test Case " + result.getName() + " Passed");

            try {
                TakesScreenshot ts = (TakesScreenshot) driver;

                File source = ts.getScreenshotAs(OutputType.FILE);

                FileUtils.copyFile(source, new File(System.getProperty("user.dir") +  "/Screen_Capture_Result/Skip_Screen_Capture/"+ result.getName() + " On " + browser + ".png"));

                System.out.println("Running the Test Case : " + result.getName()+ " On " + browser);
                System.out.println("Test Skiped Screenshot taken " + result.getName()+ " On " + browser);
            } catch (Exception e) {

                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
    //Capture Screen Shots ends



    //Generate Extent Report post steps
    @AfterClass
    public static void endTest() {
        report.endTest(test);
        report.flush();

    }

    @Parameters ({"Branch", "Module", "TestReportSenderMailAddress", "TestReportSenderMailPassword", "TestReportReceiverMailAddress"})
    @AfterSuite
    public static void endSuite(String branch, String module, String TestReportSenderMailAddress, String TestReportSenderMailPassword, String TestReportReceiverMailAddress) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        ZipUtils.creatZipFile();
        TestReportSender.sendPDFReportByGMail(TestReportSenderMailAddress, TestReportSenderMailPassword, TestReportReceiverMailAddress, "Test Result at " + dtf.format(now)+ " On "+ module +" "+ branch, "Dear Mr Vikasitha,");
    }
    //1Slite0614







}