package stepDefinitions;

import pages.CheckoutCompletePage;
import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompleteSteps {
    WebDriver driver;
    CheckoutCompletePage checkoutCompletePage;

    public CheckoutCompleteSteps() {
        this.driver = DriverManager.getDriver().driver;
        PageFactory.initElements(driver, this);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @When("I add the product1 {string} to the cart")
    public void iAddTheProductToTheCart(String product) {
        checkoutCompletePage.addToCart(product);
    }

    @When("I fill in the checkout fields with first name {string} last name {string} and postal code {string}")
    public void iFillInTheCheckoutFields(String firstName, String lastName, String postalCode) {
        checkoutCompletePage.fillCheckoutFields(firstName, lastName, postalCode);
    }

    @Then("I click on the finish button")
    public void iClickOnTheFinishButton() {
        checkoutCompletePage.clickFinishButton();
    }
}
