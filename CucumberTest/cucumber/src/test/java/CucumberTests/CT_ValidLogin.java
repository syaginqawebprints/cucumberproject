package CucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/ValidLogin", 
glue= {"Def_ValidLogin"}
		
		)

public class CT_ValidLogin {


}