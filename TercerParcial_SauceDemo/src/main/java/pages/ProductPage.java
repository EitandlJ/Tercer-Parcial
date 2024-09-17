package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;


    By boltProduct = By.id("item_1_title_link");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBoltProduct() {
        driver.findElement(boltProduct).click();
    }

}
