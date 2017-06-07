package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Created by user on 5/19/2017.
 */
public class BaseUiTest {
    protected WebDriver driver;

    @BeforeMethod
    public void testSetup(){
        String browserName = System.getProperty("browser");

        if(browserName == null){
            throw new IllegalArgumentException("Browser name is null");
        }

        driver = WebDriverFactory.getDriverInstance(browserName);
    }

    @AfterMethod
    public void testTearDown(){
        driver.quit();
    }
}
