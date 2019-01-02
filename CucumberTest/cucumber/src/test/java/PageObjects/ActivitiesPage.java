package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivitiesPage {

	private static WebElement element = null;
	
	//Page Title
	public static WebElement lbl_pagetitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"x32cae7ea0b432200eff7ef9bb4673a18\"]"));
		return element;
	}
	
	//Request Status Message
	public static WebElement lbl_requestmessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"myTabContent\"]/div/div/div/div[1]/div/div/div[2]"));
		return element;
	}
	
	//Request Status Message ID
	public static WebElement lbl_requestmessages(WebDriver driver) {
		element = driver.findElement(By.id("list_items"));
		return element;
	}
	
	
	//Stack Status Message
	public static WebElement lbl_stackmessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"myTabContent\"]/div/div/div/div[2]/div/div/div[2]"));
		return element;
	}
	
	//Stack Status Tick Mark
	public static WebElement img_stackgreentick(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"myTabContent\"]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/img"));
		return element;
	}
	
}
