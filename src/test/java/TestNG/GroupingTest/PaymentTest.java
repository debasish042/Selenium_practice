package TestNG.GroupingTest;

import org.testng.annotations.Test;

public class PaymentTest {

    @Test(priority=1,groups = {"sanity","Regression","functional"})
    void paymentInRupees(){
        System.out.println("Paying in rupees...");

    }

    @Test(priority=2, groups = {"sanity","Regression","functional"})
    void paymentInDollars(){
        System.out.println("Paying in dollars...");
    }
}
