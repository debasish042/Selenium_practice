package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CssLocators {

    public static void main(String[] args) {

        // Ensure driver binary is available for the local Chrome installation
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // Some Chromium/Chrome versions require this option when launching from newer Selenium
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            // Use an explicit wait to ensure fields are present before interacting
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for username and password fields, then perform login once
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
            driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
            driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button")));
            driver.findElement(By.cssSelector("#login-button")).click();

            // Wait for a known element on the landing page after login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inventory_container, .inventory_list")));

        } finally {
            // Ensure the browser is always closed
            /*driver.quit();*/
        }
    }
}
