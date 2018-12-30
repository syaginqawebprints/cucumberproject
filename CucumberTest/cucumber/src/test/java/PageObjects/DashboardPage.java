package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	

	private static WebElement element = null;
	
	//Page Content iFrame
	public static WebElement ifram_dashboard(WebDriver driver) {
		element = driver.findElement(By.id("dashboard"));
		return element;
	}

}
