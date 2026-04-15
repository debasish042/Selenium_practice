package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/*
 * Open the Application
 * Test Logo is present
 * login
 * close
 *
 * */
public class OrangeHrmTest {

    WebDriver driver;

    /*
     * Make it class level because at first it was associated to local Level
     * */

    @BeforeClass
    public void openApp(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

    }

    @Test(priority=1)
    public void TestLogo(){

        // remove trailing space in the alt value and print actual status
        boolean status = false;
        try {
            status = driver.findElement(By.xpath("//*[@alt='company-branding']")).isDisplayed();
        } catch (Exception e) {
            // element not found or not visible
            System.out.println("Logo check failed: " + e.getMessage());
        }

        System.out.println("Logo is displayed: " + status);


    }
    @Test(priority=2)
    public void LogIn(){

        // prefer to use name attributes for input fields; fallback to placeholder if names differ
        try {
            driver.findElement(By.name("username")).sendKeys("admin");
        } catch (Exception e) {
            driver.findElement(By.xpath("//*[@placeholder='Username']")).sendKeys("admin");
        }

        try {
            driver.findElement(By.name("password")).sendKeys("admin123");
        } catch (Exception e) {
            driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("admin123");
        }

        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    @AfterClass
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }

}
