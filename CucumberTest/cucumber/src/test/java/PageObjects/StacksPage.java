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
}
