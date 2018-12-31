package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.When;

public class LandingPage {
	
	private static WebElement element = null;
	
	//Header Element
	public static WebElement tag_header(WebDriver driver) {
		element = driver.findElement(By.tagName("h2"));
		return element;
	}

	//Site Icon
	public static WebElement img_icon(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/section/header/div/div/nav/div[1]/a[1]/img"));
		return element;
	}
	
	//Launch Stack Option Label
	public static WebElement lbl_LanchAStack(WebDriver driver) {
	    
		element = driver.findElement(By.xpath("//*[@id=\"x9bd766440b472200eff7ef9bb4673acb\"]/div/a"));
		return element;
	}

	//Manage Stacks Option Label
	public static WebElement lbl_ManageStacks(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"x84e766440b472200eff7ef9bb4673ad7\"]/div/a"));
		return element;
	    
	}

	//View Activities Option Label
	public static WebElement lbl_ViewActivities(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//*[@id=\"x5ee7a6440b472200eff7ef9bb4673a2e\"]/div/a"));
		return element;
	    
	}

	//View Dashboard Option Label
	public static WebElement lbl_ViewDashboard(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/section/main/div[1]/div/sp-page-row/div/div/div[2]/sp-page-row/div/div[4]"));
		return element;
	    
	}
	
	//Header Section
	public static WebElement div_HeadSection(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/section/main/div[1]/div/sp-page-row/div/div/div[2]"));
		return element;
	    
	}	
	
	//Header Loader
	public static WebElement div_HeadLoader(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"xdddd43ddc3212200f7d1ca3adfba8f17\"]/div"));
		return element;
	    
	}		
	
	 
}
