package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class TestRunner {

	@RunWith(Cucumber.class)
	@CucumberOptions 
	(
		features=".//Features/Customer.feature",
		glue="stepDefinitions",
		dryRun=true,
		monochrome=true,
		plugin= {"pretty", "html:Reports\\test-output"},
		tags="@Test2"
		
	)
		
	public class TestRun
	{
		
	}
	
	//Cucumber dry run is used for compilation of the Step Definition and Feature files and to verify the compilation errors
}
