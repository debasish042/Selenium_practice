package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency {

    @Test(priority=1)
    void openApp(){
        Assert.assertTrue(true);
    }
    @Test(priority=2,dependsOnMethods = {"openApp"})
    void logIn(){
        Assert.assertTrue(true);
    }
    @Test(priority=3,dependsOnMethods = {"logIn"})
    void search(){
        Assert.assertTrue(true);
    }
    @Test(priority=4,dependsOnMethods={"logIn","search"})
    void advancedSearch(){
        Assert.assertTrue(true);
    }
    @Test(priority=5,dependsOnMethods = {"logIn"})
    void logOut(){

        Assert.assertTrue(true);
    }
}
