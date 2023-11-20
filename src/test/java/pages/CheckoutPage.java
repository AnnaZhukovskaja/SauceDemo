package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void open() {
        driver.get(BASE_URL + "checkout-step-one.html");
    }

    public void openCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void checkout(String firstName,String lastName, String zipPostalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();}

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void completeOrder() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String getMessage() {
        return driver.findElement(TEXT_MESSAGE).getText();
    }
}
