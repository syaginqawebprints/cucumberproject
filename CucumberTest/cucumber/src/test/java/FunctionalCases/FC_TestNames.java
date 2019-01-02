package FunctionalCases;

import java.io.File;

public class FC_TestNames {

	public static void main(String[] args) {
	    File directory = new File(System.getProperty("user.dir")+"\\src\\test\\java\\CucumberTests");
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }

	}

	
}
