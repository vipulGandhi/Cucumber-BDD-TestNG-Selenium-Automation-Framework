// Problems with running multiple tests(classes) in parallel with one driver instance
	// Threads will be dependent on each other
	// Suppose a thread execution is taking more time, a time-out may occur on a different thread which is waiting for the driver
// If we run testNG.xml command:  <suite name="Suite" parallel="test" thread-count="2">
	// 2 browsers will be launched, executing 2 different threads
	// By default, webdriver is not thread safe
	// To make webdriver threadsafe, We use Java ThreadLocal class

package com.qa.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory
{
	public WebDriver driver;
	public Properties properties;
	public OptionsManager optionsManager;
	public static String highlightElement;
	
	// Threads to get the local copy of WebDriver object
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	
	public WebDriver initWebDriver(Properties properties)
	{
		
		String browserName = properties.getProperty("browser").trim().toLowerCase();
		
		highlightElement = properties.getProperty("highlightElement");
		
		optionsManager = new OptionsManager(properties);
				
		// Initialize the driver
		if(browserName.equals("chrome"))
		{
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, optionsManager.getChromeOptions());

			if(Boolean.parseBoolean(properties.getProperty("remote")))
			{
				try
				{
					threadLocal.set(new RemoteWebDriver(new URL(properties.getProperty("huburl")), desiredCapabilities));
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				//driver = new ChromeDriver(optionsManager.getChromeOptions());
				threadLocal.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
		}
		else if(browserName.equals("firefox"))
		{
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsManager.getFirefoxoptions());
			
			if(Boolean.parseBoolean(properties.getProperty("remote")))
			{
				try
				{
					threadLocal.set(new RemoteWebDriver(new URL(properties.getProperty("huburl")), desiredCapabilities));
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				//driver = new FirefoxDriver(optionsManager.getFirefoxoptions());
				threadLocal.set(new FirefoxDriver(optionsManager.getFirefoxoptions()));
			}
		}
		else if(browserName.equals("safari"))
		{
			//driver = new SafariDriver();
			threadLocal.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser name: " + browserName);
		}
		
		// Preconditions
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		
		return getDriver();
	}

	// Return local copy of WebDriver
	public static synchronized WebDriver getDriver()
	{
		return threadLocal.get();
	}

	
	public void getPageUrl(WebDriver driver, String url)
	{
		try
		{
			if(url == null)
			{
				throw new Exception("url is null ...");
			}
		}
		catch (Exception e)
		{
		}

		driver.get(url);
	}
	
	public void getPageUrl(WebDriver driver, URL url)
	{
		try
		{
			if(url == null)
			{
				throw new Exception("url is null ...");
			}
		}
		catch (Exception e)
		{
		}

		driver.navigate().to(url);
	}
	
	public void getPageUrl(WebDriver driver, String baseUrl, String endpoint)
	{
		try
		{
			if(baseUrl == null)
			{
				throw new Exception("baseUrl is null ...");
			}
		}
		catch (Exception e)
		{
		}

		driver.get(baseUrl + "/" + endpoint);
	}
	
	public void getPageUrl(WebDriver driver, String baseUrl, String endpoint, String queryParameter)
	{
		try
		{
			if(baseUrl == null)
			{
				throw new Exception("baseUrl is null ...");
			}
		}
		catch (Exception e)
		{
		}

		driver.get(baseUrl + "/" + endpoint + "?" + queryParameter);
	}
	
	// https://username:password@URL
	public void getPageUrlWithBrowserAuthentication(WebDriver driver, String url, String username, String password)
	{
		try
		{
			if(url == null)
			{
				throw new Exception("url is null ...");
			}
		}
		catch (Exception e)
		{
		}
		
		String urlAuthenticationString = "https://" + username + ":" + password + "@" + url.split("//")[1];

		driver.get(urlAuthenticationString);
	}
}
