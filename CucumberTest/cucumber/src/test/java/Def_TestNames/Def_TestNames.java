package Def_TestNames;

import java.io.File;

import cucumber.api.java.en.Given;

public class Def_TestNames {
	
	@Given("^Print all available test names$")
	public void print_all_available_test_names() throws Throwable {
	    File directory = new File(System.getProperty("user.dir")+"\\src\\test\\java\\CucumberTests");
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }
	}


}
