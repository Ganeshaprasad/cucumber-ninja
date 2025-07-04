package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
  protected  static WebDriver driver;
  protected static SoftAssert softAssert;

    protected WebDriverWait wait;
    //can be used by child class so added protected and made it static bcs same instance shared across all classes
    Actions actions;



    public void doHover(WebElement element)
    {
        actions=new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void waitForVisibilityOfElement(WebElement element,int seconds)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String readDataFromPropertyFile(String filename, String key) throws IOException {
        FileInputStream fis =new FileInputStream("src/test/resources/"+filename);
        Properties p= new Properties();
        p.load(fis);
        return p.getProperty(key);
    }
}
