package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWait {

    /*
    *
    * Advantages --
    * 1.it is based on the condition so it will work more effectively
    * 2. it will wait for condition to be true , then consider time
    * 3. we need to write multiple statements for multiple elements
    *
    * */

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            driver.manage().window().maximize();

            WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Username']")));

            username.sendKeys("Admin");
            WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Password']")));
            password.sendKeys("admin123");

            WebElement loginButton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));
            loginButton.click();

        } finally {
            try { driver.quit(); } catch (Exception ignored) {}
        }
    }
}
