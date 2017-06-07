package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by denis on 31.05.17.
 */
public class StorePage extends BasePage{
    WebDriverWait wait;

    @FindBy(xpath = ".//*[@id='content']/div/div/div[3]")
    private WebElement catalog;
    @FindBy(css = "div[class*='productid-16']")
    private WebElement cartItem;
    @FindBy(css = ".btn.regular-button.regular-main-button.add2cart.submit")
    private WebElement addToCartButton;
    @FindBy(xpath = ".//*[@class='dropdown header_bar-my_account']")
    private WebElement logoutDropDown;
    @FindBy(css = ".dropdown-menu>.account-link-logoff")
    private WebElement logOutButton;

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogoutDropDown() {
        return logoutDropDown;
    }

    public void logoutFromUserPage() {
        logoutDropDown.click();
        waitForElementClickable(logOutButton).click();
    }

    public StorePage getStorePage(String userLogin, String userPassword) {
        new UserAuthorizationPage(driver)
                .OpenUserAuthorizationPage()
                .waitAndClickSingIn()
                .loginIntoSite(userLogin, userPassword)
                .submitForm();

        waitForElementClickable(logoutDropDown);
        return PageFactory.initElements(driver, StorePage.class);
    }

    public ProductPage addItemsToCart(){
        catalog.click();
        cartItem.click();
        return PageFactory.initElements(driver, ProductPage.class);
    }
}
