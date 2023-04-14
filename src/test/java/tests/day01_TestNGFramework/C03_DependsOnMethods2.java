package tests.day01_TestNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMethods2 {
    //3 tane test metodu olusturun
    //1- amazon anasayfaya gidin ve testini yapin
    //2- amazon ansayfasinda arama kurtusunun enable oldugunu test edin
    //3- arama kutusuna Nutella yazip aratin, sonuclarin Nutella icerdigini test edin
    WebDriver driver;
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//1- amazon anasayfaya gidin ve testini yapin
        driver.get("https://www.wisequarter.com");
        String expectedUrl = "https://www.amazon.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test(dependsOnMethods = "test01")
        public void searchBoxTest() {
//2- amazon ansayfasinda arama kurtusunun enable oldugunu test edin
            WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
            Assert.assertTrue(searchBox.isEnabled());
    }
    @Test(dependsOnMethods = "searchBoxTest")
        public void nutellaTesti() {
//3- arama kutusuna Nutella yazip aratin, sonuclarin Nutella icerdigini test edin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        WebElement searchBoxElementTest = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedElement = "Nutella";
        String actualElement = searchBoxElementTest.getText();
        Assert.assertTrue(actualElement.contains(expectedElement));
        driver.close();
        }


    }


