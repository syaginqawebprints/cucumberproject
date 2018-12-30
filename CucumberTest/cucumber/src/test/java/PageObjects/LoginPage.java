package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static WebElement element = null;
	
	//User Name Text box
	public static WebElement txt_username(WebDriver driver) {
		element = driver.findElement(By.id("username"));
		return element;
	}
	
	
	//Password Text box
	public static WebElement txt_password(WebDriver driver) {
		element = driver.findElement(By.id("password"));
		return element;
	}
	

	//Login button
	public static WebElement btn_login(WebDriver driver) {
		element = driver.findElement(By.name("login"));
		return element;
	}
	
	//Message area
	public static WebElement lbl_loginmessage(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div[role=\"alert\"]"));
		return element;
	}
	
}
