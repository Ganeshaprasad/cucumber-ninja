package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPOM {

private WebDriver driver;

    public LogInPOM(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='inputPassword']")
    private WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block']")
    private WebElement signin;

    @FindBy(xpath = "//div[@class='user-icon']")
    private WebElement usericon;

    @FindBy(xpath = "//div[@class='dropdown']")
    private WebElement userDropdown;

    @FindBy(xpath = "//div[@class='dropdown-item logout']")
    private WebElement logout;

    @FindBy(xpath = "//div[@class='table-title']//b")
    private WebElement pageTitle;

    @FindBy(xpath = "//h2[@class='card-title text-center mb-4']")
    /** //h2[contains(@class, 'card-title') and contains(@class, 'text-center') and contains(@class, 'mb-4')] **/
    private WebElement signInText;


    public void enterUsername(String username)
    {
        this.username.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        this.password.sendKeys(password);
    }

    public void clickOnSignInButton()
    {
        this.signin.click();
    }

    public WebElement getUsericon()
    {
       return usericon;
    }

    public WebElement getLogout()
    {
        return logout;
    }

    public WebElement getPageTitle()
    {
        return pageTitle;
    }

    public WebElement getSignInText()
    {
        return signInText;
    }

    public WebElement getUserDropdown()
    {
        return userDropdown;
    }

}
