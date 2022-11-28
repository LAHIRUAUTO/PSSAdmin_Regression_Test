package PSS_Pages.PSS_Home_Page;

import Utilities.GenericUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AdminHomePageObjects extends GenericUtils {

    public AdminHomePageObjects() throws IOException {
    }


    @FindBy(xpath = "/html/body/header/div[2]/div[2]/a/div\n")
    @CacheLookup
    WebElement userinfo;

    @FindBy(xpath = "//div[@class='tr u-name']")
    @CacheLookup
    WebElement loggedinuser;

    @FindBy(xpath = "//a[@id='btnChangePassword']")
    @CacheLookup
    WebElement changepassword;

    @FindBy(xpath = "//a[@class='logout']")
    @CacheLookup
    WebElement logoutbutton;

    @FindBy(xpath = "//*[@id=\"ui-id-2\"]\n")
    @CacheLookup
    WebElement dashboard;

    @FindBy(xpath = "//div[@class='dashDefaults']//ul[@class='main-mnu']")
    @CacheLookup
    WebElement dashboardshortcut;



    @FindBy(xpath = "/html/body/header/a\n")
    @CacheLookup
    WebElement tooglemenu;

    @FindBy (xpath = "/html/body/header/nav/ul/li[2]/a\n")
    @CacheLookup
    WebElement maintenancetab;

    @FindBy (xpath = "/html/body/header/nav/ul/li[2]/ul/li[1]/a\n")
    @CacheLookup
    WebElement security;

    @FindBy (xpath = "/html/body/header/nav/ul/li[2]/ul/li[1]/ul/li[1]/a\n")
    @CacheLookup
    WebElement role;

    @FindBy (xpath = "/html/body/header/nav/ul/li[2]/ul/li[1]/ul/li[2]/a\n")
    @CacheLookup
    WebElement functionalUsage;

    @FindBy (xpath = "/html[1]/body[1]/header[1]/nav[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]")
    WebElement geography;

    @FindBy (xpath = "//a[@class='airport']")
    WebElement airport;

    @FindBy (xpath = "//a[@class='airportDST']")
    WebElement airportDST;

    @FindBy (xpath = "//a[@class='city']")
    WebElement city;


    @FindBy (xpath = "//a[@class='country']")
    WebElement country;

    @FindBy (xpath = "//a[@class='salesTerritory']")
    WebElement territory;

    @FindBy (xpath = "//a[@class='station']")
    WebElement station;

    @FindBy (xpath = "//a[@class='nationality']")
    WebElement nationality;








}