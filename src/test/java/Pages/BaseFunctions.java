package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseFunctions {

    public WebDriver driver;
    private static final String FIREFOX_DRIVER_LOCATION = "C:/geckodriver.exe";
    private static final Logger LOGGER =LogManager.getLogger(BaseFunctions.class);

    public BaseFunctions(){
        LOGGER.info("Setting FirefoxDriver location: " + FIREFOX_DRIVER_LOCATION);
        System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_LOCATION );
        LOGGER.info("Starting FirefoxDriver");
        this.driver = new FirefoxDriver();
        LOGGER.info("Maximazie browser window size");
        driver.manage().window().maximize();
    }

    public void getUrl(String url){
        driver.get(url);
    }
}