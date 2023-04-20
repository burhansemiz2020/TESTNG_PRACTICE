package tests.day02_smokeTests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Arrays;

public class C01_SoftAssert {
    @Test(groups = "minireg2")
     public void test01() throws InterruptedException {
        // amazon anasayfaya gidin

        Driver.getDriver().get("https://www.amazon.com");
        // amazon anasayfaya gittiginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();
        String expectedUrlWord="amazon";
        String actualUrlWord=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrlWord.contains(expectedUrlWord), "URL not contains amazon");
        // Nutella aratin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonSearchElement.sendKeys("Nutella"+ Keys.ENTER);
        // arama sonuclarinin nutella icerdigini dogrulayin
        String searchResultElementText=amazonPage.searchResultElement.getText();
        softAssert.assertTrue(searchResultElementText.contains("Nutella"), "search result not contains Nutella ");
        // Java aratin
        amazonPage.amazonSearchElement.clear();
        amazonPage.amazonSearchElement.sendKeys("Java"+Keys.ENTER);
        // arama sonuclarinin 1000'den fazla oldugunu dogrulayin
        System.out.println(amazonPage.searchResultElement.getText());
        // 1-48 of over 4,000 results for "Java"
        searchResultElementText = amazonPage.searchResultElement.getText();
        String[] resultArr=searchResultElementText.split(" ");
        System.out.println(Arrays.toString(resultArr));
        // [1-48, of, over, 4,000, results, for, "Java"]
        String resultNumberStr=resultArr[3];//burada 3. indexte bulunan 4000 sayisin tek olarak secmek icin bunu yapiyoruz
        resultNumberStr=resultNumberStr.replaceAll("\\W","");
        int resultNumberInt=Integer.parseInt(resultNumberStr);
        softAssert.assertTrue(resultNumberInt>1000,"resultNumber is not greater than 1000");

        ReusableMethods.wait(2);




        softAssert.assertAll();
        Driver.closeDriver();

     }

}
