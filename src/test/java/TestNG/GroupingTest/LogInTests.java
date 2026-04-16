package TestNG.GroupingTest;

import org.testng.annotations.Test;

public class LogInTests {

    @Test(priority=1,groups = {"sanity"})
    void logInByEmail(){
        System.out.println("log In By Email to the System");
    }

    @Test(priority=2,groups = {"sanity"})
    void logInByFaceBook() {
        System.out.println("log In By Facebook to the System");
    }

    @Test(priority=3,groups={"sanity"})
    void logInByTwitter() {

        System.out.println("log In By Twitter to the System");
    }
}
