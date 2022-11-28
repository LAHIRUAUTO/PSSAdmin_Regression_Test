package PSS_Pages.PSS_Geography_Page;

import Utilities.GenericUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminGeographyPageObjects extends GenericUtils {

    @FindBy (xpath = "//input[@name='airportCode']")
    WebElement airportCodeFieldLocator;

    @FindBy (xpath = "//span[@class='spn-action search-btn']")
    WebElement airportSearchButtonLocator;

    @FindBy (xpath = "//td[normalize-space()='HMB']")
    WebElement airportLocator;

    @FindBy (xpath = "//input[@id='displayName']")
    WebElement airportName;




    @FindBy (xpath = "//span[@class='spn-action add-btn']")
    WebElement addAirportButtonLocator;

    @FindBy (xpath = "//span[@class='spn-action search-btn']")
    WebElement airportDSTSearchButtonLocator;

    @FindBy (xpath = "//button[@id='btnAdd']")
    WebElement addAirportDSTButtonLocator;

    @FindBy (xpath = "//span[@title='Select options']")
    WebElement cityInDST;




    @FindBy (xpath = "//select[@id='country']")
    WebElement countryField;

    @FindBy (xpath = "//button[@id='btnSearch']")
    WebElement searchCityButtonLocator;



    @FindBy (xpath = "/html[1]/body[1]/section[1]/section[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[2]")
    WebElement cityLocator;

    @FindBy (xpath = "//input[@id='cityNameAddEdit']")
    WebElement cityName;






    @FindBy (id = "countryCode")
    WebElement countryCodeLocator;

    @FindBy (xpath = "//button[@id='btnSearch']")
    WebElement countrySearchButtonLocator;



    @FindBy (xpath = "//td[normalize-space()='EG']")
    WebElement countryRecordLocator;

    @FindBy (xpath = "//input[@id='countryNameAddEdit']")
    WebElement countryName;




    @FindBy (xpath = "//input[@id='salesTerritoryCode']")
    WebElement territoryCodeLocator;

    @FindBy (xpath = "//button[@id='btnSearch']")
    WebElement territorySearchButtonLocator;

    @FindBy (xpath = "//td[normalize-space()='CAIRO']")
    WebElement territoryRecordLocator;

    @FindBy (xpath = "//input[@id='salesTerritoryNameAddEdit']")
    WebElement territoryName;



    @FindBy (id = "sltStationCity")
    @CacheLookup
    WebElement stationCodeLocator;

    @FindBy (xpath = "//span[@class='spn-action search-btn']")
    WebElement stationSearchButtonLocator;

    @FindBy (xpath = "//td[normalize-space()='CAI']")
    WebElement stationRecordLocator;

    @FindBy (xpath = "//input[@id='stationName']")
    WebElement stationName;




    @FindBy (xpath = "//input[@id='countryName']")
    WebElement nationalityCodeLocator;

    @FindBy (xpath = "//button[@id='btnSearch']")
    WebElement nationalitySearchButtonLocator;

    @FindBy (xpath = "//td[normalize-space()='Egypt']")
    WebElement nationalityRecordLocator;

    @FindBy (xpath = "//input[@id='nationalityNameAddEdit']")
    WebElement nationalityName;


}
