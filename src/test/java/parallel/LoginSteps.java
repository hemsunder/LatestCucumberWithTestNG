package parallel;


import org.junit.Assert;
import com.qa.factory.DriverFactory;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accpage = new AccountsPage(DriverFactory.getDriver());
	
	@Given("User is on Login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@Then("Title of the login page should be {string}")
	public void title_of_the_login_page_should_be(String expTitle) {
		String pagetitle = loginpage.getTitle();
		Assert.assertEquals(pagetitle, expTitle);
	}

	@Then("Logo should be displayed")
	public void logo_should_be_displayed() {
		Assert.assertTrue(loginpage.isLogoExists());
	}

	@When("User enters {string} in username textbox")
	public void user_enters_in_username_textbox(String un) {
		loginpage.enterUsername(un);
	}

	@When("User enters {string} in the password textbox")
	public void user_enters_in_the_password_textbox(String pwd) {
		loginpage.enterPassword(pwd);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accpage = loginpage.clickOnLoginbutton();
	}

	@Then("User should be able to login and landed in Accounts page")
	public void user_should_be_able_to_login_and_landed_in_accounts_page() {
		Assert.assertTrue(accpage.isLogoutExists());
	}

}
