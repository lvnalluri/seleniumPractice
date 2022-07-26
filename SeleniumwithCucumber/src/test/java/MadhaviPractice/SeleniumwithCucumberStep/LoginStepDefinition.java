package MadhaviPractice.SeleniumwithCucumberStep;

import MadhaviPractice.SeleniumwithCucumberPages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	LoginPage loginpage = new LoginPage();
	@Given("^user is on page \"(.*?)\"$")
	public void user_is_on_page(String arg1) throws Throwable {
		
		loginpage.loadPage(arg1);
		
	}

}
