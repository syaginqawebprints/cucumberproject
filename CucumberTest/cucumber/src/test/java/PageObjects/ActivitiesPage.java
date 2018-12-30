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
}
