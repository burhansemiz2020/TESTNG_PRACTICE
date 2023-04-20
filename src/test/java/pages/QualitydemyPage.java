package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {
    /*
    Page sayfalari locate islemleri ve login gibi basit
    islev yapan methodlari icerir

    Bir page classi olusturuldugunda ilk isimiz driveri
    bu class a tanitmak olmalidir.
     */

    public QualitydemyPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement firstLoginLink;

    @FindBy(id="login-email")
    public WebElement emailBox;

    @FindBy(id="login-password")
    public WebElement passwordBox;

    @FindBy(xpath="//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(linkText = "My courses")
    public WebElement succedEntryButton;

    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement cookiesAcceptButton;

    @FindBy(xpath="//div[@class='sign-up-form']")
    public WebElement userEnterBlock;



}
