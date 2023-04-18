package tests.day02;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegativeLoginTest {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin
    QualitydemyPage qualitydemyPage= new QualitydemyPage();

    @Test
    public void yanlisEmailTesti() throws InterruptedException {

        ReusableMethods.wait(3);

        qualitydemyPage= new QualitydemyPage();
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordBox.sendKeys("Nevzat152032");
        ReusableMethods.wait(2);
        qualitydemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.userEnterBlock.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisPasswordTesti() throws InterruptedException {
        qualitydemyPage= new QualitydemyPage();
        ReusableMethods.wait(3);
        Driver.getDriver().get("https://www.qualitydemy.com/");

        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordBox.sendKeys("123456");
        ReusableMethods.wait(2);
        qualitydemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisEmailYanlisPasswordTesti() throws InterruptedException {
        qualitydemyPage= new QualitydemyPage();
        ReusableMethods.wait(3);
        Driver.getDriver().get("https://www.qualitydemy.com/");

        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordBox.sendKeys("123456");
        ReusableMethods.wait(2);
        qualitydemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }
}
