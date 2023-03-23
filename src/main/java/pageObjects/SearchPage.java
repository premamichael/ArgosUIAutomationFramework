package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public WebDriver driver;
    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@data-test='search-input']")
    public WebElement searchTxtFld;

    @FindBy(xpath = "//button[@data-test='search-button']")
    public WebElement searchBtn;

    @FindBy(xpath = "//h4[@data-el]")
    public WebElement errorLabel;

    @FindBy(xpath = "//span[text()='Suggested Searches']")
    public WebElement autoSuggestionLabel;

    public void enterSearchText(String search)
    {
        searchTxtFld.sendKeys(search);
    }

    public void clickSearchButton()
    {
        searchBtn.click();
    }
    public void verifyInvalidSearch()
    {
        //Assert.assertTrue(errorLabel.getText().isEmpty());
        Assert.assertFalse(errorLabel.getText().isEmpty());
    }
    public void verifyAutoSuggestion()
    {
        Assert.assertFalse(autoSuggestionLabel.getText().isEmpty());
    }
}
