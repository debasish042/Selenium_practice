package TestNG.GroupingTest;

import org.testng.annotations.Test;

public class SignUpTest {

    @Test(priority=1, groups = {"Regression"})
    void signUpByEmail(){
        System.out.println("sign Up By Email to the system...");
    }

    @Test(priority=2, groups = {"Regression"})
    void signUpByFaceBook(){
        System.out.println("sign Up By FaceBook to the system...");
    }

    @Test(priority=1, groups = {"Regression"})
    void signUpByTwitter(){
        System.out.println("sign Up By Twitter to the system...");
    }
}
