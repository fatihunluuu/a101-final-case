package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class CartPage {
    WebDriver driver;
    By buttonCart = By.xpath("//span[@id='shoppingCart']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCartPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");

        driver.findElement(buttonCart).click();
    }
}
