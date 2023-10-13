package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
     public static WebDriver setBrowser (String browserName){
        switch (browserName.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                ChromeOptions options = new ChromeOptions();

                options.addArguments("start-maximized");
                options.addArguments("--disable-web-security");
                options.addArguments("--no-proxy-server");
                options.addArguments("--remote-allow-origins=*");
                //options.setHeadless(true);

                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(options);
        }
    }
}
