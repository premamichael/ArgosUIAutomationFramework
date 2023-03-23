package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public WebDriver driver;
    public ProductPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[text()='Jeans']")
    public WebElement pageHeading;

    public void verifyProductPageLanding(String expectedPageHeading)
    {
        Assert.assertEquals(expectedPageHeading,pageHeading.getText());
    }
}
