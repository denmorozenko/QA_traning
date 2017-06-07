package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by denis on 31.05.17.
 */
public class UserAuthorizationPage extends BasePage {

    private String baseURL = "https://demostore.x-cart.com/";

    @FindBy(css="[id*=login-email]")
    private WebElement loginEnail;

    @FindBy(css="[id*=login-password]")
    private WebElement loginPassword;

    @FindBy(css="[class*=header_bar-sign_in]")
    private WebElement singInButton;

    public UserAuthorizationPage(WebDriver driver) {
        super(driver);
    }

    public UserAuthorizationPage OpenUserAuthorizationPage() {
        driver.get(baseURL);
        return this;
    }

    public UserAuthorizationPage waitAndClickSingIn() {
        waitForElementClickable(singInButton).click();
        return this;
    }

    public void waitAndInputLogin(String userLogin) {
        WebElement email = waitForElementClickable(loginEnail);
        clearAndTypeToElement(userLogin, email);
    }


    public UserAuthorizationPage loginIntoSite(String login, String password) {
        waitAndInputLogin(login);
        clearAndTypeToElement(password, loginPassword);
        return this;
    }

    public StorePage submitForm() {
        loginPassword.submit();
        return PageFactory.initElements(driver, StorePage.class);
    }
}
