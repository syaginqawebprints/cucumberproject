package ValidTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidLogin {
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://atoscmpdev.service-now.com/cloud_portal");
		driver.findElement(By.id("username")).sendKeys("cmp.atos.admin");
		driver.findElement(By.id("password")).sendKeys("cmp.atos.admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		String BodyText=driver.findElement(By.tagName("h2")).getText();
		Assert.assertTrue("Text not found!", BodyText.contains("Welcome to the Cloud User Portal"));
		
		driver.quit();

	}

}