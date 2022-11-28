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
    public void Log_In_To_The_PSS_Admin(String username, String password) throws InterruptedException {


            AdminLoginPageObjects newadminloginpage = PageFactory.initElements(driver, AdminLoginPageObjects.class);
            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            newadminloginpage.enterUsername(username);
            newadminloginpage.enterPassword(password);
            newadminloginpage.clickLoginbutton();
            newadminhomepage.assertDashBoard();
            switchToFrameWithIndex(0);
            newadminhomepage.assertDashBoardShortCut();

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
            newadminhomepage.swithToIframe(1);
            newadminrolepage.enterRoleName(rolename);
            newadminrolepage.clickRoleSearchButton();
            newadminrolepage.clickRoleName();
            newadminrolepage.assertRolePageContent();
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
            newadminhomepage.swithToIframe(1);
            newadminsecuritypage.clickUnAssignedFunctionRadioButton();
            newadminsecuritypage.clickFunctionalSearchButton();
            newadminsecuritypage.assertFunctionalSearchResultGrid();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();


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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.clickAirportCodeFieldLocator(airportCode);
            newadmingeographypage.clickAirportSearchButtonLocator();
            newadmingeographypage.clickAirportLocator();
            newadmingeographypage.assertAirportDetails();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();


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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.clickAddAirportButtonLocator();
            newadmingeographypage.assertAirportDetails();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();


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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.clickAirportDSTSearchButtonLocator();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();


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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.clickAddAirportDSTButtonLocator();
            newadmingeographypage.assertAddDST();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();



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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.selectcountry(countryName);
            newadmingeographypage.clickCitySearchButtonLocator();
            newadmingeographypage.clickCityLocator();
            newadmingeographypage.assertCityDetails();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();


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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.clickCountryLocator(countrycode);
            newadmingeographypage.clickCountrySearchButtonLocator();
            newadmingeographypage.clickCountryRecordLocator();
            newadmingeographypage.assertCountryDetails();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();



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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.clickTerritoryLocator(territorycode);
            newadmingeographypage.clickTerritorySearchButtonLocator();
            newadmingeographypage.clickTerritoryRecordLocator();
            newadmingeographypage.assertTerritoryDetails();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();

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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.selectStationCode(stationcode);
            newadmingeographypage.clickStationSearchButtonLocator();
            newadmingeographypage.clickStationRecordLocator();
            newadmingeographypage.assertStationDetails();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();

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
            newadminhomepage.swithToIframe(1);
            newadmingeographypage.clickNationalityLocator(countryCode);
            newadmingeographypage.clickNationalitySearchButtonLocator();
            newadmingeographypage.clickNationalityRecordLocator();
            newadmingeographypage.assertNationalityDetails();
            newadminhomepage.swithToDefault();
            checkTheNotificationMessage();

    }

    @Test (dependsOnMethods = {"Log_In_To_The_PSS_Admin"}, retryAnalyzer = RetryAnalyzerCount.class)
    public void Log_Out_From_The_PSS_Admin(){


            AdminHomePageMethods newadminhomepage = PageFactory.initElements(driver, AdminHomePageMethods.class);
            driver.navigate().refresh();
            newadminhomepage.gotologgedInUserinfor();
            newadminhomepage.clickLogoutButton();



    }




}
