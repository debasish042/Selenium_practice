package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkRadioButtoms {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try{

            driver.manage().window().maximize();
            driver.get("https://practice.expandtesting.com/radio-buttons");

            // Use the input element ids instead of label text; labels can be overlapped and cause click intercept
            By blueInput = By.id("blue");
            By yellowInput = By.id("yellow");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // wait until inputs are present and clickable
            wait.until(ExpectedConditions.presenceOfElementLocated(blueInput));
            wait.until(ExpectedConditions.presenceOfElementLocated(yellowInput));

            WebElement radio1 = driver.findElement(blueInput);
            WebElement radio2 = driver.findElement(yellowInput);

            System.out.println("Before selecting the radio buttons:");
            System.out.println(radio1.isSelected());
            System.out.println(radio2.isSelected());

            // ensure visible / clickable and attempt normal click; fallback to JS click if intercepted
            try {
                wait.until(ExpectedConditions.elementToBeClickable(blueInput));
                radio1.click();
            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                // scroll into view and try JS click
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radio1);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radio1);
            }

            // wait up to 5s for the radio to become selected (avoids Thread.sleep and flakiness)
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            try {
                shortWait.until(d -> d.findElement(blueInput).isSelected());
                System.out.println("After selecting the first radio button:");
                System.out.println(driver.findElement(blueInput).isSelected());
            } catch (org.openqa.selenium.TimeoutException te) {
                System.out.println("Timed out waiting for radio button to become selected");
                // print current state for debugging
                System.out.println("After attempt, selected? " + driver.findElement(blueInput).isSelected());
            }

        } finally {
            driver.quit();
        }

    }
}
