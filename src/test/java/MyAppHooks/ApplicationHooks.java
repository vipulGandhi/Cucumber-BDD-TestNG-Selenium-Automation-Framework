package MyAppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.ConfigReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks
{
	DriverFactory driverFactory;
	WebDriver driver;
	ConfigReader configReader;
	Properties properties;

	
	// Executes before every scenario
	@Before(order = 0)
	public void getProperty()
	{
		configReader = new ConfigReader();
		properties = configReader.initProperties();
	}
	
	@Before(order = 1)
	public void launchBrowser(Scenario scenario)
	{
		driverFactory = new DriverFactory();
		driver = driverFactory.initWebDriver(properties);
		System.out.println("Browser is launched ...");
		System.out.println("Executing scenario: " + scenario.getName());
	}
	
	//@Before("@Smoke")
	@Before(order = 2)
	public void SetUpDatabase()
	{
		System.out.println("Setup the database ...");
	}
	
	
	@After(order = 1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenShotName = scenario.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
			System.out.println("Scenario Failed, Take Screenshot ...");
		}
	}
	
	@After(order = 0)
	public void quitBrowser()
	{
		System.out.println("Quit the browser ...");
		driver.quit();
	}
}
