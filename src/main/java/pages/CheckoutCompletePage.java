package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage{
    @FindBy(id = "checkout_complete_container")
    private WebElement completeCheckoutMsg;
    @FindBy(id = "back-to-products")
    private WebElement backHomeBtn;
    private WebDriver driver;
    public CheckoutCompletePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean chkOpenCheckoutCompletePage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html");
    }
    public boolean chkCheckoutCompleteMsg(){
        return completeCheckoutMsg.getText().contains("Thank you for your order!");
    }
    public LoginPage clickBackHome () {
        backHomeBtn.click();
        return new LoginPage(driver);
    }
}
