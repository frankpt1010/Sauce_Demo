package TestCases;

import TestBase.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class StandardUser_PurchaseTest extends TestBase {
    @Test
    public void addItemsToCartAndCheckoutSuccessfully() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBePresentInElement(inventoryPage.getCartItemBadgeCount(), "3"));
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        int itemBadge = Integer.parseInt(inventoryPage.getCartItemBadgeCount().getText());
        Assert.assertEquals(itemBadge, inventoryPage.CartItemsCount());
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        CheckoutCompletePage checkoutCompletePage = checkout2Page.clickFinish();
        Assert.assertTrue(checkoutCompletePage.chkOpenCheckoutCompletePage());
        Assert.assertTrue(checkoutCompletePage.chkCheckoutCompleteMsg());
    }

    @Test
    public void addItemsToCartAndLogoutAndReLoginCompletePurchase() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBePresentInElement(inventoryPage.getCartItemBadgeCount(), "3"));
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        int itemBadge = Integer.parseInt(inventoryPage.getCartItemBadgeCount().getText());
        Assert.assertEquals(itemBadge, inventoryPage.CartItemsCount());
        loginPage = inventoryPage.logout();
        Assert.assertTrue(loginPage.chkLogout());
        loginPage.Login("standard_user", "secret_sauce");
        inventoryPage.clickCart();
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        CheckoutCompletePage checkoutCompletePage = checkout2Page.clickFinish();
        Assert.assertTrue(checkoutCompletePage.chkOpenCheckoutCompletePage());
        Assert.assertTrue(checkoutCompletePage.chkCheckoutCompleteMsg());
    }

    @Test
    public void addAndRemoveItemsFromInventoryPageAndCheckoutSuccessfully() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBePresentInElement(inventoryPage.getCartItemBadgeCount(), "3"));
        inventoryPage.removeItemFromCart();
        wait.until(ExpectedConditions.textToBePresentInElement(inventoryPage.getCartItemBadgeCount(), "1"));
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        int itemBadge = Integer.parseInt(inventoryPage.getCartItemBadgeCount().getText());
        Assert.assertEquals(itemBadge, inventoryPage.CartItemsCount());
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        CheckoutCompletePage checkoutCompletePage = checkout2Page.clickFinish();
        Assert.assertTrue(checkoutCompletePage.chkOpenCheckoutCompletePage());
        Assert.assertTrue(checkoutCompletePage.chkCheckoutCompleteMsg());
    }

    @Test
    public void addItemsThenRemoveItemsFromCartPageAndCheckoutSuccessfully() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.textToBePresentInElement(inventoryPage.getCartItemBadgeCount(), "3"));
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        int itemBadge = Integer.parseInt(inventoryPage.getCartItemBadgeCount().getText());
        Assert.assertEquals(itemBadge, inventoryPage.CartItemsCount());
        cartPage.removeItemFromCart();
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        CheckoutCompletePage checkoutCompletePage = checkout2Page.clickFinish();
        Assert.assertTrue(checkoutCompletePage.chkOpenCheckoutCompletePage());
        Assert.assertTrue(checkoutCompletePage.chkCheckoutCompleteMsg());
    }

    @Test
    public void clickContinueShoppingOnCartPageAndAddItemsThenCompleteCheckout() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        cartPage.clickContShopping();
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        CheckoutCompletePage checkoutCompletePage = checkout2Page.clickFinish();
        Assert.assertTrue(checkoutCompletePage.chkOpenCheckoutCompletePage());
        Assert.assertTrue(checkoutCompletePage.chkCheckoutCompleteMsg());
    }
    @Test
    public void cancelOnCheckoutStepOneAndRedirectedToCartPage() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.clickCancel();
        Assert.assertTrue(cartPage.chkOpenCartPage());
    }
    @Test
    public void cancelOnCheckoutStepTwoAndRedirectedToStepOne() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        checkout2Page.clickCancel();
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
    }
    @Test
    public void logoutOnInventoryPageAndRedirectedToLoginPage() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.logout();
        Assert.assertTrue(loginPage.chkLogout());
    }
    @Test
    public void logoutOnCartPageAndRedirectedToLoginPage() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        inventoryPage.logout();
        Assert.assertTrue(loginPage.chkLogout());
    }
    @Test
    public void logoutOnCheckoutStepOneAndRedirectedToLoginPage() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        inventoryPage.logout();
        Assert.assertTrue(loginPage.chkLogout());
    }
    @Test
    public void logoutOnCheckoutStepTwoAndRedirectedToLoginPage() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        CartPage cartPage = inventoryPage.clickCart();
        Assert.assertTrue(cartPage.chkOpenCartPage());
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        inventoryPage.logout();
        Assert.assertTrue(loginPage.chkLogout());
    }
    @Test
    public void clickBackHomeAfterCompleteCheckoutAndReturnToLoginPage() {
        InventoryPage inventoryPage = loginPage.Login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
        inventoryPage.addItemToCart();
        CartPage cartPage = inventoryPage.clickCart();
        CheckoutStep1Page checkout1Page = cartPage.clickCheckout();
        Assert.assertTrue(checkout1Page.chkOpenCheckout1Page());
        checkout1Page.enterFirstName("Dina");
        checkout1Page.enterLastName("Ashraf");
        checkout1Page.enterZipCode("123456A");
        CheckoutStep2Page checkout2Page = checkout1Page.clickContinue();
        Assert.assertTrue(checkout2Page.chkOpenCheckout2Page());
        CheckoutCompletePage checkoutCompletePage = checkout2Page.clickFinish();
        checkoutCompletePage.clickBackHome();
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
    }
}
