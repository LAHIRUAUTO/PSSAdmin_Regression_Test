package PSS_Pages.PSS_Security_Page;

import org.testng.Assert;

public class AdminSecurityPageMethods extends AdminSecurityPageObjects {

    public void clickRoleName () {
        explicitWaitElementVisible(roleNameLocator);
        doubleClick(roleNameLocator);
    }

    public void enterRoleName (String rolename) {
        explicitWaitElementVisible(roleNameFieldLocator);
        roleNameFieldLocator.sendKeys(rolename);
    }

    public void clickRoleSearchButton() {
        explicitWaitElementVisible(roleSearchButtonLocator);
        roleSearchButtonLocator.click();
    }

    public void assertRolePageContent() {
        explicitWaitElementVisible(availablePrivilegeGridLocator);
        explicitWaitElementVisible(assignedPrivilegeGridLocator);
        Assert.assertTrue(availablePrivilegeGridLocator.isDisplayed() && assignedPrivilegeGridLocator.isDisplayed());


    }



    public void clickUnAssignedFunctionRadioButton () {
        unAssignedFunctionRadioButton.isSelected();
        unAssignedFunctionRadioButton.click();
    }

    public void clickFunctionalSearchButton () {
        explicitWaitElementClickable(functionSearchButtonLocator);
        functionSearchButtonLocator.click();
    }

    public void assertFunctionalSearchResultGrid () {
        explicitWaitElementClickable(functionSearchResultGrid);
        Assert.assertTrue(functionSearchResultGrid.isDisplayed());
    }


}
