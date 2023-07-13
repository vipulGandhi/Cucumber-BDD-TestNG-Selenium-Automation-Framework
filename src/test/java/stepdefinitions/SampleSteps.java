package stepdefinitions;

import io.cucumber.java.en.*;

public class SampleSteps
{
	@Given("User is at the login page")
    public void user_is_at_the_login_page()
	{
		System.out.println("User is at the login page ...");
    }

    @When("User enter valid username {string} and password {int}")
    public void user_enter_valid_username_and_password(String name, Integer password)
    {
    	System.out.println("User enter valid username: " + name + " and password: " + password + " ... ");
    }

    @Then("Webpage redirects to user dashboard")
    public void webpage_redirects_to_user_dashboard()
    {
    	System.out.println("Webpage redirects to user dashboard ... ");
    }
}
