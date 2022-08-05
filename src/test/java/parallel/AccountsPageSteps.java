package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.qa.factory.DriverFactory;
import com.qa.pages.AccountsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountsPageSteps {
	public static String pname;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accpage = new AccountsPage(DriverFactory.getDriver());
	private ProductPage prpage = new ProductPage(DriverFactory.getDriver());
	
	@Given("User should be logged in to application")
	public void user_should_be_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> lists = dataTable.asMaps();
		String username = lists.get(0).get("Username");
		String password = lists.get(0).get("Password");
//		System.out.println("Username is "+username);
//		System.out.println("Password is "+password);
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		accpage = loginpage.doLogin(username, password);
	}

	@Given("User has search feild to search for a product")
	public void user_has_search_feild_to_search_for_a_product() {
		Assert.assertTrue(accpage.isSearchFeildExists());
	}

	@When("User enters productname in search feild")
	public void user_enters_productname_in_search_feild(DataTable dataTable) {
		List<String> list =  dataTable.asList();
		pname = list.get(0);
		prpage = accpage.enterProductName(pname);
	}

	@Then("Product should be displayed")
	public void product_should_be_displayed() {
		String name = prpage.getProductname();
		System.out.println("Name of the Product is "+name);
		Assert.assertTrue(name.contains(pname));
	}

	@Given("User should find the My account sub menu options")
	public void user_should_find_the_my_account_sub_menu_options() {
		Assert.assertTrue(accpage.myaccountSubmenu());
	}

	@Then("User should find the below links")
	public void user_should_find_the_below_links(DataTable dataTable) {
//		List<List<String>> lists = dataTable.asLists();
//		for(List<String> e:lists) {
//			System.out.println(e);
//		}
		
		List<String> list = dataTable.asList();
		System.out.println("Test data from feature file is "+list);
		
		List<String> submenu = accpage.getMyaccountsubmenu();
		System.out.println("submenu options from application is "+ submenu);
		
		Assert.assertTrue(list.equals(submenu));
	}

}
