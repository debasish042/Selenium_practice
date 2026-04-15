package TestNG;

/*
 * 1. open our application
 * 2.Login to Application
 * 3.LogOut from Application
 * */

// Here instead of using Main Method we are using @Test Method
// With @Test(priority=1)  we have to give this to execute the test in a order
// or else Test Ng will execute it in alphabetical Order
//Even if we change the order if priority is given it will execute in priority order
//priority number can be anything no need to be consecutive numbers
// Default priority will be 0
//if two methods have same priority then it will consider Alphabetical order
//if we only have @Test annotation then it will not execute

/*
* Execute test cases using testng xml file
*We can generate report through xml file
* We can run multiple test cases at one shot
*
* A group of test cases is called test suite
*
* */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTestCase {

    WebDriver driver;
    @Test(priority = 1)
    public void OpenApp(){

        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("Opening Application");
    }

    @Test(priority = 2)
    public void LogoTest(){
        boolean status = false;
        try{
            status = driver.findElement(By.xpath("//*[@class='custom-logo']")).isDisplayed();

        } catch(Exception e){
            System.out.println("Logo is Present"+e.getMessage());
        }
        System.out.println("Logo is Present" +status);
    }

    @Test(priority = 3)
    public void LogIn(){
        try{
            driver.findElement(By.xpath("//*[@id='username']")).sendKeys("student");
        } catch(Exception e){
            driver.findElement(By.xpath("//*[@name='username']")).sendKeys("student");
        }

        try{
           driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Password123");
        } catch(Exception e) {
            driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Password123");

        }

        driver.findElement(By.xpath("//*[@id='submit']")).click();

        System.out.println("Logging In to Application ");
    }

    @Test(priority = 4)
    public void LogOut(){

       if(driver != null){
           driver.quit();
       }




        System.out.println("Logging Out to Application ");
    }
}



/*
* Test suite ---> contains a group of test  cases
* test case contains a test steps
*
*
* Test suite -------> Test Cases -----> Test steps
* XML file ---------> classes ---------> Test Methods
*
*
*
* Advantages of TestNg
*
* 1. Test cases and test suites
* 2. Grouping of test cases
* 3.Prioritize
* 4.Parameterization
* 5. Parallel testing
* 6. Reports
*
*
* */

