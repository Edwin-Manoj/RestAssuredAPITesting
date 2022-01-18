package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/placeValidation.feature",plugin = "json:target/jsonReports/cucumber-Report.json",glue= {"stepDefinitions"})
public class testRunner {
//tags= @DeletePlace
}
