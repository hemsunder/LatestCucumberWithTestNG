package parallel;

import org.testng.annotations.DataProvider;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
		features = {"src/test/resources/parallel/Login.feature"},
		glue = {"parallel"},
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target2/failedrerun.txt"},
		monochrome = true
		)



public class ParallelRun extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
