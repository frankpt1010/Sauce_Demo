package NewTestCases;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", 
				features = {"src/test/resources/features/login.feature"}, 
				glue = {"stepdefinitions"},
                plugin = {})
    
public class RunSauceDemoTest extends AbstractTestNGCucumberTests {
    
}

