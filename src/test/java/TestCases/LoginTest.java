package TestCases;

import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;


public class LoginTest extends TestBase {

    @Test
    public void enterStandardUsernameAndValidPassword(){
        InventoryPage inventoryPage=loginPage.Login("standard_user","secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
    }
    @Test
    public void enterLockedOutUsernameAndValidPassword(){
        InventoryPage inventoryPage=loginPage.Login("locked_out_user","secret_sauce");
        Assert.assertTrue(loginPage.chkError().contains("Sorry, this user has been locked out"));
    }
    @Test
    public void enterProblemUsernameAndValidPassword(){
        InventoryPage inventoryPage=loginPage.Login("problem_user","secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
    }
    @Test
    public void enterPerformanceGlitchUsernameAndValidPassword(){
        InventoryPage inventoryPage=loginPage.Login("performance_glitch_user","secret_sauce");
        Assert.assertTrue(inventoryPage.chkOpenInventoryPage());
    }
    @Test
    public void leaveUsernameAndPasswordEmpty(){
        InventoryPage inventoryPage=loginPage.Login("","");
        Assert.assertTrue(loginPage.chkError().contains("Username is required"));
    }
    @Test
    public void enterValidUsernameAndLeavePasswordEmpty(){
        InventoryPage inventoryPage=loginPage.Login("standard_user","");
        Assert.assertTrue(loginPage.chkError().contains("Password is required"));
    }
    @Test
    public void enterInvalidUsernameAndAndValidPassword(){
        InventoryPage inventoryPage=loginPage.Login("dina","secret_sauce");
        Assert.assertTrue(loginPage.chkError().contains("Username and password do not match any user"));
    }
    @Test
    public void enterValidUsernameAndInvalidPassword(){
        InventoryPage inventoryPage=loginPage.Login("standard_user","25225");
        Assert.assertTrue(loginPage.chkError().contains("Username and password do not match any user"));
    }
    @Test
    public void enterInvalidUsernameAndAndInvalidPassword(){
        InventoryPage inventoryPage=loginPage.Login("dina","25225");
        Assert.assertTrue(loginPage.chkError().contains("Username and password do not match any user"));
    }




}
