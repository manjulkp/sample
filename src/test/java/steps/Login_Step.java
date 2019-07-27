package steps;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.Login_Page;

public class Login_Step extends TestBase {
	Login_Page login = new Login_Page(driver);
	

	@Given("I am in Welcome screen")
	public void i_am_in_Welcome_screen() {
		login.isUserInWelcomeScreen();
	}

	@When("I login with valid credential")
	public void i_login_with_valid_credential() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

}
