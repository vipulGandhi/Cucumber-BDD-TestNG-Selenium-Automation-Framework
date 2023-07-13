package stepdefinitions;

import java.util.List;

import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LandingPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When; 

public class HomePageSteps
{
	private LandingPage landingPage = new LandingPage(DriverFactory.getDriver());
	private  HomePage homePage;
	private List<String> loginPanelItemsActualList;
	private int loginPanelItemCount;
	
    @And("User sign in with valid username {string} and password {string}")
    public void user_has_logged_in_to_the_application(String userName, String password)
    {
    	homePage = landingPage.doSignIn(userName, password);
    }
	
    @When("User gets the count of login panel items")
    public void user_gets_the_count_of_login_panel_items()
    {
    	loginPanelItemCount = homePage.getLoginPanelItemsCount();
    }

    @Then("Login panel item count should be {string}")
    public void login_panel_item_count_should_be(String itemCount)
    {
    	Assert.assertEquals(loginPanelItemCount, Integer.parseInt(itemCount));
    }
    
    @Then("Login panel items should be")
    public void login_panel_items_should_be(DataTable dataTable)
    {
    	loginPanelItemsActualList = homePage.getLoginPanelItems();
    	for (String string : loginPanelItemsActualList) {
			System.out.println("loginPanelItemsActualList " + string);
		}
    	
    	List<List<String>> loginPanelItemsExpectedListofList = dataTable.asLists(String.class);
    	
    	for (List<String> list : loginPanelItemsExpectedListofList)
    	{
    		System.out.println("List item ... " + list);
		}
    }
}
