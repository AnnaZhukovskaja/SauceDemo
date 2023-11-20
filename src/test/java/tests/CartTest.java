package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void removeProduct() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.removeProduct("Sauce Labs Bike Light");
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bike Light"), "The Remove button  didn't remove the product from the cart.");
    }

    @Test
    public void productShouldBeNotRemoveInCartAfterExitingTheCart() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.openPageAllProducts();
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bike Light"), "The products were not saved in the cart");
    }

    @Test
    public void allProductShouldBeHaveRightPrice() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.open();

        assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"),"$9.99","The price is incorrect");
        assertEquals(cartPage.getProductPrice("Sauce Labs Onesie"),"$7.99","The price is incorrect");
        assertEquals(cartPage.getProductPrice("Sauce Labs Backpack"),"$29.99","The price is incorrect");
        assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"),"$15.99","The price is incorrect");
        assertEquals(cartPage.getProductPrice("Sauce Labs Fleece Jacket"),"$49.99","The price is incorrect");
        assertEquals(cartPage.getProductPrice("Test.allTheThings() T-Shirt (Red)"),"$15.99","The price is incorrect");
    }
}
