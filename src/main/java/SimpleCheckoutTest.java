import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SimpleCheckoutTest {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting Test: E-Commerce Add to Cart Flow");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();


        By by_username = By.id("user-name");
        By by_password = By.id("password");
        By by_login_btn = By.id("login-button");
        By by_add_cart_btn = By.cssSelector("#add-to-cart-sauce-labs-onesie");
        By by_cart_badge = By.cssSelector(".shopping_cart_badge");
        By by_cart_link = By.className("shopping_cart_link");
        By by_inv_item_name = By.className("inventory_item_name");

        try {
            driver.get("https://www.saucedemo.com/");

            System.out.println("Executing: Login with valid credentials");

            driver.findElement(by_username).sendKeys("standard_user");
            driver.findElement(by_password).sendKeys("secret_sauce");
            driver.findElement(by_login_btn).click();

            System.out.println("Executing: Adding 'Onesie' to the cart");

            driver.findElement(by_add_cart_btn).click();

            System.out.println("Executing: Verifying cart badge");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


            WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(by_cart_badge));


            if(cartBadge.isDisplayed() && cartBadge.getText().equals("1")) {
                System.out.println("PASS: Cart badge successfully updated to 1.");
            }
            else {
                System.out.println("FAIL: Cart badge is not updated.");
            }

            System.out.println("Executing: Verifying item in cart page");

            driver.findElement(by_cart_link).click();

            if (driver.findElement(by_inv_item_name).getText().equals("Sauce Labs Onesie")) {
                System.out.println("PASS: Onesie is correctly displaying in the cart.");
            } else {
                System.out.println("FAIL: Incorrect item in cart.");
            }


        }
        catch (Exception e) {
            System.out.println("TEST FAILED due to an exception: " + e.getMessage());
        }
        finally {
            System.out.println("Ending Test: E-Commerce Add to Cart Flow");
            driver.quit();
        }

    }

}
