package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    WebDriver driver;
    final String BASE_URL = "https://www.saucedemo.com/";
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }
}
