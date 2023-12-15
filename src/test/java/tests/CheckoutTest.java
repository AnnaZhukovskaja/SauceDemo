package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest{

    @Test(description = "Успешный ввод данных")
    public void successfulCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.isOpened();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","Ivanov","12345");
        assertEquals(checkoutPage.getTitle(),
                "Checkout: Overview",
                "Check out is not successfully.");
    }

    @Test(description = "Проверка на ввод данных пользователя без указания First name")
    public void emptyFirstNameCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("","Ivanov","12345");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: First Name is required",
                "Error. Check out is successfully without First Name.");
    }

    @Test(description = "Проверка на ввод данных пользователя без указания Last name")
    public void emptyLastNameCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","","12345");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Last Name is required",
                "Error. Check out is successfully without Last Name");
    }

    @Test(description = "Проверка на ввод данных пользователя без указания Zip/Postal code")
    public void emptyZipPostalCodeCheckout() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","Ivanov","");
        assertEquals(checkoutPage.getErrorMessage(),
                "Error: Postal Code is required",
                "Error. Check out is successfully without Postal Code");
    }

    @Test(description = "Проверка что после успешного оформления заказа есть сообщение: «Thank you\n" +
            "   for your order!»")
    public void successfulOrderMessage() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        checkoutPage.openCheckout();
        checkoutPage.checkout("Ivan","Ivanov","12345");
        checkoutPage.completeOrder();
        assertEquals(checkoutPage.getMessage(),
                "Thank you for your order!",
                "The order is not issued.");
    }
}
