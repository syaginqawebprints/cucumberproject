package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageStacksPage {
	
	private static WebElement element = null;
	
	//Menu Bar
	public static WebElement div_menubar(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul"));
		return element;
	}

	//Catalog Menu 
	public static WebElement menu_catalog(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[2]/a"));
		return element;
	}
	
	//Overview Menu 
	public static WebElement menu_Overview(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[1]/a"));
		return element;
	}
	
	//Stacks Menu 
	public static WebElement menu_Stacks(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[3]/a"));
		return element;
	}
	
	//Resources Menu 
	public static WebElement menu_resources(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[4]/a"));
		return element;
	}
	
	//Activities Menu 
	public static WebElement menu_activities(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[5]/a"));
		return element;
	}
	
	//Dashboard Menu 
	public static WebElement menu_dashboard(WebDriver driver) {
		element =driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[6]/a"));
		return element;
	}
}
