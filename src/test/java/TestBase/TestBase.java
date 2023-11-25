package TestBase;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static drivers.BrowserFactory.setBrowser;

public class TestBase {
    protected WebDriver driver;
    protected final String url="https://www.saucedemo.com";
    protected LoginPage loginPage;

    @BeforeMethod
    public void openBrowser()
    {
        driver= setBrowser("default");
        driver.manage().window().maximize();
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }
}
