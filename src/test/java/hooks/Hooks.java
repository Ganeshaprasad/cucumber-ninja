package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class Hooks extends BaseTest {
    @Before
    public void setUp() throws IOException {

        if (readDataFromPropertyFile("config.properties", "browser").equalsIgnoreCase("chrome")) {
            ChromeOptions options= new ChromeOptions();
            if(readDataFromPropertyFile("config.properties","headless").equals("true"))
            {
                options.addArguments("--headless");
            }
            driver = new ChromeDriver();
        }
        else if (readDataFromPropertyFile("config.properties", "browser").equalsIgnoreCase("firefox")) {
            FirefoxOptions options= new FirefoxOptions();
            if(readDataFromPropertyFile("config.properties","headless").equals("true"))
            {
                options.addArguments("--headless");
            }
            driver=new FirefoxDriver(options);
        }
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    }







    @After
    public void tearDown() {
        if (driver != null && softAssert != null) {
            softAssert.assertAll();
            driver.quit();
        }
    }
}
