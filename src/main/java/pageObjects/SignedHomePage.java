package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignedHomePage {
    public WebDriver driver;
    public SignedHomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "gCblM")
    public WebElement name;




    public void verifySignedHomePageLanding(String expectedName)
    {
        //Assert.assertEquals(expectedName,name.getText());
       //Assert.assertTrue(name.getText().contains(expectedName));
        Assert.assertTrue(name.getText().contains(expectedName));
    }


}
