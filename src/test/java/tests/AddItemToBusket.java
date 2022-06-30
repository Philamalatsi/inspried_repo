package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static PageObjectPackage.PageObject.*;

public class AddItemToBusket{
    public ChromeDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void startUpAction() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\f5408474\\IdeaProjects\\inspired\\src\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.takealot.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (driver.findElements(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']")).size() > 0){
            acceptCookies(wait).click();
        }
    }

    @Test
    public void searchAndAddToBusket(){
        try {
            searchTxt(wait).sendKeys("Skone Men's Rochester Watch - Brown");
            submitSearch(wait).click();
            addToCart(wait).click();
            cutButton(wait).click();
            Assert.assertEquals(cartPage(wait).getText(), "Shopping Cart");
            Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Proceed to Checkout']")).isDisplayed());
            Assert.assertTrue(addedWatch(wait).getText().contains("Skone Men's Rochester Watch - Brown"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}