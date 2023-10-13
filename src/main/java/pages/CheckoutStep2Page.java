package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep2Page {
    @FindBy(id = "finish")
    private WebElement finishBtn;
    @FindBy(id = "cancel")
    private WebElement cancelBtn;
    private WebDriver driver;
    public CheckoutStep2Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean chkOpenCheckout2Page(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html");
    }
    public CheckoutCompletePage clickFinish () {
        finishBtn.click();
        return new CheckoutCompletePage(driver);
    }
    public CheckoutStep1Page clickCancel () {
        cancelBtn.click();
        return new CheckoutStep1Page(driver);
    }

}
