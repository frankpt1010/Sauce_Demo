package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep2Page extends BasePage{
    private By finishBtn = By.id("finish");
    private By cancelBtn = By.id("cancel");
    public CheckoutStep2Page(WebDriver driver) {
        super(driver);
    }
    public boolean chkOpenCheckout2Page(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html");
    }
    public CheckoutCompletePage clickFinish () {
        clickOnElement(finishBtn);
        return new CheckoutCompletePage(driver);
    }
    public CheckoutStep1Page clickCancel () {
        clickOnElement(cancelBtn);
        return new CheckoutStep1Page(driver);
    }

}
