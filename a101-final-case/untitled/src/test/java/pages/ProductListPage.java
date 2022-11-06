package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductListPage {

    WebDriver driver;

    By listPageCorrect = By.xpath("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']");
    By products = By.xpath("//h3[@type='comfort']");

    public ProductListPage(WebDriver driver){
        this.driver = driver;
    }

    public void Scroll() {
        driver.findElement(listPageCorrect);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void getProduct() {
        findAll(products).get(0).click();
    }

    public void getSecondProduct(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        findAll(products).get(1).click();
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

}
