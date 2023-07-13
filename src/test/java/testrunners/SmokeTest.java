// Suffix all class names with "Test"
// In TestNG the scenarios and rows in a scenario outline are executed in multiple threads.

package testrunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features = { "src/test/resources/AppFeatures" },
					glue = {"stepdefinitions", "MyAppHooks"},
					// tags = "@Smoke or/and @Regression",
					plugin = {"pretty",
							  "json:target/Myreports/report.json",
							  "junit:target/Myreports/report.xml"
					         },
					//monochrome = true,
					// Generate cucumber HTML reports
					// HTML report link will be displayed in the console after run
					publish = true
				) 
public class SmokeTest  extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() 
    {
        return super.scenarios();
    }
}
