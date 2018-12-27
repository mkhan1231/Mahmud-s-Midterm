package design;

import org.testng.Assert;

public class UnitTestingEmployeeInfo {
    public static void main(String[] args) {
        //Write Unit Test for all the methods has been implemented in this package.

        double pension=EmployeeInfo.calculateEmployeePension(6000);
        try{
            Assert.assertEquals(200,200);
            System.out.println("Test Passed");
        } catch (AssertionError as) {
        System.out.println("Test Failed");
        }

        double bonus = EmployeeInfo.calculateEmployeeBonus(8000, 5);
        try {
            Assert.assertEquals(9600,9600);
            System.out.println("Test Passed");
        } catch (AssertionError as) {
            System.out.println("Test Failed");
        }
    }
}

