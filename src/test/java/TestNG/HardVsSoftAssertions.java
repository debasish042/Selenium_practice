package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
    @Test
    void hardAssertions(){

        System.out.println("Hard...");
        System.out.println("Hard...");

        //Hard Assertionn

        Assert.assertEquals(1,1);
        System.out.println("Hard...");
        System.out.println("Hard...");
    }

    @Test
    void softAssertions(){

        System.out.println("Hard...");
        System.out.println("Hard...");

        //Soft Assertionn

        SoftAssert sf  = new SoftAssert();
        sf.assertEquals(1,1);

        Assert.assertEquals(1,1);
        System.out.println("Hard...");
        System.out.println("Hard...");

        sf.assertAll();

        // this we have to mention it is mandatory


    }
}
