package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    private final By PRODUCT_PRICE = By.cssSelector(".inventory_item_price");
    private final String REMOVE_BUTTON = "//button [@data-test ='%s']";
    private final By CONTINUE_BUTTON = By.cssSelector("[data-test='continue-shopping']");
    private final String PRODUCTS_PRICES = "//*[text()='%s']/ancestor::div[@class='cart_item']//*[@class='inventory_item_price']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
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

    public ArrayList<String> getProductsName() {
        List<WebElement> allProductElements = driver.findElements(PRODUCT_NAME);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product: allProductElements) {
            names.add(product.getText());
        }
        return names;
    }

    public void removeProduct(String product) {
        String[] arrayOfWordsInProductName = product.split(" ");
        StringBuilder partOfValueOfProductNameAttribute = new StringBuilder("remove-");
        for (int i = 0; i < arrayOfWordsInProductName.length; i++) {
            partOfValueOfProductNameAttribute.append(arrayOfWordsInProductName[i].toLowerCase());
            partOfValueOfProductNameAttribute.append("-");
        }
        StringBuilder fullValueOfProductNameAttribute = partOfValueOfProductNameAttribute.deleteCharAt(partOfValueOfProductNameAttribute.length()-1);
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON,fullValueOfProductNameAttribute)));
    }

    public void openPageAllProducts() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getProductPrice(String product) {
        return driver.findElement(By.xpath(String.format(PRODUCTS_PRICES,product))).getText();
    }
}
