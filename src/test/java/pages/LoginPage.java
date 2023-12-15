package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
@Log4j2
public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public void open() {
        log.info("Opening login page");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Login by {user}")
    public void login(String user,String password) {
        log.info("Login by {user}");
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        //takeScreenshot(driver);
    }

    @Step("Getting an error when data is filled in incorrectly")
    public String getError() {
        log.info("Getting an error when data is filled in incorrectly");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Checking checking that the login button is displayed")
    public boolean isDisplayedLoginButton() {
        log.info("Checking checking that the login button is displayed");
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Attachment(value = "screenshot", type = "image/png")
    private static byte[] takeScreenshot(WebDriver driver) {
        log.info("Taking screenshot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
