package com.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
	private Properties properties;
	private FileInputStream fileInputStream;
	
	// Initialize properties
	public Properties initProperties()
	{
		properties = null;
		fileInputStream = null;

		String environmentString = System.getProperty("environment");// mvn clean install -Denv="qa"

		try
		{
			if (environmentString == null)
			{
				System.out.println("Running on QA environment ....");
				fileInputStream = new FileInputStream("./src/test/resources/configurations/qa.config.properties");
			}
			else
			{
				System.out.println("Running on " + environmentString  + " environment");
				switch (environmentString)
				{
				case "qa":
					fileInputStream = new FileInputStream("./src/test/resources/configurations/qa.config.properties");
					break;
				case "dev":
					fileInputStream = new FileInputStream("./src/test/resources/configurations/dev.config.properties");
					break;
				case "staging":
					fileInputStream = new FileInputStream("./src/test/resources/configurations/staging.config.properties");
					break;
				case "production":
					fileInputStream = new FileInputStream("./src/test/resources/configurations/production.config.properties");
					break;

				default:
					System.out.println("No environment found.....");
					throw new Exception("NOENVFOUNDEXCEPTION");

				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			properties = new Properties();
			properties.load(fileInputStream);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return properties;
	}
}
