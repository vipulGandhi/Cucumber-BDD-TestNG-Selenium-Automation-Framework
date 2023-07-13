// TDD vs. BDD vs. ATDD [https://www.youtube.com/watch?v=iQcimgQohHs]
	// TDD [Test Driven Development]
		// Steps:
			// 1. Developer create Unit level test cases for a feature (in TestNG or JUnit)
			// 2. Execute the test cases (Test cases will fail for the first time)
			// 3. Implement functionality for the test cases to pass
			// 4. Run steps 2 and 3 again till all test cases are passed
	// BDD [Behaviour Driven Development]
		// Super set of TDD
		// Can be used for UI, API
		// Steps:
			// 1. PO, dev, QA create the feature files, scenarios for a feature
			// 2. Developer will write the test cases based on the feature file 
			// 3. Testers will write the test cases based on the feature file 
			// 4. Run steps 2 and 3 again till all test cases of a feature file are passed
	// ATDD [Acceptance Test Driven Development]
		// Super set of BDD
		// Steps:
			// 1. PO, Business, BA create the high level user stories/ requirement document and define the acceptance criteria
			// 2. The requirements are shared to dev & QA team
			// 3. Based on the requirement document, the team follow either TDD or BDD approach

// BDD (Behavioral Driven Development)
		// "Given" the precondition [User is at login page of E-Commerce Application]
		// "When" the action is performed [User login with valid username and password]
		// "Then" Assert the output [User is redirected to home page]

// Cucumber
	// Tool/ Framework which supports BDD approach

// Gherkin
	// It is a business-readable, domain-specific language that lets us describe software's behaviour

// Keywords used in cucumber
	// Scenario
	// Feature
	// Feature file
	// Scenario outline
	// Step Definition

// Scenario
	// Scenarios are test-cases
	// Steps in Scenarios: Given, When, Then, But, And (case sensitive)
	// Every method written in step-definition file will be attached to the scenario's steps
	// Example Scenario: User login to the web portal
 		// Given: User is on the login portal
 		// When: User input the username and password
        	// And: User click on the Login button
		// Then: User is redirected to home page
        	// And: User's name is displayed on the home page
         	// But: Error message is not displayed
	// All the scenarios should be independent to each other for them to run in parallel

// Feature
	// Feature is a requirement or a functionality
	// We design multiple scenarios(all positive and negative test cases) to completely verify a feature
	// For every Scenario, we should have a feature defined
	// Example Feature: User login to web portal
		// Scenario: Login with valid credentials
 			// Given: User is on the login portal
 			// When: User input the username and password
        		// And: User click on the Login button
			// Then: User's home page is displayed
        		// And: User's name is displayed on the home page
         		// But: Error message is not displayed
		// Scenario: Login with invalid credentials
 			// Given: User is on the login portal
 			// When: User input wrong username and password
        		// And: User click on the Login button
			// Then: User's home page is not displayed
        		// And: Error message is displayed

// Feature File
	// Feature File is a Test Suite containing Feature and all the respective Scenarios and Scenario Outline
	// Name of Feature files should be lowercase with .feature extension
	// Create Feature file in src/test/resources (Maven Quickstart Template)
	// If the tests are running in sequential order, features are run in alphabetical order by feature file name

// Scenario Outline
	// Scenario Outline is used to achieve parameterization of test cases(Run a test case multiple times with different data-sets)

// Step Definition
	// .java file where automation code is written which is attached/ mapped to Scenarios of Feature File
	// Create Step Definition in src/test/java (Maven Quickstart Template)
	// For every webpage, create a different step definition file
	// There should be only one mapping implementation of each Gherkin(Given, When, Then)
	// We can set the order of execution for test methods in Cucumber with the help of order keyword
		// The test method with lower order executes first followed by the methods with higher orders

// Test Runner
	// Test Runner triggers the Feature File(all the test cases)
	// Create a Package then testrunner file in src/test/java
	// Test Runner gets the location of Feature file, Step Definition file attached to that Feature file for it's execution
		// @CucumberOptions(features = "src/test/java/features", glue = "StepDefinitions")
			// features and StepDefinitions are packages containing respective files"
		// JUnit is preferred over TestNG because Cucumber comes tightly integrated with JUnit
	// Test Runner (JUnit vs. TestNG) [Either use Junit or TestNG dependencies in pom.xml. Having both may result in inconsistent results]
		// JUnit: 
 			// @RunWith(Cucumber.class) annotation is used
		// TestNG
			// Implementing class extends AbstractTestNGCucumberTests class

// Tags
	// The feature/ scenarios could be tagged as @Sanity, @Smoke, @Regression etc. 


// Cucumber Installation
	// Install Cucumber plugin
 		// Help -> Eclipse Marketplace -> Search and install "Cucumber Eclipse Plugin" 
			// Helps to create multiple feature files
			// Highlight gherkin keywords
	// Create Maven project [Artifact Id: maven-archetype-quickstart]
		// Right-Click on Project Name -> Configure -> Convert To Cucumber Project
		// Add "Cucumber JVM: Java", "Cucumber JVM: JUnit", "Cucumber JVM: JUnit" dependencies to pom.xml from Maven Repository
		// Search "cucumber-java-skeleton git" on google
		// copy-paste the <build> ... </build> section from git pom.xml to project's pom.xml

