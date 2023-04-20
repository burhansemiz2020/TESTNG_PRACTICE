package tests.day06_CrossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

public class C02_WiseQuarterTest extends TestBaseCross {
    @Test
    public void test01(){
        // WiseQuarter anasayfaya giddelim

        driver.get("https://www.wisequarter.com");

        // wise quarter sitesine gittigimizi test edelim
        ReusableMethods.wait(3);
        String actualUrl= driver.getCurrentUrl();
        String expectedKelime="wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedKelime));
        ReusableMethods.wait(3);
        Driver.closeDriver();


    }
}
