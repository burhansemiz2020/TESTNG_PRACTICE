package tests.day01_TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NutellaTesti {
    @Test(groups={"minireg1","minireg2","smoke"})
    public void test01() {
        //amazon ansayfaya gidin
        Driver.getDriver().get("https:www.amazon.com");
        ReusableMethods.wait(2);
        //nutella icin arama yapin
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        ReusableMethods.wait(2);
        //sonuclarin Nutella icerdigini test edin
        WebElement aramaSonucElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu= aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
        ReusableMethods.wait(2);
        Driver.closeDriver();


    }

}
