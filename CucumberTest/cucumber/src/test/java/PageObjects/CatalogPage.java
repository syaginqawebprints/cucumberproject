package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage {
	
	private static WebElement element = null;
	
	//Body Tag
	public static WebElement tag_body(WebDriver driver) {
		element = driver.findElement(By.tagName("body"));
		return element;
	}
	//Page Title
	public static WebElement lbl_pagetitle(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/div/section/main/div/div/sp-page-row/div/div[1]"));
		return element;
	}
	
	//Catlog Items Area Title
	public static WebElement div_catlogitems(WebDriver driver) {
		element =driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/sp-page-row/div/div[2]"));
		return element;
	}
	

}
