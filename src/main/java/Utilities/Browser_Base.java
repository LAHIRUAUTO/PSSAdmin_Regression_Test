package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Browser_Base {
    public static WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public static void Intialize(String browser, String url) throws Exception {

        switch (browser) {
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                //System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/Drivers/chromedriver_linux64/chromedriver"));
                //create chrome instance
                //driver = new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chromeheadless" :
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.setHeadless(true);
                driver = new ChromeDriver(option);

            default:
                throw new Exception("Browser is not correct");



        }
        driver.get(url);
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension (1024, 768));
        //driver.manage().window().setPosition(new Point(100, 300));


    }

    @AfterTest
    public static void close() {

        //driver.close();
    }
}
