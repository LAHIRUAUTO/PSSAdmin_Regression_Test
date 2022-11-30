package TestBase;

import Types.BrowserTypes;
import Utilities.TestReportSender;
import Utilities.ZipUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test_Base {
    public static WebDriver driver;


    @BeforeSuite
    public static void clearLog4jFile() throws IOException {
        FileWriter fwOb = new FileWriter("log4j.out", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

    @Parameters({"browser", "url"})
    @BeforeSuite
    public static void intialize(BrowserTypes browser, String url) throws Exception {

        switch (browser) {
            case chrome:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case firefox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case edge:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case chromeheadless:
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.setHeadless(true);
                driver = new ChromeDriver(option);

            default:
                throw new Exception("Browser is not correct");
        }
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters({"url", "browser"})
    @BeforeTest
    public void validateCurrentURL (String url, String browser){
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(url), "Incorrect URL");
    }

    @BeforeMethod
    public static void implicitwait () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }



    @AfterTest
    public static void close() {
            driver.close();
    }
    @Parameters ({"build", "Module", "TestReportSenderMailAddress", "TestReportSenderMailPassword", "TestReportReceiverMailAddress"})
    @AfterSuite
    public static void endSuite(String build, String module, String TestReportSenderMailAddress, String TestReportSenderMailPassword, String TestReportReceiverMailAddress) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm/");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        ZipUtils.creatZipFile();
        TestReportSender.sendPDFReportByGMail(TestReportSenderMailAddress, TestReportSenderMailPassword, TestReportReceiverMailAddress, "Test Result at " + dtf.format(now)+ " On "+ module +" "+ build, "Dear Mr Vikasitha,");
    }
    //1Slite0614
}
