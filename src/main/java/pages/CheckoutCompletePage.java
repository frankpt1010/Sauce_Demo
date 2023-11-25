package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage{
    private By completeCheckoutMsg= By.id("checkout_complete_container");
    private By backHomeBtn= By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    public boolean chkOpenCheckoutCompletePage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html");
    }
    public boolean chkCheckoutCompleteMsg(){
        return getTextFromElement(findAnElement(completeCheckoutMsg)).contains("Thank you for your order!");
    }
    public LoginPage clickBackHome () {
        clickOnElement(backHomeBtn);
        return new LoginPage(driver);
    }
}
