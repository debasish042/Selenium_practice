package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BrowserMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://orangehrm.com/");

            Thread.sleep(3000);

            // return the current url of the page
            String parentHandle = driver.getWindowHandle();
            System.out.println("Parent handle: " + parentHandle);

            // click the link that opens a new window/tab
            driver.findElement(By.linkText("Contact Sales")).click();

            // wait for the new window to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> handles = driver.getWindowHandles();
            System.out.println("All window handles: " + handles);

            // switch to the new window (the handle that is not the parent)
            for (String h : handles) {
                if (!h.equals(parentHandle)) {
                    driver.switchTo().window(h);
                    break;
                }
            }

            // Now in child window: get URL and title
            String childUrl = driver.getCurrentUrl();
            String childTitle = driver.getTitle();
            System.out.println("Child window URL: " + childUrl);
            System.out.println("Child window Title: " + childTitle);

            // NOTE: driver.get(url) returns void — it navigates to the given URL.
            // To "get" the current URL as a String, use driver.getCurrentUrl().
            // The following will navigate to the same URL again (no return value):
            driver.get(driver.getCurrentUrl());

            // If you need the page source or other details, capture them explicitly
            String pageSource = driver.getPageSource();
            System.out.println("Page source length: " + pageSource.length());

            // close the child window and switch back to parent
            driver.close();
            driver.switchTo().window(parentHandle);
            System.out.println("Back to parent URL: " + driver.getCurrentUrl());

            try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        } finally {
            if (driver != null) {
                try {
                    driver.quit();
                } catch (Exception ignored) {
                }
            }
        }
    }
}
