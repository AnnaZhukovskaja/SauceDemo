package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Parameters({"browser"})
    @BeforeMethod(description = "Настройка браузера")
    public void setup(@Optional("chrome") String browser, ITestContext iTestContext) {
        log.info("Setup browser");
        System.out.println(System.getProperty("t"));
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            driver = new ChromeDriver(options);
        }
        else if(browser.equalsIgnoreCase("opera")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        iTestContext.setAttribute("driver",driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Закрытие браузера")
    public void tearDown() {
        log.info("Closing the browser");
        driver.quit();
    }
}
