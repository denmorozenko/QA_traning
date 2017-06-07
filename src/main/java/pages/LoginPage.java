package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 5/30/2017.
 */
public class LoginPage extends BasePage{

    private String adminURL = "https://personal.x-cart.com/denmorozenko1gmailcom/admin.php?target=login";

    private WebElement login;

    private WebElement password;

    @FindBy(css="button[class*=submit]")
    private WebElement submitButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage OpenXCartAdmin() {
        driver.get(adminURL);
        return this;
    }

    public LoginPage loginIntoSite(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        return this;
    }

    private void enterPassword(String passwordString) {
        clearAndTypeToElement(passwordString, password);
    }

    private void enterLogin(String loginName) {
        clearAndTypeToElement(loginName, login);
    }

    public AdminPage submitForm() {
        password.submit();
        return PageFactory.initElements(driver, AdminPage.class);
    }

    public AdminPage loginButtonSubmit(){
        submitButton.click();
        return PageFactory.initElements(driver, AdminPage.class);
    }
}
