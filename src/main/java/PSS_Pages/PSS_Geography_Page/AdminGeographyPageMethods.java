package PSS_Pages.PSS_Geography_Page;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AdminGeographyPageMethods extends AdminGeographyPageObjects{

    public void clickAirportCodeFieldLocator (String airportCode) {
        explicitWaitElementVisible(airportCodeFieldLocator);
        airportCodeFieldLocator.sendKeys(airportCode);
    }

    public void clickAirportSearchButtonLocator () {
        explicitWaitElementClickable(airportSearchButtonLocator);
        airportSearchButtonLocator.click();
    }

    public void clickAirportLocator () {
        explicitWaitElementVisible(airportLocator);
        doubleClick(airportLocator);
    }

    public void assertAirportDetails () {
        explicitWaitElementVisible(airportName);
        Assert.assertTrue(airportName.isDisplayed());
    }

    public void clickAddAirportButtonLocator () {

        explicitWaitElementVisible(addAirportButtonLocator);
        addAirportButtonLocator.click();
    }

    public void clickAirportDSTSearchButtonLocator () {
        explicitWaitElementClickable(airportDSTSearchButtonLocator);
        airportDSTSearchButtonLocator.click();
    }

    public void clickAddAirportDSTButtonLocator () {
        explicitWaitElementClickable(addAirportDSTButtonLocator);
        addAirportDSTButtonLocator.click();
    }

    public void assertAddDST () {
        explicitWaitElementClickable(cityInDST);
        Assert.assertTrue(cityInDST.isDisplayed());
    }

    public void selectcountry (String country) {
        Select selectCountry = new Select(countryField);
        selectCountry.selectByVisibleText(country);
    }

    public void clickCitySearchButtonLocator () {
        explicitWaitElementClickable(searchCityButtonLocator);
        searchCityButtonLocator.click();
    }

    public void clickCityLocator () {
        explicitWaitElementVisible(cityLocator);
        doubleClick(cityLocator);
    }

    public void assertCityDetails () {
        explicitWaitElementVisible(cityName);
        Assert.assertTrue(cityName.isDisplayed());
    }



    public void clickCountryLocator (String countrycode) {
        explicitWaitElementVisible(countryCodeLocator);
        countryCodeLocator.sendKeys(countrycode);
    }

    public void clickCountrySearchButtonLocator () {
        explicitWaitElementClickable(countrySearchButtonLocator);
        countrySearchButtonLocator.click();
    }

    public void clickCountryRecordLocator () {
        explicitWaitElementClickable(countryRecordLocator);
        doubleClick(countryRecordLocator);
    }

    public void assertCountryDetails () {
        explicitWaitElementVisible(countryName);
        Assert.assertTrue(countryName.isDisplayed());
    }

    public void clickTerritoryLocator (String stationcode) {
        explicitWaitElementVisible(territoryCodeLocator);
        territoryCodeLocator.sendKeys(stationcode);
    }

    public void clickTerritorySearchButtonLocator () {
        explicitWaitElementClickable(territorySearchButtonLocator);
        territorySearchButtonLocator.click();
    }

    public void clickTerritoryRecordLocator () {
        explicitWaitElementClickable(territoryRecordLocator);
        doubleClick(territoryRecordLocator);
    }

    public void assertTerritoryDetails () {
        explicitWaitElementVisible(territoryName);
        Assert.assertTrue(territoryName.isDisplayed());
    }

    public void selectStationCode(String stationCode) {

        selectByTextVisible(stationCodeLocator,stationCode );
    }

    public void clickStationSearchButtonLocator () {
        explicitWaitElementClickable(stationSearchButtonLocator);
        stationSearchButtonLocator.click();
    }

    public void clickStationRecordLocator () {
        explicitWaitElementClickable(stationRecordLocator);
        doubleClick(stationRecordLocator);
    }

    public void assertStationDetails () {
        explicitWaitElementVisible(stationName);
        Assert.assertTrue(stationName.isDisplayed());
    }

    public void clickNationalityLocator (String countryCode) {
        explicitWaitElementVisible(nationalityCodeLocator);
        nationalityCodeLocator.sendKeys(countryCode);
    }

    public void clickNationalitySearchButtonLocator () {
        explicitWaitElementClickable(nationalitySearchButtonLocator);
        nationalitySearchButtonLocator.click();
    }

    public void clickNationalityRecordLocator () {
        explicitWaitElementClickable(nationalityRecordLocator);
        doubleClick(nationalityRecordLocator);
    }

    public void assertNationalityDetails () {
        explicitWaitElementVisible(nationalityName);
        Assert.assertTrue(nationalityName.isDisplayed());
    }


}
