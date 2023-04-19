package tests.day02;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_PozitifLoginTest {
    /*
   Page object model javadaki OOP konsepte dayanir. Ornegin
   1. driver classindan webdriver olusturup kullanmak icin static
   yontemi kullaniriz
   2. Locate leri page sayfalarinda yapip, onlara obje
   olusturarak ulasabiliriz.
    */
    @Test(groups = "smoke")
    public void test01() throws InterruptedException {
        //qualitydemy sayfasina gidip
        Driver.getDriver().get("https://www.qualitydemy.com");
        //login linkine tiklayin
        QualitydemyPage qualityDemyPage=new QualitydemyPage();
        qualityDemyPage.firstLoginLink.click();
        //dogru kullanici adi ve sifre ile giris yapin
        qualityDemyPage.emailBox.sendKeys("anevzatcelik@gmail.com");
        qualityDemyPage.passwordBox.sendKeys("Nevzat152032");
        qualityDemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(4);
        qualityDemyPage.loginButton.click();
        //giris yapildigini test edin
        Assert.assertTrue(qualityDemyPage.succedEntryButton.isDisplayed());
        Driver.closeDriver();
    }
}
