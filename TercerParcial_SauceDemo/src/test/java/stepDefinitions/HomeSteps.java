package stepDefinitions;

import pages.HomePage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomeSteps {
    WebDriver driver;
    HomePage homePage;

    public HomeSteps() {
        this.driver = DriverManager.getDriver().driver;
        PageFactory.initElements(driver, this);
        homePage = new HomePage(driver);
    }

    @When("I click on the filter button")
    public void iClickOnTheFilterButton() {
        homePage.clickFilterButton();
    }

    @When("I select the option to sort from Z to A")
    public void iSelectTheOptionToSortFromZToA() {
        homePage.selectSortOption("Name (Z to A)");
    }

    @When("I add the product {string} to the cart")
    public void iAddTheProductToTheCart(String product) {
        homePage.addToCart(product);
    }

    @And("I click on the cart button")
    public void iClickOnTheCartButton() {
        homePage.clickCartButton();
    }

    @When("The home page should be displayed")
    public void the_home_page_should_be_displayed() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("La página de inicio no está desplegada", expectedTitle, actualTitle);
    }

    @Then("The product {string} should be displayed in the home page")
    public void the_product_should_be_displayed_in_the_home_page(String productName) {
        homePage.verifyProductDisplayed(productName);
    }
}
