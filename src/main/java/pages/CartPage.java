package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.ThreadLocalRandom;

public class CartPage extends BasePage{
    private By removeFromCart = By.cssSelector("[id*=\"remove\"]");
    private By checkoutBtn=By.id("checkout");
    private By continueShoppingBtn = By.id("continue-shopping");


    public CartPage(WebDriver driver) {
        super(driver);
    }
    public boolean chkOpenCartPage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/cart.html");
    }
    public void removeItemFromCart() {
        int numOfProductsToRemove=driver.findElements(removeFromCart).size();
        if (numOfProductsToRemove>0){
            driver.findElements(removeFromCart).get(0).click();
        }
    }
    public CheckoutStep1Page clickCheckout () {
        clickOnElement(checkoutBtn);
        return new CheckoutStep1Page(driver);
    }
    public InventoryPage clickContShopping () {
        clickOnElement(continueShoppingBtn);
        return new InventoryPage(driver);
    }
}
