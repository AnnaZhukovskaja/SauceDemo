package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Test
    public void checkSortingFromAToZ() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.selectSortingFromAToZ();
        assertTrue(productsPage.isProductsSortedFromAToZ(),"Products are not sorted from A to Z.");
    }

    @Test
    public void checkSortingFromZToA() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.selectSortingFromZToA();
        assertTrue(productsPage.isProductsSortedFromZToA(),"Products are not sorted from Z to A.");
    }

    @Test
    public void checkSortingFromLowToHigh() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.selectSortingFromLowToHigh();
        assertTrue(productsPage.isProductsSortedFromLowToHigh(),"Products are not sorted from Low to High.");
    }

    @Test
    public void checkSortingFromHighToLow() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.selectSortingFromHighToLow();
        assertTrue(productsPage.isProductsSortedFromHighToLow(),"Products are not sorted from High to Low.");
    }

    @Test
    public void logOut() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openMenu();
        productsPage.logOut();
        assertTrue(loginPage.isDisplayedLoginButton(),"Logout is not successful");
    }
}
