package pageObjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[text()='Account']")
    public WebElement accountBtn;

        public void clickAccountBtn()
    {
        accountBtn.click();
    }

    public void verifyHomePageLanding(String expectedPageTitle)
    {
        Assert.assertEquals(expectedPageTitle,driver.getTitle());
    }

}
