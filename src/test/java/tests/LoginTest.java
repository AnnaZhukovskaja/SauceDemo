package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void succesfulLogin() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertEquals(productsPage.getTitle(),"Products","User is not logged in or wrong page is open");

    }

    @Test
    public void emptyUserPassword() {
        loginPage.open();
        loginPage.login("standard_user","");
        assertEquals(loginPage.getError(),"Epic sadface: Password is required", "User is not logged in or wrong notification");
    }

    @Test
    public void emptyUserLogin() {
        loginPage.open();
        loginPage.login("","");
        assertEquals(loginPage.getError(),"Epic sadface: Username is required", "User is not logged in or wrong notification");
    }

    @Test
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        assertEquals(loginPage.getError(),"Epic sadface: Sorry, this user has been locked out.", "User has been locked out");
    }
}
