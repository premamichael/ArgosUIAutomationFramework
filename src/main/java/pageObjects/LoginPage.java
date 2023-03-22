package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="email-address")
    public WebElement emailTxtFld;

    @FindBy(id = "current-password")
    public WebElement passwordTxtFld;

    @FindBy(xpath = "//button[text()='Sign in securely']")
    public WebElement signInBtn;

    @FindBy(className = "alert__message")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@data-bdd-test-id='global-error']")
    public WebElement errorIcon;

    public void enterEmailAddress(String email)
    {
        emailTxtFld.sendKeys(email);
    }
    public void enterPassword(String password)
    {
        passwordTxtFld.sendKeys(password);
    }
    public void clickSignInBtn()
    {
        signInBtn.click();
    }

    public void verifySignInPageLanding(String expectedPageTitle)
    {
        Assert.assertEquals(expectedPageTitle,driver.getTitle());
    }

    public void verifyInvalidLogin()
    {
        //Assert.assertEquals(expectedMessage,errorMessage.getText());
        Assert.assertTrue(driver.findElement(By.className("rc-image-tile-33")).isDisplayed());
    }

}
