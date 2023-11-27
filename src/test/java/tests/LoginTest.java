package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка успешной регистрации")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertEquals(productsPage.getTitle(),"Products","User is not logged in or wrong page is open");
    }

    @DataProvider(name = "Данные для логина")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "Данные для логина",description = "Негативные проверка регистрации")
    public void negativeLogin(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user,password);
        assertEquals(loginPage.getError(),expectedError, "User is not logged in or wrong notification");
    }

    @Test(description = "Проверка регистрации без указания Username")
    public void emptyUserLogin() {
        loginPage.open();
        loginPage.login("","");
        assertEquals(loginPage.getError(),"Epic sadface: Username is required", "User is not logged in or wrong notification");
    }

    @Test(description = "Проверка регистрации без указания Password")
    public void emptyUserPassword() {
        loginPage.open();
        loginPage.login("standard_user","");
        assertEquals(loginPage.getError(),"Epic sadface: Password is required", "User is not logged in or wrong notification");
    }

    @Test(description = "Проверка регистрации заблокированного пользователя")
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        assertEquals(loginPage.getError(),"Epic sadface: Sorry, this user has been locked out.", "User has been locked out");
    }
}

