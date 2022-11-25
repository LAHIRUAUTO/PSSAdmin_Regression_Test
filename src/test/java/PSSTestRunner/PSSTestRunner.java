package PSSTestRunner;


import PSS_Pages.PSS_Geography_Page.AdminGeographyPageMethods;
import PSS_Pages.PSS_Home_Page.AdminHomePageMethods;
//import PSS_Pages.PSS_Login_Page.AdminLoginPageMethods;
import PSS_Pages.PSS_Login_Page.AdminLoginPageObjects;
import PSS_Pages.PSS_Security_Page.AdminSecurityPageMethods;
import Utilities.RetryFailureTest;
import Utilities.TestNGDataProvider;
import Utilities.GenericUtils;
import com.sun.net.httpserver.Authenticator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

public class PSSTestRunner extends GenericUtils {


    @Parameters({"title"})
    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, retryAnalyzer = RetryFailureTest.class)
    public void Log_In_To_The_PSS_Admin(String username, String password){


            AdminLoginPageObjects newadminloginpage = PageFactory.initElements(driver, AdminLoginPageObjects.class);
            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            newadminloginpage.enterUsername(username);
            newadminloginpage.enterPassword(password);
            newadminloginpage.clickLoginbutton();
            newadminhomepage.mouseHoweDashBooard();
            driver.navigate().refresh();

    }


    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Roles(String rolename) throws InterruptedException {

            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminSecurityPageMethods newadminrolepage = PageFactory.initElements(driver, AdminSecurityPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweSecurity();
            newadminhomepage.clickrole();
            newadminhomepage.swithToIframe();
            newadminrolepage.enterRoleName(rolename);
            newadminrolepage.clickRoleSearchButton();
            newadminrolepage.clickRoleName();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();



    }

    @Test (dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Functional_Usage() throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminSecurityPageMethods newadminsecuritypage = PageFactory.initElements(driver, AdminSecurityPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweSecurity();
            newadminhomepage.clickFunctionUsage();
            newadminhomepage.swithToIframe();
            newadminsecuritypage.clickUnAssignedFunctionRadioButton();
            newadminsecuritypage.clickFunctionalSearchButton();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();


    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Airports(String airportCode) throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickAirport();
            newadminhomepage.swithToIframe();
            newadmingeographypage.clickAirportCodeFieldLocator(airportCode);
            newadmingeographypage.clickAirportSearchButtonLocator();
            newadmingeographypage.clickAirportLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();


    }

    @Test ( dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Add_Airports() throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickAirport();
            newadminhomepage.swithToIframe();
            newadmingeographypage.clickAddAirportButtonLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();


    }

    @Test (dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Airports_DST() throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickAirportDST();
            newadminhomepage.swithToIframe();
            newadmingeographypage.clickAirportDSTSearchButtonLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();


    }

    @Test (dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Add_Airports_DST() throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickAirportDST();
            newadminhomepage.swithToIframe();
            newadmingeographypage.clickAirportDSTSearchButtonLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();



    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_City(String countryName) throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickCity();
            newadminhomepage.swithToIframe();
            newadmingeographypage.selectcountry(countryName);
            newadmingeographypage.clickCitySearchButtonLocator();
            newadmingeographypage.clickCityLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();


    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Country(String countrycode) throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickCountry();
            newadminhomepage.swithToIframe();
            newadmingeographypage.clickCountryLocator(countrycode);
            newadmingeographypage.clickCountrySearchButtonLocator();
            newadmingeographypage.clickCountryRecordLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();



    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Sales_Territory(String territorycode) throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickTerritory();
            newadminhomepage.swithToIframe();
            newadmingeographypage.clickTerritoryLocator(territorycode);
            newadmingeographypage.clickTerritorySearchButtonLocator();
            newadmingeographypage.clickTerritoryRecordLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();

    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Station(String stationcode) throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickStation();
            newadminhomepage.swithToIframe();
            newadmingeographypage.selectStationCode(stationcode);
            newadmingeographypage.clickStationSearchButtonLocator();
            newadmingeographypage.clickStationRecordLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();

    }

    @Test (dataProvider="SearchProvider",dataProviderClass= TestNGDataProvider.class, dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryFailureTest.class)
    public void Search_For_Nationality(String countryCode) throws InterruptedException {


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            AdminGeographyPageMethods newadmingeographypage = PageFactory.initElements(driver, AdminGeographyPageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.clickToogleMenu();
            newadminhomepage.mouseHoweMaintenance();
            newadminhomepage.mouseHoweGeography();
            newadminhomepage.clickNationality();
            newadminhomepage.swithToIframe();
            newadmingeographypage.clickNationalityLocator(countryCode);
            newadmingeographypage.clickNationalitySearchButtonLocator();
            newadmingeographypage.clickNationalityRecordLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();
            driver.navigate().refresh();

    }

    @Test (dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryAnalyzerCount.class)
    public void Log_Out_From_The_PSS_Admin(){


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.gotologgedInUserinfor();
            newadminhomepage.clickLogoutButton();



    }




}
