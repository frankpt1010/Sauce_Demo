package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user-name")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id =  "login-button")
    private WebElement loginButton;
    @FindBy(css = "h3[data-test=\"error\"]")
    private WebElement ErrorMsg;
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void enterUserName(String user){
        userName.clear();
        userName.sendKeys(user);
    }
    public void enterPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }
    public InventoryPage Login(String user, String pass) {
        enterUserName(user);
        enterPassword(pass);
        loginButton.click();
        return new InventoryPage(driver);
    }
    public String chkError(){
        return ErrorMsg.getText();
    }
    public boolean chkLogout(){
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/");
    }

}
