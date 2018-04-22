package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BaseFunctions {

    public WebDriver driver;
    private static final String FIREFOX_DRIVER_LOCATION = "C:/chromedriver.exe";
    private static final Logger LOGGER =LogManager.getLogger(BaseFunctions.class);

    public BaseFunctions(){
        LOGGER.info("Setting FirefoxDriver location: " + FIREFOX_DRIVER_LOCATION);
        System.setProperty("webdriver.chrome.driver", FIREFOX_DRIVER_LOCATION );
        LOGGER.info("Starting FirefoxDriver");
        this.driver = new ChromeDriver();
        LOGGER.info("Maximazie browser window size");
        driver.manage().window().maximize();
    }
    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public void getUrl(String url){
        driver.get(url);
    }

    public void CloseBrowser(){
        driver.quit();
    }
}