package PSS_Pages.PSS_Home_Page;

import org.testng.Assert;

import java.io.IOException;

public class AdminHomePageMethods extends AdminHomePageObjects{

    public AdminHomePageMethods() throws IOException {
    }

    public void gotologgedInUserinfor() {
        explicitWaitElementVisible (userinfo);
        mouseHover(userinfo);
        //System.out.println(userinfo.getText());
    }

    public void clickToogleMenu () throws InterruptedException {
        explicitWaitElementVisible(tooglemenu);
        explicitWaitElementClickable(tooglemenu);
        sleeping(5000);
        click(tooglemenu);
    }

    public void mouseHoweMaintenance () {
        fluentWaitElementVisible(maintenancetab);
        mouseHover(maintenancetab);
    }

    public void mouseHoweDashBooard () {
        fluentWaitElementVisible(dashboard);
        mouseHover(dashboard);
    }

    public void assertDashBoard () {
        explicitWaitElementVisible(dashboard);
        Assert.assertTrue(dashboard.isDisplayed());
    }

    public void assertDashBoardShortCut () {
        explicitWaitElementVisible(dashboardshortcut);
        Assert.assertTrue(dashboardshortcut.isDisplayed());
    }

    //img[@class='airlineLogo']

    public void mouseHoweSecurity () {

        mouseHover(security);
    }

    public void clickrole () {
        explicitWaitElementVisible(role);
        click(role);
    }

    public void swithToIframe (int index) throws InterruptedException {
        sleeping(2000);
        driver.switchTo().frame(index);

    }

    public void swithToDefault () {
        driver.switchTo().defaultContent();

    }





    public void clickFunctionUsage () {
        explicitWaitElementVisible(functionalUsage);
        click(functionalUsage);
    }

    public void mouseHoweGeography () {
        mouseHover(geography);
    }

    public void clickAirport () {

        airport.click();
    }

    public void clickAirportDST () {
        airportDST.click();
    }

    public void clickCity () {
        city.click();
    }

    public void clickCountry () {
        country.click();
    }

    public void clickTerritory () {
        territory.click();
    }

    public void clickStation () {
        station.click();
    }

    public void clickNationality () {
        nationality.click();
    }



    public void clickLogoutButton () {

        logoutbutton.click();
    }



}
