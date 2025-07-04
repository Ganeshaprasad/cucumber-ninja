package stepdefination;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.LogInPOM;

import java.io.IOException;
import java.time.Duration;

public class LogInStepDefination extends BaseTest {

    private LogInPOM logInPOM;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        driver.get("http://49.249.28.218:8098/");
        logInPOM = new LogInPOM(driver);
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() throws IOException {
        String username = readDataFromPropertyFile("config.properties","username");
        String password = readDataFromPropertyFile("config.properties","password");
        logInPOM.enterUsername(username);
        logInPOM.enterPassword(password);
    }

    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        logInPOM.clickOnSignInButton();
    }

    @Then("Page logo text should be {string}")
    public void page_logo_text_should_be(String expectedText) {
        waitForVisibilityOfElement(logInPOM.getPageTitle(),10);
        String actualText = logInPOM.getPageTitle().getText(); // Get the text from the page
        softAssert.assertEquals(actualText,expectedText,"Page title does not match"); // Assertion
    }

    @When("User hovers over the account icon")
    public void user_hovers_over_the_account_icon() {
        doHover(logInPOM.getUsericon());
    }

    @Then("Account Dropdown should be displayed")
    public void account_dropdown_should_be_displayed() {
        waitForVisibilityOfElement(logInPOM.getUserDropdown(),10);
        softAssert.assertEquals(logInPOM.getUserDropdown().isDisplayed(),true,"User dropdown menu is not displaying");
           }

    @When("User clicks on logout button")
    public void user_clicks_on_logout_button() {
        logInPOM.getLogout().click();
    }

    @Then("Sign in menu should be visible")
    public void sign_in_menu_should_be_visible() {
        softAssert.assertEquals(logInPOM.getSignInText().isDisplayed(), true,"Sign in menu is not visible");
    }
}
