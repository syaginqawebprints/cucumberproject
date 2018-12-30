package Def_InvalidLogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Def_InvalidLogin {
	WebDriver driver;
	String ValidUName=Utils.CommonScripts.readProperty("user.name");
	String ValidPWD=Utils.CommonScripts.readProperty("password");
	@Given("^user open login page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver=Utils.CommonScripts.openUrl();
		

	}

	@When("^enter invalid user name and valid password and cick login$")
	public void enter_invalid_user_name_and_valid_password_and_cick_login() throws Throwable {
		PageObjects.LoginPage.txt_username(driver).sendKeys("invalid");
		PageObjects.LoginPage.txt_password(driver).sendKeys(ValidPWD);
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
		try {
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Case 1 [invalid user name and valid password] : Error Message Displayed");
				}
				else
				{
					System.out.println("Case 1 [invalid user name and valid password] : Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Case 1 [invalid user name and valid password] : Error Message Not Displayed");
		}
		
		driver.quit();

	    
		
		
	}

	@When("^enter valid user name and invalid password and cick login$")
	public void enter_valid_user_name_and_invalid_password_and_cick_login() throws Throwable {
		PageObjects.LoginPage.txt_username(driver).sendKeys(ValidUName);
		PageObjects.LoginPage.txt_password(driver).sendKeys("invalid");
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
		try {
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Case 2 [valid user name and invalid password] : Error Message Displayed");
				}
				else
				{
					System.out.println("Case 2 [valid user name and invalid password] : Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Case 2 [valid user name and invalid password] : Error Message Not Displayed");
		}
		
		driver.quit();
	   
	}

	@When("^enter invalid user name and invalid password and cick login$")
	public void enter_invalid_user_name_and_invalid_password_and_cick_login() throws Throwable {
		PageObjects.LoginPage.txt_username(driver).sendKeys("invalid");
		PageObjects.LoginPage.txt_password(driver).sendKeys("invalid");
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
		try {
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Case 3 [invalid user name and invalid password] : Error Message Displayed");
				}
				else
				{
					System.out.println("Case 3 [invalid user name and invalid password] : Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Case 3 [invalid user name and invalid password] : Error Message Not Displayed");
		}
		
		driver.quit();

	   
	}
	
	@When("^enter valid user name and valid password and cick login$")
	public void enter_valid_user_name_and_valid_password_and_cick_login() throws Throwable {
		PageObjects.LoginPage.txt_username(driver).sendKeys(ValidUName);
		PageObjects.LoginPage.txt_password(driver).sendKeys(ValidPWD);
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		
		try {
				String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Case 4 [valid user name and valid password] : Error Message Displayed");
				}
				else
				{
					System.out.println("Case 4 [valid user name and valid password] : Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Case 4 [valid user name and valid password] : Error Message Not Displayed");
		}
		
		driver.quit();

	}
	
	@When("^and press login without entering username and password$")
	public void and_press_login_without_entering_username_and_password() throws Throwable {
		PageObjects.LoginPage.txt_username(driver).sendKeys("");
		PageObjects.LoginPage.txt_password(driver).sendKeys("");
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
		try {
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Case 5 [login without entering username and password] : Error Message Displayed");
				}
				else
				{
					System.out.println("Case 5 [login without entering username and password] : Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Case 5 [login without entering username and password] : Error Message Not Displayed");
		}
		
		driver.quit();
	}

	@When("^and press login without entering username and with password$")
	public void and_press_login_without_entering_username_and_with_password() throws Throwable {
		PageObjects.LoginPage.txt_username(driver).sendKeys("");
		PageObjects.LoginPage.txt_password(driver).sendKeys("invalid");
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
		try {
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Case 6 [login without entering username and with password] : Error Message Displayed");
				}
				else
				{
					System.out.println("Case 6 [login without entering username and with password] : Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Case 6 [login without entering username and with password] : Error Message Not Displayed");
		}
		
		driver.quit();
	}

	@When("^and press login without entering password and with username$")
	public void and_press_login_without_entering_password_and_with_username() throws Throwable {
		PageObjects.LoginPage.txt_username(driver).sendKeys("invalid");
		PageObjects.LoginPage.txt_password(driver).sendKeys("");
		PageObjects.LoginPage.btn_login(driver).click();
		Thread.sleep(2000);
		
		String ErrorMessage=PageObjects.LoginPage.lbl_loginmessage(driver).getText();
		try {
				if(ErrorMessage.contains("User name or password invalid"))
				{
					System.out.println("Case 7 [login without entering password and with username] : Error Message Displayed");
				}
				else
				{
					System.out.println("Case 7 [login without entering password and with username] : Error Message Not Displayed");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
				System.out.println("Case 7 [login without entering password and with username] : Error Message Not Displayed");
		}
		
		driver.quit();
		System.out.println("Test Finished ");
	}


}


	
	
	