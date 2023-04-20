package tests.day05_htmlReports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProviderNegativeLoginTest {


    //QualityDemy sayfasina gidin
    //verilen yanlis kullanici adi ve pass kombinasyonlari icin
    //giris yapilamadigini rtest edin
    //usename       password
    //A11           A12345
    //B12           B12345
    //C13           C12345
    //D14           D12345
    //E15           E12345

    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object[][] kullaniciBilgileriArr=
                {{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};
        return kullaniciBilgileriArr;
    }

    @Test(dataProvider = "kullaniciBilgileri")
    public void negativeLoginTest(String username, String password){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage= new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();

        qualitydemyPage.emailBox.sendKeys(username);
        qualitydemyPage.passwordBox.sendKeys(password);

        qualitydemyPage.loginButton.submit();
        ReusableMethods.wait(2);



        Assert.assertTrue(qualitydemyPage.userEnterBlock.isDisplayed());
        Driver.closeDriver();
    }
}
