package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignedHomePage;

import java.time.Duration;

public class LoginTestSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    SignedHomePage signedHomePage=new SignedHomePage(driver);

    @Given("I am on home page {string} with page title {string}")
    public void openHomePage(String url, String pageTitle) {
        driver.get(url);
        driver.findElement(By.id("consent_prompt_submit")).click();
        homePage.verifyHomePageLanding(pageTitle);
    }

    @When("I click account button and get redirected to sign in page with title {string}")
    public void clickAccountButton(String pageTitle) {
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Account']")));
        homePage.clickAccountBtn();
        loginPage.verifySignInPageLanding(pageTitle);
    }

    @When("I enter email address {string} and password {string}")
    public void enterValidCredentials(String email, String password) {
        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-address")));
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
    }

    @Then("I click Sign In Securely button and get redirected to home page")
    public void verifyLogin() {
        loginPage.clickSignInBtn();
        //WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        //WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("gCblM")));
        //signedHomePage.verifySignedHomePageLanding(firstName);
    }
    @Then("I click Sign In Securely button and get error message is displayed")
    public void verifyInvalidLogin()
    {
        loginPage.clickSignInBtn();
        loginPage.verifyInvalidLogin();

    }
}