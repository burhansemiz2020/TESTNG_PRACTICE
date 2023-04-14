package tests.day01_TestNGFramework;

import org.testng.annotations.Test;

public class C01_TestNGFirstTest {
    @Test (priority=6)
    public void firstTest(){
        System.out.println("first test is working");
    }

    @Test(priority=1)
    public void secondTest(){
        System.out.println("second test is working");
    }

    @Test(priority=-9)
    public void thirdTest(){
        System.out.println("third test is working");
    }

}
