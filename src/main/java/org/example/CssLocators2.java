package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssLocators2 {

    static void main() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");


        driver.findElement(By.cssSelector("#username")).sendKeys("student");
        driver.findElement(By.cssSelector("#password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("#submit")).click();


        


    }
}
