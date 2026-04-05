package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // Ensure driver binary is available for the local Chrome installation
        WebDriverManager.chromedriver().setup();

        // Add options required by some Chrome/Chromium versions when launched by newer Selenium
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Launch the browser
        WebDriver driver = new ChromeDriver(options);
        // WebDriver driver = new EdgeDriver();

        try {
            // open url
            driver.get("https://toolsqa.com/");

            List<WebElement> imgs = driver.findElements(By.tagName("img"));
            System.out.println("Images: " + imgs.size());

        } finally {
            // Quit the browser to free resources
            driver.quit();
        }
    }
}
