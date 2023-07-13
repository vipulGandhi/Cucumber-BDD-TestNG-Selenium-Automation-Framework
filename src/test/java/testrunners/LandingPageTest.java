// Suffix all class names with "Test"

package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(
//					features = { "src/test/resources/AppFeatures/LandingPage.feature" },
//					glue = {"stepdefinitions", "MyAppHooks"},
//					// tags = "@Smoke or/and @Regression",
//					plugin = {"pretty",
//							  "json:target/Myreports/report.json",
//							  "junit:target/Myreports/report.xml"
//					         },
//					//monochrome = true,
//					// Generate cucumber HTML reports
//					// HTML report link will be displayed in the console after run
//					publish = true
//				) 
public class LandingPageTest  extends AbstractTestNGCucumberTests
{
}
