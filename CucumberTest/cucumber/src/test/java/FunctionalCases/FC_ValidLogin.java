package FunctionalCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FC_ValidLogin {
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver=Utils.CommonScripts.DoLogin();
		Thread.sleep(2000);
		
		String BodyText=PageObjects.LandingPage.tag_header(driver).getText();
		try {
			if(BodyText.contains("Welcome to the Cloud User Portal"))
			{
				System.out.println("Case [Valid Login] : Login Welcome Message Displayed");
			}
			else
			{
				System.out.println("Case [Valid Login] : Login Welcome Message Not Displayed");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
			System.out.println("Case [Valid Login] : Login Welcome Message Not Displayed");
	}
	
	
		
		driver.quit();

	}

}