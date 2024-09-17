package stepDefinitions;

import pages.ProductPage;
import Utilities.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertTrue;

public class ProductSteps {
    WebDriver driver;
    ProductPage productPage;

    public ProductSteps() {
        this.driver = DriverManager.getDriver().driver;
        PageFactory.initElements(driver, this);
        productPage = new ProductPage(driver);
    }

    @When("I click on the Bolt Product")
    public void iClickOnTheBoltProduct() {
        productPage.clickBoltProduct();
    }

    @Then("The Bolt product page should be displayed")
    public void isproductPageDisplayed() {
        String expectedURL = "https://www.saucedemo.com/inventory-item.html?id=1";
        String actualTitle = driver.getCurrentUrl();
        Assert.assertEquals("La página no está desplegada", expectedURL, actualTitle);
    }
}
