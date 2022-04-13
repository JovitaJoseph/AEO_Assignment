package cucumberTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@AddToBag or @ProceedToCheckout",features = "C:\\Users\\Jovita Joseph\\eclipse-workspace\\AEO\\src\\main\\resources\\features\\AddToBag.feature",
glue="stepDefinition",plugin= {"pretty","json:target/cucumber-reports.json"})
public class TestRunnerAddToBag extends AbstractTestNGCucumberTests{

}
