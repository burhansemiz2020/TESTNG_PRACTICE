package tests.day01_TestNGFramework;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_NutellaTesti {
    @Test
    public void test01() {
        //amazon ansayfaya gidin
        Driver.getDriver().get("https:www.amazon.com");
        //nutella icin arama yapin
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin Nutella icerdigini test edin
        WebElement aramaSonucElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu= aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
        Driver.closeDriver();


    }

}