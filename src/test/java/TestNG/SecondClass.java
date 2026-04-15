package TestNG;

import org.testng.annotations.Test;

public class SecondClass {

    @Test(priority =1)
    void openApplication(){
        System.out.println("Open Application");
    }

    @Test(priority =2 )
    void LogInApplication() {
        System.out.println("LogIn to  Application");
    }

    @Test(priority =3)
    void LogOutFromApplication(){
        System.out.println("Logout from Application");
    }


}
