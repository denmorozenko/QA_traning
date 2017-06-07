package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dreamer on 6/5/2017.
 */
public class Cart extends BasePage{
    WebDriverWait wait;

    @FindBy(css = "h1[id*='page-title']")
    private WebElement insideCartItemNumber;

    @FindBy(xpath = ".//p[@class='item-title']/a")
    private WebElement itemNameInCart;

    @FindBy(css = "a[class*='remove next-previous-assigned']")
    private WebElement removeSign;

    @FindBy(xpath = ".//li[@class='info']")
    private WebElement emptyCartText;


    public Cart(WebDriver driver) {
        super(driver);
    }

    public WebElement getInsideCartItemNumber() {
        return insideCartItemNumber;
    }

    public WebElement getItemNameInCart() {
        return itemNameInCart;
    }

    public Cart removeFromcart() {
        removeSign.click();
        return this;
    }

    public WebElement getEmptyCartText() {
        WebElement userLogoutDropDown = waitForElementClickable(emptyCartText);
        return userLogoutDropDown;
    }
}
