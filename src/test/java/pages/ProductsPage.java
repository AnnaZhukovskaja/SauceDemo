package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String product) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        driver.findElement(CART_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
    }

    public void selectSortingFromAToZ() {
        WebElement dropDownMenu = driver.findElement(PRODUCT_SORT_CONTAINER);
        Select select = new Select(dropDownMenu);
        dropDownMenu.click();
        select.selectByVisibleText("Name (A to Z)");
    }

    public  void selectSortingFromZToA() {
        WebElement dropDownMenu = driver.findElement(PRODUCT_SORT_CONTAINER);
        Select select = new Select(dropDownMenu);
        dropDownMenu.click();
        select.selectByVisibleText("Name (Z to A)");
    }

    public  void selectSortingFromLowToHigh() {
        WebElement dropDownMenu = driver.findElement(PRODUCT_SORT_CONTAINER);
        Select select = new Select(dropDownMenu);
        dropDownMenu.click();
        select.selectByVisibleText("Price (low to high)");
    }

    public  void selectSortingFromHighToLow() {
        WebElement dropDownMenu = driver.findElement(PRODUCT_SORT_CONTAINER);
        Select select = new Select(dropDownMenu);
        dropDownMenu.click();
        select.selectByVisibleText("Price (high to low)");
    }

    public ArrayList<String> getProductNames() {
        List<WebElement> allProductElements = driver.findElements(PRODUCT_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductElements) {
            names.add(product.getText());
        }
        return names;
    }

    public boolean isProductsSortedFromAToZ() {
        ArrayList<String> namesWithoutSorting = getProductNames();
        Collections.sort(namesWithoutSorting);
        selectSortingFromAToZ();
        ArrayList<String> namesWithSorting = getProductNames();
        return namesWithoutSorting.equals(namesWithSorting);
    }

    public boolean isProductsSortedFromZToA() {
        ArrayList<String> namesWithoutSorting = getProductNames();
        Collections.sort(namesWithoutSorting);
        selectSortingFromZToA();
        ArrayList<String> namesWithSorting = getProductNames();
        namesWithSorting.sort(Collections.reverseOrder());
        return namesWithoutSorting.equals(namesWithSorting);
    }

    public boolean isProductsSortedFromLowToHigh() {
        ArrayList<String> pricesWithoutSorting = getProductsPrice();
        Collections.sort(pricesWithoutSorting);
        selectSortingFromLowToHigh();
        ArrayList<String> pricesWithSorting = getProductNames();
        return pricesWithoutSorting.equals(pricesWithSorting);
    }

    public ArrayList<String> getProductsPrice() {
        List<WebElement> allProductElements = driver.findElements(PRODUCT_PRICE);
        ArrayList<String> prices = new ArrayList<>();
        for (WebElement product: allProductElements) {
            prices.add(product.getText());
        }
        return prices;
    }

    public boolean isProductsSortedFromHighToLow() {
        ArrayList<String> pricesWithoutSorting = getProductsPrice();
        Collections.sort(pricesWithoutSorting);
        pricesWithoutSorting.sort(Collections.reverseOrder());
        selectSortingFromHighToLow();
        ArrayList<String> pricesWithSorting = getProductNames();
        return pricesWithoutSorting.equals(pricesWithSorting);
    }

    public void openMenu() {
        driver.findElement(MENU_BUTTON).click();
    }

    public void logOut() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

}
