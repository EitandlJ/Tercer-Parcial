package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Espera de 10 segundos
        PageFactory.initElements(driver, this);
    }

    // XPath del botón de filtros
    By filterButton = By.xpath("//*[@id='header_container']/div[2]/div/span/select");
    By cartButton = By.xpath("//*[@id='shopping_cart_container']/a");

    // Método para hacer clic en el botón de filtros
    public void clickFilterButton() {
        WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        filterElement.click();
    }

    // Método para seleccionar la opción de orden
    public void selectSortOption(String option) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(filterButton));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    // Método para verificar que el producto está desplegado
    public void verifyProductDisplayed(String productName) {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + productName + "']")));
        if (!product.isDisplayed()) {
            throw new AssertionError("El producto " + productName + " no está visible en la página de inicio");
        }
    }

    // Método para agregar un producto al carrito
    public void addToCart(String product) {
        By addToCartButton;
        switch (product) {
            case "Sauce Labs Backpack":
                addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
                break;
            case "Sauce Labs Bike Light":
                addToCartButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
                break;
            default:
                throw new IllegalArgumentException("Producto no reconocido: " + product);
        }
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartElement.click();
    }

    // Método para hacer clic en el carrito
    public void clickCartButton() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(this.cartButton));
        cartButton.click();
    }


}
