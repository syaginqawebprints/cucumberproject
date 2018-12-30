package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResourcesPage {

	private static WebElement element = null;
	
	//Page Title
	public static WebElement lbl_pagetitle(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"xb8f1d0fd0bf22200eff7ef9bb4673a2e\"]"));
		return element;
	}
}
