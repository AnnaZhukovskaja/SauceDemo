package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        assertEquals(cartPage.checkProductName(), "Sauce Labs Bike Light", "Wrong product has been added into the cart");
        assertEquals(cartPage.checkProductPrice(), "$9.99", "Incorrect product price.");
    }

}
