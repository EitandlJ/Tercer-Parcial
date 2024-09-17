package stepDefinitions;

import pages.CheckoutPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSteps {
    WebDriver driver;
    CheckoutPage checkout1Page;

    By checkoutButton = By.xpath("//*[@id=\"checkout\"]");

    public CheckoutSteps() {
        this.driver = DriverManager.getDriver().driver;
        checkout1Page = new CheckoutPage(driver);
    }

    @When("I fill in the checkout fields with last name {string} and postal code {string}")
    public void iFillInTheCheckoutFieldsWithLastNameAndPostalCode(String lastName, String postalCode) {
        checkout1Page.fillCheckoutFields(lastName, postalCode);
    }

    @When("I click on the checkout button")
    public void iClickOnTheCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    @And("I click on the continue button")
    public void iClickOnTheContinueButton() {
        checkout1Page.clickContinueButton();
    }

    @Then("I should see an error message for missing first name")
    public void iShouldSeeAnErrorMessageForMissingFirstName() {
        Assert.assertTrue("No se encontró el mensaje de error esperado", checkout1Page.isErrorMessageDisplayed());
        Assert.assertTrue("El mensaje de error no es el esperado",
                checkout1Page.getErrorMessageText().contains("Error: First Name is required"));
    }
}
