package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test(description = "Проверка , что можно удалить заказ из корзины")
    public void removeProduct() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        cartPage.removeProduct("Sauce Labs Bike Light");
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bike Light"), "The Remove button  didn't remove the product from the cart.");
    }

    @Test(description = "Проверить, что после перехода(кнопка Continue Shopping) из корзины(Cart) к списку товарок в  товары не удаляются")
    public void productShouldBeNotRemoveInCartAfterExitingTheCart() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.continueShopping();
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.open();
        assertTrue(cartPage.getProductsName().contains("Sauce Labs Bike Light"), "The products were not saved in the cart");
    }

    @Test(description = "Проверить, что после покупки 6 товаров в корзине все цены товаров верные")
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
