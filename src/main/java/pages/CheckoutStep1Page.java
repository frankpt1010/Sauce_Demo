package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep1Page extends BasePage{
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By ContinueBtn = By.id("continue");
    private By cancelBtn = By.id("cancel");

    public CheckoutStep1Page(WebDriver driver) {
        super(driver);
    }
    public boolean chkOpenCheckout1Page(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html");
    }
    public void enterFirstName(String fname){
        findAnElement(firstName).sendKeys(fname);
    }
    public void enterLastName(String lname){
        findAnElement(lastName).sendKeys(lname);
    }
    public void enterZipCode(String code){
        findAnElement(zipCode).sendKeys(code);
    }
    public CheckoutStep2Page clickContinue () {
        clickOnElement(ContinueBtn);
        return new CheckoutStep2Page(driver);
    }
    public CartPage clickCancel () {
        clickOnElement(cancelBtn);
        return new CartPage(driver);
    }

}
