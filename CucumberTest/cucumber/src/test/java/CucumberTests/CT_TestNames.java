package CucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/TestNames",
	glue= {"Def_TestNames"}
		
		)

public class CT_TestNames {


}