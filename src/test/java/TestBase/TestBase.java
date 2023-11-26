package TestBase;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera=(TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot.toPath(), new File("Resources/screenshot/" + result.getName() + ".png").toPath());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
