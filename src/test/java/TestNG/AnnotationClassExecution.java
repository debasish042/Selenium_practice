package TestNG;

import org.testng.annotations.*;

public class AnnotationClassExecution {

    @BeforeClass
    void logIn(){
        System.out.println("This is LogIN");
    }
    @Test(priority =1)
    void search(){
        System.out.println("This is search");
    }

    @Test(priority =2 )
    void AdvancedSearch(){
        System.out.println("This is Advanced Search");
    }

    @AfterClass
    void logOut(){
        System.out.println("This is LogOUT");
    }
}
