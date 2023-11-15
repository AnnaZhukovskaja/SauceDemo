package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    WebDriver driver;
    final String BASE_URL = "https://www.saucedemo.com/";

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
