package CucumberTests;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/InvalidLogin", 
glue= {"Def_InvalidLogin"}
		
		)

public class CT_InvalidLogin {

}
