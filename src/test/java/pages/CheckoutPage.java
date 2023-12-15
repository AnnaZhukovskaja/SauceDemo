package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
@Log4j2
public class CheckoutPage  extends BasePage{

    private final By CHECKOUT_BUTTON = By.cssSelector("[data-test='checkout']");
    private final By FIRST_NAME_INPUT = By.cssSelector("[data-test='firstName']");
    private final By LAST_NAME_INPUT = By.cssSelector("[data-test='lastName']");
    private final By ZIP_POSTAL_CODE_INPUT = By.cssSelector("[data-test='postalCode']");
    private final By CONTINUE_BUTTON = By.cssSelector("[data-test='continue']");
    private final By TITLE = By.cssSelector(".title");
    private final By ERROR_MESSAGE = By.xpath("//*[@id='checkout_info_container']/div/form/div[1]/div[4]/h3");
    private final By FINISH_BUTTON = By.cssSelector("[data-test='finish']");
    private final By TEXT_MESSAGE = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening checkout page")
    public void open() {
        log.info("Opening checkout page");
        driver.get(BASE_URL + "checkout-step-one.html");
    }

    @Step("Opening checkout page")
    public void openCheckout() {
        log.info("Opening checkout page");
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Filling in the data and opening Checkout: Overview ")
    public void checkout(String firstName,String lastName, String zipPostalCode) {
        log.info("Filling in the data and opening Checkout: Overview ");
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
    }

    @Step("Getting title Checkout: Overview")
    public String getTitle() {
        log.info("Getting title Checkout: Overview");
        return driver.findElement(TITLE).getText();}

    @Step("Getting an error when data is filled in incorrectly")
    public String getErrorMessage() {
        log.info("Getting an error when data is filled in incorrectly");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Pressing the button FINISH")
    public void completeOrder() {
        log.info("Pressing the button FINISH");
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Receiving a message when the order is successfully placed")
    public String getMessage() {
        log.info("Receiving a message when the order is successfully placed");
        return driver.findElement(TEXT_MESSAGE).getText();
    }
}
