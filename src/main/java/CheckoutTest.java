import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutTest {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting Test: E-Commerce Add to Cart Flow");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        try {
            driver.get("https://www.saucedemo.com/");

            System.out.println("Executing: Login with valid credentials");

            WebElement username = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            username.sendKeys("standard_user");
            password.sendKeys("secret_sauce");
            loginButton.click();



            System.out.println("Executing: Adding 'Onesie' to the cart");

            WebElement addToCartButton = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie"));

            addToCartButton.click();

            System.out.println("Executing: Verifying cart badge");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


            WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));


            if(cartBadge.isDisplayed() && cartBadge.getText().equals("1")) {
                System.out.println("PASS: Cart badge successfully updated to 1.");
            }
            else {
                System.out.println("FAIL: Cart badge is not updated.");
            }

            System.out.println("Executing: Verifying item in cart page");

            WebElement cartLink = driver.findElement((By.className("shopping_cart_link")));
            cartLink.click();

            WebElement cartItemName = driver.findElement(By.className("inventory_item_name"));

            if (cartItemName.getText().equals("Sauce Labs Onesie")) {
                System.out.println("PASS: Onesie is correctly displaying in the cart.");
            } else {
                System.out.println("FAIL: Incorrect item in cart.");
            }

            Thread.sleep(3000);

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
