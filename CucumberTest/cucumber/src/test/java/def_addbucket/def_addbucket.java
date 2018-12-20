package def_addbucket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class def_addbucket {
	WebDriver driver;
	
	@Given("^click on catalog menu$")
	public void click_on_catalog_menu() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://atoscmpdev.service-now.com/cloud_portal");
		driver.findElement(By.id("username")).sendKeys("cmp.atos.admin");
		driver.findElement(By.id("password")).sendKeys("cmp.atos.admin");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//*[@id=\"x84e766440b472200eff7ef9bb4673ad7\"]/div/a")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[2]/a")).click();
	    Thread.sleep(2000);
		
	}

	@Given("^Opens Bucket Resource$")
	public void opens_Bucket_Resource() throws Throwable {
	    driver.findElement(By.partialLinkText("Bucket Resource")).click();
	}

	@Given("^Addning new bucket$")
	public void addning_new_bucket() throws Throwable {
	   WebDriverWait wait=new WebDriverWait(driver, 300);
	   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sp_formfield_IO:ebd902030fc4278ce7fef77ce1050e2a\"]")));
	   driver.findElement(By.id("s2id_autogen1_search")).sendKeys("Test Bucket");
	   driver.findElement(By.id("select2-results-1")).click();
	   driver.findElement(By.id("select2-chosen-2")).click();
	   driver.findElement(By.id("select2-results-2")).click();
	   driver.findElement(By.xpath("//*[@id=\"sp_formfield_IO:53d902030fc4278ce7fef77ce1050e11\"]")).sendKeys("Test Bucket");
	   driver.findElement(By.id("select2-drop-mask")).click();
	   driver.findElement(By.id("select2-chosen-3")).click();
	   driver.findElement(By.xpath("//*[@id=\"sp_formfield_IO:ebd902030fc4278ce7fef77ce1050e2a\"]")).sendKeys("Test Bucket");
	   driver.findElement(By.id("catItemSubmit")).click();
	}

	@Given("^Check the Status and print message$")
	public void check_the_Status_and_print_message() throws Throwable {
	    WebDriverWait wait=new WebDriverWait(driver, 300);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"status\"]/div/div[2]/div/div/div[2]/div/div/div/div/div")));
	    String StatusMessage=driver.findElement(By.xpath("//*[@id=\"status\"]/div/div[2]/div/div/div[2]/div/div/div/div/div")).getText();
	    if (StatusMessage.contains("Failed "))
	    {
	    	System.out.println("Operation failed");
	    	System.out.println(StatusMessage);
	    }
	    else if (StatusMessage.contains("Success "))
	    {
	    	System.out.println("Operation Success");
	    	System.out.println(StatusMessage);
	    }
	    
	}
	
	@Given("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Print test finished$")
	public void print_test_finished() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
