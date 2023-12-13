package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class CartPage extends BasePage {

    private final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    private final By PRODUCT_PRICE = By.cssSelector(".inventory_item_price");
    private final String REMOVE_BUTTON_PATTERN = "//*[text()='%s']/ancestor::div[@class='cart_item']//button[text()='Remove']";
    private final By CONTINUE_BUTTON = By.cssSelector("[data-test='continue-shopping']");
    private final String PRODUCTS_PRICES = "//*[text()='%s']/ancestor::div[@class='cart_item']//*[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }
    @Step("Opening cart page")
    public void open() {
        log.info("Opening cart page");
        driver.get(BASE_URL + "cart.html");
    }

    @Step("Checking the product name")
    public String checkProductName() {
        log.info("Checking the product name");
        return driver.findElement(PRODUCT_NAME).getText();
    }

    @Step("Checking the product price")
    public String checkProductPrice() {
        log.info("Checking the product price");
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    @Step("Getting a list of product names")
    public ArrayList<String> getProductsName() {
        log.info("Getting a list of product names");
        List<WebElement> allProductElements = driver.findElements(PRODUCT_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product: allProductElements) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Removing product in the cart")
    public void removeProduct(String product) {
        log.info("Removing product in the cart");
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON_PATTERN,product))).click();
    }

    @Step("Pressing the button CONTINUE")
    public void continueShopping() {
        log.info("Pressing the button CONTINUE");
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Getting the product price")
    public String getProductPrice(String product) {
        log.info("Getting the product price");
        return driver.findElement(By.xpath(String.format(PRODUCTS_PRICES,product))).getText();
    }
}
