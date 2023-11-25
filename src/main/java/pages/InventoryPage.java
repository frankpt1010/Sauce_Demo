package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InventoryPage extends BasePage{
    private By addToCart = By.cssSelector("[id*=\"add-to-cart\"]");
    private By removeFromCart = By.cssSelector("[id*=\"remove\"]");
    private By cartItemBadge = By.className("shopping_cart_badge");
    private By cartLink = By.className("shopping_cart_link");
    private By cartItems = By.className("cart_item");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public boolean chkOpenInventoryPage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }
    public void addItemToCart() {
        List<WebElement> itemsToAdd=driver.findElements(addToCart);
        if ((itemsToAdd.size())>0){
            driver.findElements(addToCart).get(itemsToAdd.size()-2).click();
            driver.findElements(addToCart).get(itemsToAdd.size()-3).click();
            driver.findElements(addToCart).get(0).click();
        }
    }
    public void removeItemFromCart() {
        int numOfProductsToRemove=driver.findElements(removeFromCart).size();
        if (numOfProductsToRemove>0){
            int randomProduct1 = ThreadLocalRandom.current().nextInt(0,numOfProductsToRemove-1);
            driver.findElements(removeFromCart).get(randomProduct1).click();
            int randomProduct2 = ThreadLocalRandom.current().nextInt(0,numOfProductsToRemove-1);
            driver.findElements(removeFromCart).get(randomProduct2).click();
        }
    }
    public WebElement cartItemsBadgeCount() {
        WebElement count=findAnElement(cartItemBadge);
        return count;
    }
    public CartPage clickCart () {
        clickOnElement(cartLink);
        return new CartPage(driver);
    }
    public int CartItemsCount() {
        return driver.findElements(cartItems).size();
    }
    public LoginPage logout()
    {
        clickOnElement(menuButton);
        waitForElement(findAnElement(logoutLink));
        clickOnElement(logoutLink);
        return new LoginPage(driver);
    }
}
