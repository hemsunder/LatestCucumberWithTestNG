package parallel;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory dfactory;
	private WebDriver driver;
	private ConfigReader confreader;
	Properties prop;
	
	@Before(value = "@Skip")
	public void skiptest(Scenario scenario) {
		System.out.println("skipped scenario name is "+scenario.getName());
		Assume.assumeTrue(false);
	}
	
	
	@Before(order=0)
	public void getproperty() {
		confreader = new ConfigReader();
		prop = confreader.init_prop();
	}
	
	@Before(order=1)
	public void launchbrowser() {
		dfactory = new DriverFactory();
		driver = dfactory.init_driver(prop.getProperty("browser"));
	}
	
	@After(order=0)
	public void quitbrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario sc) {
		if(sc.isFailed()) {
			String screenshotname = sc.getName().replaceAll(" ", "_");
			byte[] src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(src, "image/png", screenshotname);
		}
	}
	
	

}
