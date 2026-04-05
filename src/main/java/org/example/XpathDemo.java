package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            driver.get("https://practicetestautomation.com/practice-test-login/");
             /*// xpath with single attribute
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
            driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password123");
            driver.findElement(By.xpath("//*[@id='submit']")).click();*/

            /*//xpath with multiple attribute

            driver.findElement(By.xpath("//*[@type='text'][@id='username']")).sendKeys("student");
            driver.findElement(By.xpath("//*[@name='password'][@id='password']")).sendKeys("Password123");
            driver.findElement(By.xpath("//*[@class='btn'][@id='submit']")).click();*/

            //xpath with and operator and or operator

         /*   driver.findElement(By.xpath("//*[@type='text' and @id='username']")).sendKeys("student");
            driver.findElement(By.xpath("//*[@name='password' or @id='password']")).sendKeys("Password123");
            driver.findElement(By.xpath("//*[@class='btn' and @id='submit']")).click();*/

            // xpath with inner text

            /*driver.findElement(By.xpath("//a[text()='Practice']")).click();*/




           /* // xpath with contains
            // Correct usage of contains() is contains(@attr,'value'), not @contains(...)
            driver.findElement(By.xpath("//*[contains(@id,'username')]"))
                    .sendKeys("student");
            driver.findElement(By.xpath("//*[contains(@name,'password')]"))
                    .sendKeys("Password123");
            driver.findElement(By.xpath("//*[contains(@class,'btn') and @id='submit']")).click();*/

            /*
            * using inner text --

              driver.findElement(By.xpath("//*[text()='username']")).sendKeys("username");


              using contains method ---

              driver.findElement(By.xpath("//*[contains(@id,'username')]")).sendKeys("username");
              *
              * driver.findElement(By.xpath("//*[contains(text(),'')]"));
              *
              * driver.findElement(By.xpath("//*[contains(.,'')]"));
              *
              * check if there is any element present with blank text
              *
              *
              *

*
*

           using starts-with ---

           driver.findElement(By.xpath("//*[starts-with(@id,'username')]")).sendKeys("username");
            *
            * */


            // by using chained xpath

         /* boolean status=  driver.findElement(By.xpath("//*[@id='site-title']/a/img")).isDisplayed();

          System.out.println(status);*/


            driver.findElement(By.xpath("//*[@id='form']//*[@id='username']")).sendKeys("student");
            driver.findElement(By.xpath("//*[@id='form']//*[@id='password']")).sendKeys("Password123");
            driver.findElement(By.xpath("//*[@id='form']//*[@id='submit']")).click();






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
