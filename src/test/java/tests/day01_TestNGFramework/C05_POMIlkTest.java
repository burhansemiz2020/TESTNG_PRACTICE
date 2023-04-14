package tests.day01_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualityDemyPage;
import utilities.Driver;

public class C05_POMIlkTest {
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
        QualityDemyPage qualityDemyPage=new QualityDemyPage();
        qualityDemyPage.firstLoginLink.click();
        //dogru kullanici adi ve sifre ile giris yapin
        qualityDemyPage.emailBox.sendKeys("anevzatcelik@gmail.com");
        qualityDemyPage.passwordBox.sendKeys("Nevzat152032");
        qualityDemyPage.loginButton.click();
        //giris yapildigini test edin
        Assert.assertTrue(qualityDemyPage.successEnterElement.isDisplayed());
        Driver.closeDriver();
    }
}
