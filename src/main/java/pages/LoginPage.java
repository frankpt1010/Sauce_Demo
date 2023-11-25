package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    private By userName= By.id("user-name");
    private By password= By.id("password");
    private By loginButton=By.id("login-button");
    private By ErrorMsg=By.cssSelector("h3[data-test=\"error\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUserName(String user){
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(user);
    }
    public void enterPassword(String pass){
        findAnElement(password).clear();
        findAnElement(password).sendKeys(pass);
    }

    public InventoryPage Login(String user, String pass) {
        enterUserName(user);
        enterPassword(pass);
        clickOnElement(loginButton);
        return new InventoryPage(driver);
    }
    public String chkError(){
        return getTextFromElement(findAnElement(ErrorMsg));
    }
    public boolean chkLogout(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/");
    }

}
