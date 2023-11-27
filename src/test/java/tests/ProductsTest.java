package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {

    @Test(description = "Должна быть возможность купить продукт",retryAnalyzer = Retry.class)
    public void buyProduct() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        assertEquals(cartPage.checkProductName(), "Sauce Labs Bike Light", "Wrong product has been added into the cart");
        assertEquals(cartPage.checkProductPrice(), "$9.99", "Incorrect product price.");
    }

    @Test(description = "Проверка корректной работы сортировки по Name(A-Z)")
    public void checkSortingFromAToZ() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.sort("Name (A to Z)");
        assertEquals(productsPage.getProductNames().get(0),"Sauce Labs Backpack","Products are not sorted from A to Z.");
        assertEquals(productsPage.getProductNames().get(5),"Test.allTheThings() T-Shirt (Red)","Products are not sorted from A to Z.");
    }

    @Test(description = "Проверка корректной работы сортировки по Name(Z-A)")
    public void checkSortingFromZToA() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.sort("Name (Z to A)");
        assertEquals(productsPage.getProductNames().get(0),"Test.allTheThings() T-Shirt (Red)","Products are not sorted from Z to A.");
        assertEquals(productsPage.getProductNames().get(5),"Sauce Labs Backpack","Products are not sorted from Z to A.");
    }

    @Test(description = "Проверка корректной работы сортировки по Price (low to high)")
    public void checkSortingFromLowToHigh() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.sort("Price (low to high)");
        assertEquals(productsPage.getProductNames().get(0), "Sauce Labs Onesie","Products are not sorted from Low to High.");
        assertEquals(productsPage.getProductNames().get(5), "Sauce Labs Fleece Jacket","Products are not sorted from Low to High.");
    }

    @Test(description = "Проверка корректной работы сортировки по Price (high to low)")
    public void checkSortingFromHighToLow() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.sort("Price (high to low)");
        assertEquals(productsPage.getProductNames().get(0),"Sauce Labs Fleece Jacket","Products are not sorted from High to Low.");
        assertEquals(productsPage.getProductNames().get(5),"Sauce Labs Onesie","Products are not sorted from High to Low.");
    }

    @Test(description = "Проверить возможность выхода пользователя из личного кабинета (Logout)")
    public void logOut() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        productsPage.openMenu();
        productsPage.logOut();
        assertTrue(loginPage.isDisplayedLoginButton(),"Logout is not successful");
    }
}
