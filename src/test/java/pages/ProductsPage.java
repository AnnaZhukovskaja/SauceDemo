package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
@Log4j2
public class ProductsPage extends BasePage {
    private final By TITLE = By.cssSelector(".title");
    private final String ADD_TO_CART_PATTERN = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private final By CART_LINK = By.id("shopping_cart_container");
    private final By PRODUCT_SORT_CONTAINER = By.cssSelector("[data-test='product_sort_container']");
    private final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    private final By PRODUCT_PRICE = By.cssSelector(".inventory_item_price");
    private final By MENU_BUTTON = By.cssSelector(".bm-burger-button");
    private final By LOGOUT_BUTTON = By.cssSelector("#logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening products page")
    public void open() {
        log.info("Opening products page");
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("Getting title Products")
    public String getTitle() {
        log.info("Getting title Products");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    @Step("Adding products in the cart")
    public void addToCart(String product) {
        log.info("Adding products in the cart");
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    @Step("Opening the cart")
    public void openCart() {
        log.info("Opening the cart");
        driver.findElement(CART_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

    @Step("Sorting products")
    public void sort(String sorting) {
        log.info("Sorting products");
        WebElement dropDownMenu = driver.findElement(PRODUCT_SORT_CONTAINER);
        Select select = new Select(dropDownMenu);
        dropDownMenu.click();
        select.selectByVisibleText(sorting);
    }

    @Step("Getting a list of product names")
    public ArrayList<String> getProductNames() {
        log.info("Getting a list of product names");
        List<WebElement> allProductElements = driver.findElements(PRODUCT_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductElements) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Getting a list of product price")
     public ArrayList<String> getProductsPrice() {
        log.info("Getting a list of product price");
        List<WebElement> allProductElements = driver.findElements(PRODUCT_PRICE);
        ArrayList<String> prices = new ArrayList<>();
        for (WebElement product: allProductElements) {
            prices.add(product.getText());
        }
        return prices;
    }

    @Step("Opening menu")
      public void openMenu() {
        log.info("Opening menu");
        driver.findElement(MENU_BUTTON).click();
    }

    @Step("Logout")
    public void logOut() {
        log.info("Logout");
        driver.findElement(LOGOUT_BUTTON).click();
    }

}
