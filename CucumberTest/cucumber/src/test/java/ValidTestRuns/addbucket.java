package ValidTestRuns;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/AddBucket", 
glue= {"def_addbucket"}
		
		)

public class addbucket {


}