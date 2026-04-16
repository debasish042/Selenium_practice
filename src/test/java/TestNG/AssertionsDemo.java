package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

    @Test
    void testTitle(){

        String exp_title = "Raja";

        String act_title ="Raja";

        /*if(exp_title.equals(act_title)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }*/

          /*if(exp_title.equals(act_title)){
            System.out.println("Test Passed");
            Assert.assertTrue(true);
        } else {
            System.out.println("Test Failed");
            Assert.assertTrue(false);
        }*/

        Assert.assertEquals(exp_title,act_title);

        // With the help of assertion we can do various type of validation

        /*
        * 2 TYPES OF Assertion
        *
        * 1. Hard Assertion
        * 2. Soft Assertions
        * */

    }


}
