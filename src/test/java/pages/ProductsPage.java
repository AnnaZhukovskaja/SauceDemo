package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

        private final By TITLE = By.cssSelector(".title");
        private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
        private final By CART_LINK = By.id("shopping_cart_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        return  driver.findElement(TITLE).getText();
    }

    public void addToCart(String product){
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN,product));
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(CART_LINK).click();
    }
}
