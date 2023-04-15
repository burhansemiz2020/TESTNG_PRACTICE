package tests.day02;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import pages.QualitydemyPage;
import utilities.Driver;

public class C03_PozitifLoginTest {
    /*
   Page object model javadaki OOP konsepte dayanir. Ornegin
   1. driver classindan webdriver olusturup kullanmak icin static
   yontemi kullaniriz
   2. Locate leri page sayfalarinda yapip, onlara obje
   olusturarak ulasabiliriz.
    */
    @Test
    public void test01(){
        //qualitydemy sayfasina gidip
        Driver.getDriver().get("https://www.qualitydemy.com");
        //login linkine tiklayin
        QualitydemyPage qualityDemyPage=new QualitydemyPage();
        qualityDemyPage.ilkLoginLinki.click();
        //dogru kullanici adi ve sifre ile giris yapin
        qualityDemyPage.kullaniciEmailKutusu.sendKeys("anevzatcelik@gmail.com");
        qualityDemyPage.passwordKutusu.sendKeys("Nevzat152032");
        qualityDemyPage.loginButonu.click();
        //giris yapildigini test edin
        Assert.assertTrue(qualityDemyPage.basariliGirisCoursesLinki.isDisplayed());
        Driver.closeDriver();
    }
}
