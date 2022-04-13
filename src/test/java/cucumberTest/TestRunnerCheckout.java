package cucumberTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@AddToBag or @ProceedToCheckout", features = "C:\\Users\\Jovita Joseph\\eclipse-workspace\\AEO\\src\\main\\resources\\features\\PDPCheckout.feature",
glue="stepDefinition1",plugin= {"pretty","json:target/cucumber-reports.json"})
public class TestRunnerCheckout extends AbstractTestNGCucumberTests {

}
