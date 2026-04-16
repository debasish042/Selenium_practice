package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

    @Test
    void test(){
        Assert.assertEquals(true,true);

        // Compare any things , Usually used for Comparision

        Assert.assertNotEquals(true,false);

        Assert.assertTrue(true);

        Assert.assertTrue(false);


    }
}
