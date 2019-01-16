package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SnapshotPage {
	
	private static WebElement element = null;
	
	//Cloud Account Drop down
	public static WebElement cmb_CloudAccount(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_{{::field.name}}\"]/a"));
		return element;
	}
	
	//Stack Name Text Box
	public static WebElement txt_StackName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sp_formfield_StackName\"]"));
		return element;
	}
	
	//Location Drop down
	public static WebElement cmb_Location(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_{{::field.name}}\"]/a"));
		return element;
	}
	
	//User Group Drop down
	public static WebElement cmb_UserGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_{{::field.name}}\"]/a"));
		return element;
	}
	
	//Provision Tab
	public static WebElement btn_provision(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"section-1\"]"));
		return element;
	}
	
	//Volume Id drop down
	public static WebElement cmb_volumeid(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_{{::field.name}}\"]/a"));
		return element;
	}
	
	//Description Text box
	public static WebElement txt_description(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sp_formfield_Snapshot_Description\"]"));
		return element;
	}
	
	//Submit button
	public static WebElement btn_submit(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"catItemSubmit\"]"));
		return element;
	}
	
}
