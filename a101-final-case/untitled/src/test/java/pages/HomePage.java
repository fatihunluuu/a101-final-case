package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    WebDriver driver;

    By acceptCookies = By.id("onetrust-accept-btn-handler");



    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void goWebsite() {
        driver.get("https://www.hepsiburada.com");
        driver.manage().window().maximize();
        driver.findElement(acceptCookies).click();
    }

}
