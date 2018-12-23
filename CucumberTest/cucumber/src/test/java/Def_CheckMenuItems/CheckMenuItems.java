package Def_CheckMenuItems;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class CheckMenuItems {
	
	WebDriver driver;

	@Given("^user loges into page$")
	public void user_loges_into_page() throws Throwable {
		driver = Utils.CommonScripts.openUrl();
		driver.findElement(By.id("username")).sendKeys("cmp.atos.admin");
		driver.findElement(By.id("password")).sendKeys("cmp.atos.admin");
		driver.findElement(By.name("login")).click();
	}

	@Given("^click on manage stock option$")
	public void click_on_manage_stock_option() throws Throwable {
		 WebDriverWait wait=new WebDriverWait(driver, 300);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Manage Stacks")));
	    driver.findElement(By.partialLinkText("Manage Stacks")).click();
	}

	@Given("^click on overview menu and check page is open$")
	public void click_on_overview_menu_and_check_page_is_open() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[1]/a")).click();
	    Thread.sleep(2000);
		String BodyText=driver.findElement(By.tagName("h2")).getText();
		Thread.sleep(500);
		Assert.assertTrue("Overview page opened!", BodyText.contains("Welcome to the Cloud User Portal"));
	   
	    
	}

	@Given("^click on catalog menu and check page is open$")
	public void click_on_catalog_menu_and_check_page_is_open() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"x84e766440b472200eff7ef9bb4673ad7\"]/div/a")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[2]/a")).click();
	    Thread.sleep(2000);
	    WebDriverWait wait=new WebDriverWait(driver, 300);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/section/main/div/div/sp-page-row/div/div[1]")));
		String BodyText=driver.findElement(By.xpath("/html/body/div/section/main/div/div/sp-page-row/div/div[1]")).getText();
		Thread.sleep(3000);
		try {
			Assert.assertTrue("Catalog page opened!", BodyText.contains("Service Categories"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("^click on Stacks menu and check page is open$")
	public void click_on_Stacks_menu_and_check_page_is_open() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[3]/a")).click();
	    Thread.sleep(2000);
		String BodyText=driver.findElement(By.xpath("//*[@id=\"xf66309b50be32200eff7ef9bb4673aaf\"]")).getText();
		Thread.sleep(500);
		try {
			Assert.assertTrue("Stacks page opened!", BodyText.contains("Catalog Items"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("^click on Resources menu and check page is open$")
	public void click_on_Resources_menu_and_check_page_is_open() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[4]/a")).click();
	    Thread.sleep(2000);
		String BodyText=driver.findElement(By.xpath("//*[@id=\"xb8f1d0fd0bf22200eff7ef9bb4673a2e\"]")).getText();
		Thread.sleep(500);
		try {
			Assert.assertTrue("Resources page opened!", BodyText.contains("Resources"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("^click on Activities menu and check page is open$")
	public void click_on_Activities_menu_and_check_page_is_open() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[5]/a")).click();
	    Thread.sleep(2000);
		String BodyText=driver.findElement(By.xpath("//*[@id=\"x32cae7ea0b432200eff7ef9bb4673a18\"]")).getText();
		Thread.sleep(500);
		try {
			Assert.assertTrue("Activities page opened!", BodyText.contains("Activities"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("^click on Dashbaord menu and check page is open$")
	public void click_on_Dashbaord_menu_and_check_page_is_open() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[6]/a")).click();
	    Thread.sleep(2000);
		
		try {
			Assert.assertTrue("Dashboard page opened!", driver.findElement(By.id("dashboard")).isDisplayed());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Given("^Make sure all catalog modules there and print all catalog list$")
	public void make_sure_all_catalog_modules_there_and_print_all_catalog_list() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[2]/a")).click();
		Thread.sleep(2000);
	    WebElement CatalogPage= driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/sp-page-row/div/div[2]"));
	    List <WebElement> CatItems= CatalogPage.findElements(By.cssSelector("div[class=\"panel panel-default b\"]"));
	    System.out.println("Available Catalog List");
	    System.out.println("----------------------------------------");
	    for (int i=0; i<=CatItems.size()-1; i++)
	    {
	    	
	    	System.out.println(CatItems.get(i).findElement(By.tagName("h4")).getText());
	    }
	}

	@Given("^Go to catalog page and evaluate all available catalog options$")
	public void go_to_catalog_page_and_evaluate_all_available_catalog_options() throws Throwable {
		   
	    WebElement CatalogPage= driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/sp-page-row/div/div[2]"));
	    List <WebElement> CatItems= CatalogPage.findElements(By.cssSelector("div[class=\"panel panel-default b\"]"));
	    
	    String CatTitle="";
	    String OpenedTitle="";
	    WebDriverWait wait=new WebDriverWait(driver, 300);
	    for (int i=0; i<=CatItems.size()-1; i++)
	    {
	    	try {
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"x3b166f970fac2f04e7fef77ce1050ed9\"]/div/div/div/span")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"x73f60b7437d3db80b8280ba754990e82\"]/div/div/div[2]/div[1]/div/a/div/h4")));
				CatalogPage= driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/sp-page-row/div/div[2]"));
				CatItems= CatalogPage.findElements(By.cssSelector("div[class=\"panel panel-default b\"]"));
				CatTitle=CatItems.get(i).findElement(By.tagName("h4")).getText();
				CatItems.get(i).findElement(By.tagName("h4")).click();
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"xc7612a3a0bd32200eff7ef9bb4673a46\"]/div/div/div[1]/h1")));
				OpenedTitle=driver.findElement(By.xpath("//*[@id=\"xc7612a3a0bd32200eff7ef9bb4673a46\"]/div/div/div[1]/h1")).getText();
				
				Assert.assertTrue(CatTitle+" opened!", OpenedTitle.contains(CatTitle));
				System.out.println(CatTitle+" opened!");
				
				driver.navigate().back();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}

	
	@Given("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	}

	@Given("^Print test finished$")
	public void print_test_finished() throws Throwable {
	    System.out.println("Test Execution finished");
	}






}
