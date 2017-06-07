package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dreamer on 6/5/2017.
 */
public class ProductPage extends BasePage {
    WebDriverWait wait;

    @FindBy(css = "h1[class*='fn title']")
    private WebElement itemTitle;

    @FindBy(xpath = ".//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front default-dialog has-title add2cartpopup']/.//div[@class='item-box']/div[@class='item-name']")
    private WebElement popupTitle;

    @FindBy(xpath = ".//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front default-dialog has-title add2cartpopup']/.//div[@class='item-box']/.//a[@class='regular-button cart']")
    private WebElement vievCarButton;



    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getItemTitle() {
        return itemTitle;
    }

    public WebElement getPopupProductTitle() {
        WebElement popup = waitForElementClickable(popupTitle);
        return popup;
    }

    public ProductPage submitOrder(){
        getItemTitle().submit();
        return this;
    }

    public Cart goToCart() {
        vievCarButton.click();
        return PageFactory.initElements(driver, Cart.class);
    }
}
