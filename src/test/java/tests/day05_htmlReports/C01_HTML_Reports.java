package tests.day05_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {
    @Test
    public void test01(){
        extentTest=extentReports.createTest("Test of Nutella", "User can search Nutella on Amazon");
        // amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("went to amazon homepage");
       // Nutella aratalim
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonSearchElement.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Entered nutella in the search box and searched.");
       // sonuclarin nutella icerdigini test edelim
        String actualResultText=amazonPage.searchResultElement.getText();
        String expectedResultText="Nutella";
        extentTest.info("The results of the search saved");
        Assert.assertTrue(actualResultText.contains(expectedResultText));
        extentTest.info("Search results tested to contain Nutella");


    }
}
