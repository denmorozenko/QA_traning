package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * Created by user on 5/19/2017.
 */
public class WebDriverFactory {

    public static WebDriver getDriverInstance(String browserName) {
        WebDriver driver;
        switch(browserName){
            case BrowserType.CHROME:
                driver = setUpChromeInstance();
                break;
            default:
                throw new IllegalArgumentException(String.format("%s is not valid browser name", browserName));
        }
        return driver;
    }

    private static WebDriver setUpChromeInstance() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/main/resources/chromedriver");

        DesiredCapabilities chromeDriverCapabilities = getChromeDesiredCapabilities();

        return new ChromeDriver(chromeDriverCapabilities);
    }


    private static DesiredCapabilities getChromeDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
        desiredCapabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        return desiredCapabilities;
    }
}
