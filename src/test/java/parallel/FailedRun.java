package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"@target/failedrerun"},
		glue = {"parallel"},
		plugin = {"pretty", 
				"rerun:target/failedrerun.txt"},
		monochrome = true 
		)

public class FailedRun extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
