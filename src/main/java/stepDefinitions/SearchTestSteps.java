package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ProductPage;
import pageObjects.SearchPage;

public class SearchTestSteps extends CommonFunctions {

    SearchPage searchPage=new SearchPage(driver);
    ProductPage productPage=new ProductPage(driver);

    @When("I enter valid product name {string}")
    public void enterProductName(String productName)
    {
        searchPage.enterSearchText(productName);
    }

    @When("I click search button")
    public void clickSearchButton()
    {
        searchPage.clickSearchButton();
    }

    @Then("I get redirected to that product page with page heading {string}")
    public void verifyValidSearch(String pageHeading)
    {
        productPage.verifyProductPageLanding(pageHeading);
    }

    @When("I enter invalid product name {string}")
    public void enterInvalidProductName(String invalidName)
    {
        searchPage.enterSearchText(invalidName);
    }

    @Then("I get error message")
    public  void verifyInvalidSearch()
    {
        searchPage.verifyInvalidSearch();
    }

    @Then("auto suggestion will be displayed")
    public void verifyAutoSuggestion()
    {
        searchPage.verifyAutoSuggestion();
    }
}
