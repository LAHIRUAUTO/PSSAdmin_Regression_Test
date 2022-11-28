package PSS_Pages.PSS_Security_Page;

import Utilities.GenericUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminSecurityPageObjects extends GenericUtils {

    @FindBy (xpath = "/html/body/section/section[1]/section[2]/section/div[1]/div/div/div[3]/div[3]/div/table/tbody/tr[2]/td[2]")
    @CacheLookup
    WebElement roleNameLocator;

    @FindBy (xpath = "//*[@id=\"roleName\"]")
    @CacheLookup
    WebElement roleNameFieldLocator;

    @FindBy (xpath = "//*[@id=\"btnSearch\"]")
    @CacheLookup
    WebElement roleSearchButtonLocator;

    @FindBy (xpath = "//div[@class='availableDiv']")
    @CacheLookup
    WebElement availablePrivilegeGridLocator;

    @FindBy (xpath = "//div[@class='selectedDiv']")
    @CacheLookup
    WebElement assignedPrivilegeGridLocator;

    @FindBy (xpath = "//input[@id='RP_UnassignedFunction']")
    @CacheLookup
    WebElement unAssignedFunctionRadioButton;

    @FindBy (xpath = "//span[@class='spn-action search-btn']")
    @CacheLookup
    WebElement functionSearchButtonLocator;

    @FindBy (xpath = "//div[@id='jqgh_tblFunctionsNoRole_privilegeCategory']")
    @CacheLookup
    WebElement functionSearchResultGrid;



}
