package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    private final By PRODUCT_PRICE = By.cssSelector(".inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "cart.html");
    }

    public String checkProductName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String checkProductPrice() {
        return driver.findElement(PRODUCT_PRICE).getText();
    }

}
