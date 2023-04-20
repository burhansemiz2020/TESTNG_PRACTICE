package tests.day02_smokeTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_SoftAssert {
    @Test(groups = {"minireg1", "minireg2"})

    public void test01() throws InterruptedException {
        ReusableMethods.wait(3);
        //Yeni bir Class Olusturun : C03_SoftAssert
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        //2. Sign in butonuna basin
        ZeroWebAppPage zeroWebAppPage=new ZeroWebAppPage();
        zeroWebAppPage.signInButton.click();
        //3. Login kutusuna “username” yazin
        zeroWebAppPage.logInBox.sendKeys("username");
        //4. Password kutusuna “password” yazin
        zeroWebAppPage.passwordBox.sendKeys("password");
        //5. Sign in tusuna basin
        zeroWebAppPage.signInSubmitButton.click();
        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroWebAppPage.onlineBankingMenu.click();
        zeroWebAppPage.payBillsLink.click();
        //7. “Purchase Foreign Currency” tusuna basin
        zeroWebAppPage.purchaseForeignCurrencyLink.click();
        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select = new Select(zeroWebAppPage.currencyDropDownButton);
        select.selectByVisibleText("Eurozone (euro)");
        zeroWebAppPage.currencyDropDownButton.click();
        //9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        String actualDropDownSelection=select.getFirstSelectedOption().getText();
        String expectedDropDownSelection="Eurozone (euro)";
        softAssert.assertEquals(actualDropDownSelection, expectedDropDownSelection, "The selection is failed");
        //zeroWebAppPage.euroZoneLink.submit();
        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> optionsElementsList=select.getOptions();
        List<String> actualOptionsListStr=new ArrayList<>();
        for (WebElement each:optionsElementsList
             ) {
            actualOptionsListStr.add(each.getText());
        }
        String[] arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionsListStr= Arrays.asList(arr);
        Collections.sort(actualOptionsListStr);
        Collections.sort(expectedOptionsListStr);
        softAssert.assertEquals(actualOptionsListStr,expectedOptionsListStr);

        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
        ReusableMethods.wait(3);
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
