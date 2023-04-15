package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebAppPage {
    public ZeroWebAppPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id="signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement logInBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInSubmitButton;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingMenu;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLink;

    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyLink;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropDownButton;

    @FindBy(xpath = "//*[text()='Eurozone (euro)']")
    public WebElement euroZoneLink;
}
