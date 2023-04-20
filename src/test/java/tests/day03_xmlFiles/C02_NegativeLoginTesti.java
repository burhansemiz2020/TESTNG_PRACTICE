package tests.day03;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegativeLoginTesti {
    // 3 test method'u olusturun
    // 1.de yanlis email, dogru sifre
    // 2.de dogru email yanlis sifre
    // 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
    // giris yapilamadigini test edin
    QualitydemyPage qualitydemyPage=new QualitydemyPage();
    @Test
    public void yanlisEmailTesti() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
    @Test
    public void yanlisPasswordTesti() throws InterruptedException {
        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdGecerliUserName"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        ReusableMethods.wait(2);
        Driver.closeDriver();

    }
    @Test
    public void yanlisEmailYanlisPasswordTesti() throws InterruptedException {
        qualitydemyPage=new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        ReusableMethods.wait(2);
        Driver.closeDriver();
    }
}
