package TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationExecution {

    WebDriver driver;

    @BeforeMethod
    void logIn(){
       System.out.println("This is LogIN");
    }
    @Test (priority =1)
    void search(){
        System.out.println("This is search");
    }

    @Test(priority =2 )
    void AdvancedSearch(){
        System.out.println("This is Advanced Search");
    }

    @AfterMethod
    void logOut(){
        System.out.println("This is LogOUT");
    }
}
