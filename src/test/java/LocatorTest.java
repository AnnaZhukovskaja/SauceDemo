import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {

    @Test
    public void locatorTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button"));
        driver.findElement(By.name("login-button"));
        driver.findElement(By.className("submit-button btn_action"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Fleece"));
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        driver.findElement(By.xpath("//div[@id='header_container']"));

    }
}
