package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep1Page {
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement zipCode;
    @FindBy(id = "continue")
    private WebElement ContinueBtn;
    @FindBy(id = "cancel")
    private WebElement cancelBtn;
    private WebDriver driver;
    public CheckoutStep1Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean chkOpenCheckout1Page(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-one.html");
    }
    public void enterFirstName(String fname){
        firstName.sendKeys(fname);
    }
    public void enterLastName(String lname){
        lastName.sendKeys(lname);
    }
    public void enterZipCode(String code){
        zipCode.sendKeys(code);
    }
    public CheckoutStep2Page clickContinue () {
        ContinueBtn.click();
        return new CheckoutStep2Page(driver);
    }
    public CartPage clickCancel () {
        cancelBtn.click();
        return new CartPage(driver);
    }
}
