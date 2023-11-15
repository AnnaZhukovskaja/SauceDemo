package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {

    @Test
    public void locatorTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.tagName("input"));
        driver.findElement(By.className("input_error")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Backpack"));

        //xpath
        //Поиск по атрибуту
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));
        //Поиск по тексту
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        //Поиск по частичному совпадению атрибута
        driver.findElement(By.xpath("//button[contains(@data-test,'add')]"));
        //ancestor
        driver.findElement(By.xpath("//*[@class='inventory_item_price']//ancestor::div[@class='inventory_item']"));
        //descendant
        driver.findElement(By.xpath("//*[@class='inventory_item']//descendant::div[text()='$']"));
        //following
        driver.findElement(By.xpath("//*[@class='inventory_item_label']//following::div[@class='pricebar']"));
        //parent
        driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']//parent::div"));
        //preceding
        driver.findElement(By.xpath("//*[@class='header_label']//preceding::div[@id='menu_button_container']"));
        //*поиск элемента с условием AND
        driver.findElement(By.xpath("//select[@class='product_sort_container' and @data-test='product_sort_container']"));

        //css
        //.class
        driver.findElement(By.cssSelector(".btn"));
       //.class1.class2
        driver.findElement(By.cssSelector(".btn_small.btn_inventory"));
       //.class1 .class2
        driver.findElement(By.cssSelector(".pricebar .btn"));
        //#id
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        //tagname
        driver.findElement(By.cssSelector("footer"));
        //tagname.class
        driver.findElement(By.cssSelector("img,bm-burger-icon"));
        //[attribute=value]
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"));
        //[attribute~=value]
        driver.findElement(By.cssSelector("[name~='jacket']"));
        //[attribute|=value]
        driver.findElement(By.cssSelector("[data-test|='add']"));
        //[attribute^=value]
        driver.findElement(By.cssSelector("button[data-test^='add']"));
        //[attribute$=value]
        driver.findElement(By.cssSelector("button[data-test$='onesie']"));
        //[attribute*=value]
        driver.findElement(By.cssSelector("button[data-test*='shirt']"));
    }
}
