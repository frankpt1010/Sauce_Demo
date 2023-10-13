package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class CartPage {
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingBtn;
    @FindBy(css = "[id*=\"remove\"]")
    private List<WebElement> removeFromCart;
    private WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean chkOpenCartPage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
    }
    public void removeItemFromCart() {
        if (removeFromCart.size()>0){
            removeFromCart.get(0).click();
        }
    }
    public CheckoutStep1Page clickCheckout () {
        checkoutBtn.click();
        return new CheckoutStep1Page(driver);
    }
    public InventoryPage clickContShopping () {
        continueShoppingBtn.click();
        return new InventoryPage(driver);
    }
}
