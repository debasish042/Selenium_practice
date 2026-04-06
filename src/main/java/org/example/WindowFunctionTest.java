package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WindowFunctionTest {

    static void main() throws InterruptedException {

       // Set up web browser driver (e.g., ChromeDriver)
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.manage().window().maximize();


        // open the website

        driver.navigate().to("https://testautomationpractice.blogspot.com/");

        // Search for the String

       WebElement element = driver.findElement(By.xpath("//*[@id='Wikipedia1_wikipedia-search-input']"));

       element.sendKeys("Selenium");

       driver.findElement(By.xpath("//*[@class='wikipedia-search-button']")).click();


       // Wait for the search results to load (you can use explicit wait here if needed)
           Thread.sleep(3000);


           // count total number of links

        List<WebElement> links = driver.findElements(By.xpath("//div[@class='wikipedia-search-results']//a"));

        System.out.println(links.size());

        // open each links

        for(WebElement link : links){
            link.click();
            Thread.sleep(2000); // wait for the page to load
        }

        // Get the window ids

        Set<String> windowIds = driver.getWindowHandles();

        System.out.println(windowIds);

        // convert the Set into a List to access by index

        LinkedList<String> windowList = new LinkedList<>(windowIds);

       /* // switch to the last opened window (the most recent one)
         driver.switchTo().window(windowList.get(windowList.size() - 1));*/

        // Switch to each window and print title
        for (String winId : windowList) {
            driver.switchTo().window(winId);
            System.out.println("Title: " + driver.getTitle());
        }


        // 6) Close specific window (example: close all except parent)
        String parentWindow = windowList.getFirst();

        for (String winId : windowList) {
            if (!winId.equals(parentWindow)) {
                driver.switchTo().window(winId);
                driver.close();
            }
        }

        // Switch back to parent
        driver.switchTo().window(parentWindow);

        driver.navigate().refresh();


        System.out.println("Back to parent window: " + driver.getTitle());

        // Close parent
        driver.quit();






        //
    }
}
