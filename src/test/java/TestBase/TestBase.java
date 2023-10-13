package TestBase;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import static drivers.BrowserFactory.setBrowser;

public class TestBase {
    protected WebDriver driver;
    protected final String url="https://www.saucedemo.com";
    protected LoginPage loginPage;

    @BeforeMethod
    public void openBrowser()
    {
        driver= setBrowser("chrome");
        driver.manage().window().maximize();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
