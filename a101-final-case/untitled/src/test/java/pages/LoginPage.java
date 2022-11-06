package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    By userEmail = By.xpath("//input[@id='txtUserName']");
    By submitButton = By.xpath("//button[@type='submit']");
    By userPass = By.xpath("//input[@type='password']");
    By loginButton = By.xpath("//button[@type='submit']");


    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public void Login(String email, String pass) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement user = driver.findElement(userEmail);
        user.click();
        user.sendKeys(email);
        driver.findElement(submitButton).click();

        WebElement userP = driver.findElement(userPass);
        userP.click();
        userP.sendKeys(pass);
        driver.findElement(loginButton).click();

    }

}
