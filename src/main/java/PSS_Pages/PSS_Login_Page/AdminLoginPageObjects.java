package PSS_Pages.PSS_Login_Page;

import Utilities.GenericUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class AdminLoginPageObjects extends GenericUtils {


    @FindBy(xpath="//input[@id='j_username']")
    @CacheLookup
    private WebElement usernamelocator;

    public void enterUsername (String username) {
        usernamelocator.sendKeys(username);

    }

    @FindBy(xpath="//input[@id='j_password']")
    @CacheLookup
    private WebElement passwordlocator;

    public void enterPassword (String password) {

        passwordlocator.sendKeys(password);
    }

    @FindBy(xpath="//input[@id='btnLogin']")
    @CacheLookup
    private WebElement loginButtonlocator;

    public void clickLoginbutton (){
        explicitWaitElementClickable(loginButtonlocator);
        click(loginButtonlocator);

    }

    public String title (){
        driver.getTitle();
        return title();
    }

    public AdminLoginPageObjects() throws IOException {
    }
}
