package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by user on 5/30/2017.
 */
public abstract class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    protected void clearAndTypeToElement(String text, WebElement webElement) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public WebElement waitForElementPresence(String locator) {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public WebElement waitForElementClickable(WebElement webElement) {
        wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
