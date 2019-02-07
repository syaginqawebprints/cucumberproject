package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StacksPage {

	private static WebElement element = null;
	
	//Page Title
	public static WebElement lbl_pagetitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"xf66309b50be32200eff7ef9bb4673aaf\"]"));
		return element;
	}
	
	//Search Text box
	public static WebElement txt_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/div/div/form/div/input"));
		return element;
	}
	
	//Search button
	public static WebElement btn_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/div/div/form/div/span/button"));
		return element;
	}
	
	//Search Suggestion Container
		public static WebElement div_searchsuggestion(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"typeahead-36-3312\"]"));
		return element;
	}
	
	//Search Result Container
		public static WebElement div_searchrsults(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/section/main/div/div/sp-page-row/div/div[2]"));
		return element;
	}
	
		
		//Delete Virtual Server Button
		public static WebElement btn_deleteserver(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"detele_stack\"]"));
		return element;
	}
		
		//Deprovision Action drop-down
		public static WebElement cmb_DeprovisionAction(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"x4a6a1c9a373fd748b8280ba754990e27\"]/div/div[2]/div/select"));
		return element;
	}
		
		
	//Deprovision OK button
		public static WebElement btn_DeprovisionOK(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[2]"));
		return element;
	}
			
		
		// Search Result Area 
		public static WebElement Div_SearchResultArea(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div/section/main/div/div/sp-page-row/div/div[2]"));
		return element;
	}
		
	
}
