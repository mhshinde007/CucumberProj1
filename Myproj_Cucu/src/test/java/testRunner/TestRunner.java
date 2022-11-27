package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class TestRunner {

	@RunWith(Cucumber.class)
	@CucumberOptions 
	(
		features=".//Features/Login.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty", "html:Reports\\test-output"}
		
	)
		
	public class TestRun
	{
		
	}
	
	//Cucumber dry run is used for compilation of the Step Definition and Feature files and to verify the compilation errors
}
