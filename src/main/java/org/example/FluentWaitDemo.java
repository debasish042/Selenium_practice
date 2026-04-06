package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {

    // Simple FluentWait example that waits for elements to become visible & enabled
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(org.openqa.selenium.NoSuchElementException.class);

            // Wait for Username field using a Function (classic FluentWait style)
            WebElement username = wait.until(new Function<WebDriver, WebElement>() {
                @Override
                public WebElement apply(WebDriver drv) {
                    WebElement el = drv.findElement(By.xpath("//*[@placeholder='Username']"));
                    return (el.isDisplayed() && el.isEnabled()) ? el : null;
                }
            });

            username.sendKeys("Admin");

            // Wait for Password field using a lambda
            WebElement password = wait.until(drv -> {
                WebElement el = drv.findElement(By.xpath("//*[@placeholder='Password']"));
                return (el.isDisplayed() && el.isEnabled()) ? el : null;
            });

            password.sendKeys("admin123");

            // Wait for Login button and click
            WebElement loginButton = wait.until(drv -> {
                WebElement el = drv.findElement(By.xpath("//*[@type='submit']"));
                return (el.isDisplayed() && el.isEnabled()) ? el : null;
            });

            loginButton.click();

        } catch (org.openqa.selenium.TimeoutException te) {
            System.out.println("Timed out waiting for an element: " + te.getMessage());
            te.printStackTrace();
        } finally {
            try { driver.quit(); } catch (Exception ignored) {}
        }
    }
}

