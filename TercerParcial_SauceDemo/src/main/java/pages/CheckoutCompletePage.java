package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera explícita de 10 segundos
        PageFactory.initElements(driver, this);
    }

    // Localizadores
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By finishButton = By.id("finish");
    By continueButton = By.id("continue");

    // Localizador del botón "Add to Cart"
    By backpackButton = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    By bikeLightButton = By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']");

    // Método para llenar los campos de checkout
    public void fillCheckoutFields(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void addToCart(String product) {
        By addToCartButton;
        switch (product) {
            case "Sauce Labs Bolt T-Shirt":
                addToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
                break;
            case "Sauce Labs Fleece Jacket":
                addToCartButton = By.id("add-to-cart-sauce-labs-fleece-jacket");
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                addToCartButton = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
                break;
            default:
                throw new IllegalArgumentException("Producto no reconocido: " + product);
        }
        driver.findElement(addToCartButton).click();
    }

    // Método para hacer clic en el botón de continuar
    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    // Método para agregar el producto "Sauce Labs Backpack" al carrito
    public void addBackpackToCart() {
        WebElement addToCartBackpack = wait.until(ExpectedConditions.elementToBeClickable(backpackButton));
        addToCartBackpack.click();
    }

    // Método para agregar el producto "Sauce Labs Bike Light" al carrito
    public void addBikeLightToCart() {
        WebElement addToCartBikeLight = wait.until(ExpectedConditions.elementToBeClickable(bikeLightButton));
        addToCartBikeLight.click();
    }
}
