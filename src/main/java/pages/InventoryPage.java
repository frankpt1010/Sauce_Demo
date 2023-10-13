package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InventoryPage {
    @FindBy(css = ("[id*=\"add-to-cart\"]"))
    private List<WebElement> addToCart;
    @FindBy(css = ("[id*=\"remove\"]"))
    private List<WebElement> removeFromCart;
    @FindBy(className = "bm-burger-button")
    private WebElement menuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartItemBadge;
    @FindBy(id = "shopping_cart_container")
    private WebElement cartLink;
    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean chkOpenInventoryPage(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }
    public void addItemToCart() {
        if ((addToCart.size())>0){
            addToCart.get(addToCart.size()-1).click();
            addToCart.get(addToCart.size()-2).click();
            addToCart.get(0).click();
        }
    }
    public void removeItemFromCart() {
        if (removeFromCart.size()>0){
            int randomProduct1 = ThreadLocalRandom.current().nextInt(0,removeFromCart.size()-1);
            removeFromCart.get(randomProduct1).click();
            int randomProduct2 = ThreadLocalRandom.current().nextInt(0,removeFromCart.size()-1);
            removeFromCart.get(randomProduct2).click();
        }
    }
    public WebElement getCartItemBadgeCount(){
        return cartItemBadge;
    }
    public CartPage clickCart () {
        cartLink.click();
        return new CartPage(driver);
    }
    public int CartItemsCount() {
        return cartItems.size();
    }
    public LoginPage logout()
    {
        menuButton.click();
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.visibilityOf(logoutLink));
        logoutLink.click();
        return new LoginPage(driver);
    }
}
