package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BucketResourcePage {

	private static WebElement element = null;
	
	//Cloud Account Drop-down
	public static WebElement cmb_cloudaccount (WebDriver driver) {
		element = driver.findElement(By.tagName("body"));
		return element;
	}
	
	//Cloud Account Drop-down Value
	public static WebElement cmbval_cloudaccount (WebDriver driver) {
		element = driver.findElement(By.id("select2-result-label-15"));
		return element;
	}
	
	//Cloud Account Drop-down Clickable
	public static WebElement link_cloudaccount (WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_{{::field.name}}\"]"));
		return element;
	}
	
	
	//Location Drop-down 
	public static WebElement cmb_location (WebDriver driver) {
		element = driver.findElement(By.id("sp_formfield_Location"));
		return element;
	}

	//Stack Name Text box
	public static WebElement txt_stackname (WebDriver driver) {
		element = driver.findElement(By.id("sp_formfield_StackName"));
		return element;
	}
	
	//User group Drop-down Value
	public static WebElement cmbval_usergroup (WebDriver driver) {
		element = driver.findElement(By.id("select2-results-3"));
		return element;
	}	

	//Bucket Name Text box
	public static WebElement txt_bucketname (WebDriver driver) {
		element = driver.findElement(By.id("sp_formfield_Storage_Bucket_BucketName"));
		return element;
	}

	//Bucket Submit button
	public static WebElement btn_bucketsubmit (WebDriver driver) {
		element = driver.findElement(By.id("catItemSubmit"));
		return element;
	}
	
	//Loading graphics
	public static WebElement div_loading (WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"x3b166f970fac2f04e7fef77ce1050ed9\"]/div/div/div/span"));
		return element;
	}	
	
}
