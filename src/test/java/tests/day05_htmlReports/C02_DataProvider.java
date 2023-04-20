package tests.day05_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] AmazonSearchWords() {
        /*
    @DataProvider istedigimiz test methoduna test datasi saglamak icin kullanilir
    sadece bir sarti vardir> Iki katli bir object array i dondurmeluidir.
     */
        Object[][] amazonSearchWordsArray=
                {{"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"armut"}};

        return amazonSearchWordsArray;
    }

    //amazona gidelim
    //nutella, java, samsung, armut kelimeleri icin arama yapalim
    // ve sonuclarin bu kelimeleri icerdigini test edelim
    //ayni test farkli datalar icin tekraar tekrar calisacak
    @Test(dataProvider = "AmazonSearchWords")//sag tiklayip more actions tan method olusturduk

    public void  searchTest(String searchWord) {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonSearchElement.sendKeys(searchWord+ Keys.ENTER);
        String actuResultText=amazonPage.searchResultElement.getText();
        Assert.assertTrue(actuResultText.contains(searchWord));
        //simdi bu kelimeleri yollayacak data kaynagina
        // ihtiyac var bunun icin @test in yanina gelip dataprovider yapiyoruz
        Driver.closeDriver();
    }

}
