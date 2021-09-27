package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 5/30/2017.
 */
public class AdminPage extends BasePage{
    @FindBy(xpath = ".//div[@id='leftMenu']/.//li[@class='menu-item add-new icon']")
    private WebElement addNewUserPlusSign;
    @FindBy(xpath = ".//li[@class='menu-item add-new icon']/.//li[@class='menu-item add-user icon']")
    private WebElement addNewUserButton;
    @FindBy(css = "[id*=login]")
    private WebElement login;
    @FindBy(css = "[id*=password]")
    private WebElement password;
    @FindBy(css = "[id*=password-conf]")
    private WebElement passwordConf;
    @FindBy(xpath = ".//*[@id='status-messages']/ul/li")
    private WebElement userAddedMessage;
    static String locator = ".//*[@id='status-messages']/ul/li";

    public static String getLocator() {
        return locator;
    }

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public AdminPage createNewUser(String newUserName, String mail, String userPassword) {
        clickOnElement(addNewUserPlusSign);
        clickOnElement(addNewUserButton);

        WebElement newUserLogin = waitForElementClickable(login);
        clearAndTypeToElement(newUserName+getCurrentDate()+mail, newUserLogin);
        clearAndTypeToElement(userPassword,password);
        clearAndTypeToElement(userPassword,passwordConf);

        passwordConf.submit();
        return this;
    }

    public void clickOnElement(WebElement webElement) {
        webElement.click();
    }

    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        return dateFormat.format(date);
    }


}
