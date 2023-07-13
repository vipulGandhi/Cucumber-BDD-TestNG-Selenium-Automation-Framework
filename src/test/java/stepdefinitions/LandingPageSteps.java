package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LandingPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LandingPageSteps
{
	private HomePage homePage;
	private WebDriver driver = DriverFactory.getDriver();
	private LandingPage landingPage = new LandingPage(driver);
	private DriverFactory driverFactory = new DriverFactory();
	
    @Given("User enters the url {string} in the browser")
    public void user_is_on_landing_page(String pageUrl)
    {
    	driverFactory.getPageUrl(driver, pageUrl);
    }
    
    @Then("Page title should contain {string}")
    public void page_title_should_contain(String pageTitleSubString)
    {	
    	Assert.assertTrue(landingPage.isTitleSubstringPresent(pageTitleSubString));
    }

    @Then("Page url should contain {string}")
    public void page_url_should_contain(String urlSubString)
    {
    	Assert.assertTrue(landingPage.isUrlSubstringPresent(urlSubString));
    }
    
    @When("User sign in with valid UserName and Password")
    public void user_sign_in_with_valid_username_and_password(DataTable dataTable)
    {
    	List<Map<String, String>> credentialListMap = dataTable.asMaps(String.class, String.class);
    	String userName = credentialListMap.get(0).get("UserName");
    	String password = credentialListMap.get(0).get("Password");
    	homePage = landingPage.doSignIn(userName, password);
    }
    
    @Then("User is on the dashboard with the username {string}")
    public void user_is_on_the_dashboard_page_with_the_username(String userName)
    {
    	Assert.assertEquals(homePage.getUserName(), userName);
    }
}
