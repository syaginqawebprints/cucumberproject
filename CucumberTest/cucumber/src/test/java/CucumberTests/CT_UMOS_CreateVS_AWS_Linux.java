package CucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/CreateManagedVirtualServerAWS", 
				glue= {"Def_UMOS_CreateVS_AWS_Linux"}
		
		)
public class CT_UMOS_CreateVS_AWS_Linux {

}
