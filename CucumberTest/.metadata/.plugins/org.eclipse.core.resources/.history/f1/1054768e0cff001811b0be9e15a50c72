package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class e2e_test {
	private static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://atoscmpdev.service-now.com/cloud_portal");
		driver.findElement(By.id("username")).sendKeys("rajkumar");
		driver.findElement(By.id("password")).sendKeys("rajkumar");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		String ErrorMessage=driver.findElement(By.xpath("//*[@id=\"x47f8604a0f1626401668956f62050e84\"]/div/form/div/div[2]/div[2]")).getText();
		Assert.assertTrue("Text not found!", ErrorMessage.contains("User name or password invalid"));
		
		driver.quit();

	}

}