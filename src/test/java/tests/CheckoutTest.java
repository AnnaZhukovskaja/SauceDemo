package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest{

    @Test
    public void successfulCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","Ivanov","12345");
        assertEquals(checkoutPage.getTitle(),"Checkout: Overview","Check out is not successfully.");
    }

    @Test
    public void emptyFirstNameCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("","Ivanov","12345");
        assertEquals(checkoutPage.getErrorMessage(),"Error: First Name is required","Error. Check out is successfully without First Name.");
    }

    @Test
    public void emptyLastNameCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","","12345");
        assertEquals(checkoutPage.getErrorMessage(),"Error: Last Name is required","Error. Check out is successfully without Last Name");
    }

    @Test
    public void emptyZipPostalCodeCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","Ivanov","");
        assertEquals(checkoutPage.getErrorMessage(),"Error: Postal Code is required","Error. Check out is successfully without Postal Code");
    }

    @Test
    public void successfulOrderMessage() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","Ivanov","12345");
        checkoutPage.completeOrder();
        assertEquals(checkoutPage.getMessage(),"Thank you for your order!", "The order is not issued.");
    }
}
