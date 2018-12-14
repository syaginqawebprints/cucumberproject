package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver driver;

	@Given("^user open login page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://atoscmpdev.service-now.com/cloud_portal");
		

	}

	@When("^enter invalid user name and valid password and cick login$")
	public void enter_invalid_user_name_and_valid_password_and_cick_login() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("invalid");
		driver.findElement(By.id("password")).sendKeys("cmp.atos.admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		String ErrorMessage=driver.findElement(By.xpath("//*[@id=\"x47f8604a0f1626401668956f62050e84\"]/div/form/div/div[2]/div[2]")).getText();
		Assert.assertTrue("Text not found!", ErrorMessage.contains("User name or password invalid"));
		
		driver.quit();
	    
	}

	@When("^enter valid user name and invalid password and cick login$")
	public void enter_valid_user_name_and_invalid_password_and_cick_login() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("cmp.atos.admin");
		driver.findElement(By.id("password")).sendKeys("invalid");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		String ErrorMessage=driver.findElement(By.xpath("//*[@id=\"x47f8604a0f1626401668956f62050e84\"]/div/form/div/div[2]/div[2]")).getText();
		Assert.assertTrue("Text not found!", ErrorMessage.contains("User name or password invalid"));
		
		driver.quit();
	   
	}

	@When("^enter invalid user name and invalid password and cick login$")
	public void enter_invalid_user_name_and_invalid_password_and_cick_login() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("invalid");
		driver.findElement(By.id("password")).sendKeys("invalid");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		String ErrorMessage=driver.findElement(By.xpath("//*[@id=\"x47f8604a0f1626401668956f62050e84\"]/div/form/div/div[2]/div[2]")).getText();
		Assert.assertTrue("Text not found!", ErrorMessage.contains("User name or password invalid"));
		
		driver.quit();
	   
	}
	
	@When("^enter valid user name and valid password and cick login$")
	public void enter_valid_user_name_and_valid_password_and_cick_login() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("cmp.atos.admin");
		driver.findElement(By.id("password")).sendKeys("cmp.atos.admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		String ErrorMessage=driver.findElement(By.xpath("//*[@id=\"x47f8604a0f1626401668956f62050e84\"]/div/form/div/div[2]/div[2]")).getText();
		Assert.assertTrue("Text not found!", ErrorMessage.contains("User name or password invalid"));
		
		driver.quit();
	   
	}
}


	
	
	