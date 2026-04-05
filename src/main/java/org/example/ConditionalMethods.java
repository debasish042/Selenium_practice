package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ConditionalMethods {
    public static void main(String[] args) {

        // use args at least once to avoid 'unused parameter' warning
        System.out.println("Starting ConditionalMethods (args length=" + args.length + ")");

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://practice.expandtesting.com/radio-buttons");

            // Use an explicit wait to wait for the element to appear in the DOM and be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By locator = By.xpath("//*[text()='Radio Buttons page for Automation Testing Practice']");

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                // timeout or other issue — we'll handle it below with a safe check
            }

            // Safe check: use findElements to avoid NoSuchElementException
            List<WebElement> matches = driver.findElements(locator);

            // Use stream().findFirst() to follow IDE suggestion for a "getFirst" style
            boolean isDisplayed = matches.stream()
                    .findFirst()
                    .map(WebElement::isDisplayed)
                    .orElse(false);

            if (isDisplayed) {
                System.out.println("Element is displayed");
            } else {
                System.out.println("Element is not displayed or not present yet");
            }

            // small pause so you can visually confirm when running locally
            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        } finally {
            // always quit the browser
            try {
                driver.quit();
            } catch (Exception ignored) {}
        }
    }
}
