package tests.day03;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_PozitifLoginTesti {
    @Test
    public void testLogin() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdGecerliUserName"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.cookiesAcceptButton.click();
        ReusableMethods.wait(2);
        qualitydemyPage.loginButton.click();
        ReusableMethods.wait(2);

        Assert.assertTrue(qualitydemyPage.succedEntryButton.isDisplayed());
        ReusableMethods.wait(1);
        Driver.closeDriver();
    }

}
