package PSS_Pages.PSS_Security_Page;

import Utilities.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminSecurityPageObjects extends Utils {

    @FindBy (xpath = "/html/body/section/section[1]/section[2]/section/div[1]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]")
    @CacheLookup
    WebElement roleNameLocator;

    @FindBy (xpath = "//*[@id=\"roleName\"]")
    @CacheLookup
    WebElement roleNameFieldLocator;

    @FindBy (xpath = "//*[@id=\"btnSearch\"]")
    @CacheLookup
    WebElement roleSearchButtonLocator;

    @FindBy (xpath = "//input[@id='RP_UnassignedFunction']")
    @CacheLookup
    WebElement unAssignedFunctionRadioButton;

    @FindBy (xpath = "//span[@class='spn-action search-btn']")
    WebElement functionSearchButtonLocator;


}