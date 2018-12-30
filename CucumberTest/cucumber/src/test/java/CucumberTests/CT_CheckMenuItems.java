package CucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/CheckMenuItems", 
glue= {"Def_CheckMenuItems"}
		
		)

public class CT_CheckMenuItems {


}