package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import pages.*;

import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestWithRegister {

    static Logger logger = Logger.getLogger(TestWithRegister.class);
    static WebDriver driver;
    static Actions actions;

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    By searchBox = By.xpath("//input[@class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']");
    By searchButton = By.xpath("//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']");


    @BeforeClass
    public static void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-insecureCerts");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        actions = new Actions(driver);
        DOMConfigurator.configure("log4j.xml");

    }


    @Test
    public void T1_entry() {
        homePage.goWebsite();
        logger.info("hepsiburada.com sitesine giri?? yap??ld??.");
    }
    @Test
    public void T2_loginButton() {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement log = driver.findElement(By.xpath("//div[@id='myAccount']"));
        actions.moveToElement(log).perform();

        WebElement loginPage = driver.findElement(By.xpath("//a[@id='login']"));
        loginPage.click();
        Boolean loginAssert = driver.findElement(By.xpath("//div[@class='_2q4oJzGUsyLIOBhRdWWO9D']")).isDisplayed();
        Assert.assertTrue("Not on login page!",loginAssert);

        logger.info("Giri?? yap butonuna t??kland??");
    }

    @Test
    public void T3_createAccount() {
        loginPage.Login("fatihunluu37@hotmail.com","Fatih.unlu37");
        logger.info("Giri?? yap sekmesinden giri?? yap??ld??.");
    }

    @Test
    public void T4_searchProduct() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement search = driver.findElement(searchBox);
        search.click();
        search.sendKeys("Iphone");
        driver.findElement(searchButton).click();
        logger.info("Arama k??sm??ndan ??r??n arand??.");

    }

    @Test
    public void T5_ScrollDown() {
        productListPage.Scroll();
    }

    @Test
    public void T6_selectProduct() {
        Boolean productListAssert = driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']")).isDisplayed();
        Assert.assertTrue("Not on product list page!", productListAssert);
        productListPage.getProduct();
        logger.info("??r??nler listelendi ve bir tanesi se??ildi.");
    }

    @Test
    public void T7_productAddCart() {
        productPage.addToCart();
        Boolean productPageAssert = driver.findElement(By.xpath("//button[@id='addToCart']")).isDisplayed();
        Assert.assertTrue("Not on product page!", productPageAssert);
        logger.info("Se??ilen ??r??n sepete eklendi.");
    }

    @Test
    public void T8_secondProductAddToCart(){
        productListPage.getSecondProduct();
        productPage.secondAddToCart();
        Boolean productPageAssert = driver.findElement(By.xpath("//button[@id='addToCart']")).isDisplayed();
        Assert.assertTrue("Not on product page!", productPageAssert);
        logger.info("??kinci ??r??n se??ildi ve sepete eklendi");
    }

    @Test
    public void T9_goToCart() {
        cartPage.goToCartPage();
        Boolean cartPageAssert = driver.findElement(By.xpath("//button[@id='continue_step_btn']")).isDisplayed();
        Assert.assertTrue("Not on cart page!", cartPageAssert);
        logger.info("Sepete gidildi ve iki farkl?? sat??c??dan ??r??nler eklendi.");
    }

}
