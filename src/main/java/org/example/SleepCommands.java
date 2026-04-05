package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/*
* Two types of exception are there in this case
*
* NoSuchElementException - when the element is not found due to Synchronization issues (e.g., element is not yet present in the DOM or not visible)
* StaleElementReferenceException - when the element was found but is no longer attached to the DOM (e.g., due to page refresh or dynamic content changes)

* ElementNotFoundException is a common exception in Selenium that occurs when the WebDriver cannot locate an element on the web page using the specified locator strategy (e.g., ID, class name, XPath). This can happen for several reasons, including:
* */
public class SleepCommands {

    static void main() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        /*
        * we have to write implicitely wait 1 time at the starting of the programme
        * It is alive till we close the driver
        *  */

       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        /*
        * Advantages of using implicit wait
        * 1.single time we have to write/ one statement we have to write
        * 2.it will not wait maximum time if elemnt is already found it will move to the next step
        * 3.Applicable for all elemnts
        * 4.easy to use
        *
        * Disadvantages of using implicit wait
        * 1. if the time is not efficient then again we will get exception
        *
        *
        *
        * */



        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();

        /*Thread.sleep(5000);*/

        /*
        * Disadvantages of using Thread.sleep():
        *
        * 1. if the time is not efficient then again we will get exception
        * 2.it will wait for maximum time out , this will reduce the performance of the script
        * 3.multiple times
        * */


        /*
        * Two types of wait
        *
        * 1.implicipt wait
        * 2.explicit wait
        *
        *
        * */

        /*
        * explicit wait
        *
        * 1.declaration
        * 2.use
        * */




        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
    }
}
