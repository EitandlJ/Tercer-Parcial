package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // XPaths de elementos en la página de checkout
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.xpath("//*[@id='continue']");
    By errorMessage = By.xpath("//h3[@data-test='error']");

    // Métodos para interactuar con la página de checkout
    public void fillCheckoutFields(String lastName, String postalCode) {
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement error = driver.findElement(errorMessage);
        return error.isDisplayed();
    }

    public String getErrorMessageText() {
        WebElement error = driver.findElement(errorMessage);
        return error.getText();
    }
}
