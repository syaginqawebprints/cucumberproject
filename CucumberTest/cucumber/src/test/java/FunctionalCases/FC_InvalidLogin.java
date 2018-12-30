package FunctionalCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FC_InvalidLogin {
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver=Utils.CommonScripts.openUrl();
		PageObjects.LoginPage.txt_username(driver).sendKeys("invalid");
		PageObjects.LoginPage.txt_password(driver).sendKeys("invalid");
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
		try {
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Error Message Displayed");
					System.out.println("Test Finished Successfully");
				}
				else
				{
					System.out.println("Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Test finished with errors !");
		}
		
		driver.quit();

	}
	
	

}