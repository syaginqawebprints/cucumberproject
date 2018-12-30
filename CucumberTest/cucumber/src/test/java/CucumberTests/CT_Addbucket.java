package CucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/AddBucket", 
glue= {"Def_addbucket"}
		
		)

public class CT_Addbucket {


}