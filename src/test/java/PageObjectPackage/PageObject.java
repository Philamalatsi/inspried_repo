package PageObjectPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    static WebElement element = null;

    public static WebElement acceptCookies(WebDriverWait wait) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='button cookies-banner-module_dismiss-button_24Z98']")));
        return element;
    }

    public static WebElement searchTxt(WebDriverWait wait) throws InterruptedException {
        Thread.sleep(1500);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        return element;
    }

    public static WebElement submitSearch(WebDriverWait wait){
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        return element;
    }

    public static WebElement addToCart(WebDriverWait wait){
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Add to Cart'])[1]")));
        return element;
    }

    public static WebElement cutButton(WebDriverWait wait) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'mini-cart-button')]")));
        return element;
    }

    public static WebElement cartPage(WebDriverWait wait) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Shopping Cart']")));
        return element;
    }

    public static WebElement addedWatch(WebDriverWait wait) {
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='cart-item-module_item-title_1M9cq']")));
        return element;
    }
}