// Tidy Gherkin
	// Tidy Gherkin Chrome extension converts Feature File Scenarios to Step definitions
	// Write all Scenarios in Feature File, paste them in Tidy Gherkin to convert them into java code

// Misc
	// In Eclipse, with Cucumber plugin installed:
		// "Ctrl + Click" on Given/ When/Then line in Feature file shifts to its respective mapping in .java class
	// To get Java Glue code for Step Definition file:
		// Create Feature file
 		// Create Step definition file without java glue code
 		// Create and Run JUnit Test Runner file
 		// You will get java glue code (in test runner output file)

// Handling Multiple Parameters
	// Method - 1:
		// In Feature file, Cucumber treats anything written inside "" as dynamic
			// # Positive Scenario
         	// Scenario: Home Page Login
         	// Given User is on E-Commerce Landing Page
         	// When User Login into application with Username "ActiveUserRamesh" and Password "PasswordRamesh"
        	// Then Home page is populated
        	// And User name displayed "true"

			// # Negative Scenario
        	// Scenario: Home Page Login
        	// Given User is on E-Commerce Landing Page
        	// When User Login into application with Username "InactiveUserRakesh" and Password "PasswordRakesh"
        	// Then Home page is populated
        	// And User name displayed "false"
 		// Run Test Runner to get respective java glue code for @When

	// Method - 2
		// Data Table
		// Write all the data (in an order) by separating them with a pipeline parameter
			// | Data_A | Data_B | Data_C | Data_D | Data_E | Data_F |
			// | Data_1 | Data_2 | Data_3 | Data_4 | Data_5 | Data_6 |
		// Note: When there are many arguments, it is suggestable to use Data Table

/*
@CucumberOptions(features = "src/test/java/features",
								 glue = "StepDefinitions",
                                 dryRun = false,
                                 monochrome = true,
                                 stepNotifications = true,
                                 tags = "@RegressionTest or @SanityTest",
                                 plugin = { "pretty", "html:target/CucumberReport.html", "json:target/CucumberReport.json", "junit:target/CucumberReport.xml"})
*/
	// dryRun = true
		// The code does not executes, it only validates if every scenario is mapped to StepDefinition or not
			// If not, it outputs the respective StepDefinition code
	// monochrome = true
		// Gives a neat output in Console
	// stepNotifications = true [To get a notification weather all "Given/When/Then" in the Feature File are passed/ failed (Only for JUnit)]
	// pretty = Apply colors to output report
	// html:target/CucumberReport.html
		// Create a HTML report at path target/CucumberReport.html [Refresh the project first]
	// json:target/CucumberReport.json
		// Create a Json report at path target/CucumberReport.json
	// junit:target/CucumberReport.xml
		// Create a xml report at path target/CucumberReport.xml

// To run selected scenarios from different feature files
	// use a common tag for all scenarios. Add the tag in @CucumberOptions in TestRunner file
		// Run Scenarios which have either Regression or Smoke tag from all Feature files
			/*
				@CucumberOptions(features = "src/test/java/features",
				glue = "StepDefinitions",
				stepNotifications = true,
				tags = "@RegressionTest or @SmokeTest")
			 */

// Run maven project from command line
	// Open terminal
	// cd projectPath
	// Run mvn test OR mvn test -Dcucumber.filter.tags="@Smoke or @Regression"
		// It will automatically pick TestRunner class and will execute the project

// Prerequisite Test Case:
	// "Background:" Keyword:
		// Occasionally we find that we are repeating same Given steps in all the scenarios in a Feature
		// We write those steps under the "Background:" keyword in the feature file
		// "Background:" will run before every Scenario in that Feature file only. It has no effect on any other Feature file.
 		// Test Cases with "Background:" keyword should be written before any other scenario 

	// Hooks (@Before, @After) (@BeforeStep, @AfterStep)
		// Hooks are not the part of feature file
		// @Before and @After are same as Setup() and TeatDown() methods of TestNG
			// Initialize the driver
			// Launch the browser with the url
			// Delete cookies
			// Close Database connection
			// Quit browser
      	// @Before is executed before each scenario
		// @After is executed after each scenario
		// @BeforeStep is executed before each scenario step
		// @AfterStep is executed after each scenario step
		// We can have multiple @Before, @After methods in a class
			// Their execution order will be @Before(order = 1) then @Before(order = 2) ...
			// Their execution order will be @After(order = 2) then @After(order = 1) ...

// Parallel Testing with Dependency Injection
	// To share the data between multiple step-definition files, we use dependency injection (DI) with the help of PicoContainer
	// In Cucumber BDD framework, to share the data between multiple step-definition files, use PicoContainer
		// Add PicoContainer dependency
		// Create a java file which contains the data

// Parallel Execution [https://cucumber.io/docs/guides/parallel-execution/?lang=java#junit-5]
	// JUnit 5
		// By JUnit the feature files are run in parallel and not scenarios
		// All the scenarios in a feature file will be executed by the same thread
		// How
			// Add the configuration in maven surefire plugin
				/*
				 	<configuration>
						<parallel>methods</parallel>
						<useUnlimitedThreads>true</useUnlimitedThreads>
					</configuration>
				 */
	// TestNG
		// By TestNG scenarios are run in parallel
		//  Set @DataProvider(parallel = true)
			// The default thread count of the dataprovider in parallel mode is 10

