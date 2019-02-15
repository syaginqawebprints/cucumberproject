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

public class Def_CheckMenuItems {
	
	WebDriver driver;

	@Given("^user loges into page$")
	public void user_loges_into_page() throws Throwable {
		driver=Utils.CommonScripts.DoLogin();
	}

	@Given("^click on manage stock option$")
	public void click_on_manage_stock_option() throws Throwable {
		 WebDriverWait wait=new WebDriverWait(driver, 300);
		 wait.until(ExpectedConditions.visibilityOf(PageObjects.LandingPage.lbl_ManageStacks(driver)));
		 PageObjects.LandingPage.lbl_ManageStacks(driver).click();
	}

	@Given("^click on overview menu and check page is open$")
	public void click_on_overview_menu_and_check_page_is_open() throws Throwable {
		PageObjects.ManageStacksPage.menu_Overview(driver).click();
	    Thread.sleep(2000);
		String BodyText=PageObjects.LandingPage.tag_header(driver).getText();
		Thread.sleep(500);
		try {
			if(BodyText.contains("Welcome to the Cloud User Portal"))
			{
				System.out.println("Case 1 [Check Overview Page Opened] : Paged Opened");
			}
			else
			{
				System.out.println("Case 1 [Check Overview Page Opened] : Paged Not Opened");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
			System.out.println("Case 1 [Check Overview Page Opened] : Paged Not Opened");
	}
		   
	    
	}

	@Given("^click on catalog menu and check page is open$")
	public void click_on_catalog_menu_and_check_page_is_open() throws Throwable {
		PageObjects.LandingPage.lbl_ManageStacks(driver).click();
		Thread.sleep(2000);
		PageObjects.ManageStacksPage.menu_catalog(driver).click();
	    Thread.sleep(2000);
	    WebDriverWait wait=new WebDriverWait(driver, 300);
	    wait.until(ExpectedConditions.visibilityOf(PageObjects.CatalogPage.lbl_pagetitle(driver)));
		String BodyText=PageObjects.CatalogPage.lbl_pagetitle(driver).getText();
		Thread.sleep(3000);
		
		try {
			if(BodyText.contains("Service Categories"))
			{
				System.out.println("Case 2 [Check Catlog Page Opened] : Paged Opened");
			}
			else
			{
				System.out.println("Case 2 [Check Catlog Page Opened] : Paged Not Opened");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
			System.out.println("Case 2 [Check Catlog Page Opened] : Paged Not Opened");
	}
		
	}

	@Given("^click on Stacks menu and check page is open$")
	public void click_on_Stacks_menu_and_check_page_is_open() throws Throwable {
		
	    PageObjects.ManageStacksPage.menu_Stacks(driver).click();
	    Thread.sleep(2000);
		String BodyText=PageObjects.StacksPage.lbl_pagetitle(driver).getText();
		Thread.sleep(500);
		
		try {
			if(BodyText.contains("Catalog Items"))
			{
				System.out.println("Case 3 [Check Stacks Page Opened] : Paged Opened");
			}
			else
			{
				System.out.println("Case 3 [Check Stacks Page Opened] : Paged Not Opened");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
			System.out.println("Case 3 [Check Stacks Page Opened] : Paged Not Opened");
	}
		
	}

	@Given("^click on Resources menu and check page is open$")
	public void click_on_Resources_menu_and_check_page_is_open() throws Throwable {
	    PageObjects.ManageStacksPage.menu_resources(driver).click();
	    Thread.sleep(2000);
		String BodyText=PageObjects.ResourcesPage.lbl_pagetitle(driver).getText();
		Thread.sleep(500);
		
		try {
			if(BodyText.contains("Resources"))
			{
				System.out.println("Case 4 [Check Resources Page Opened] : Paged Opened");
			}
			else
			{
				System.out.println("Case 4 [Check Resources Page Opened] : Paged Not Opened");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
			System.out.println("Case 4 [Check Resources Page Opened] : Paged Not Opened");
	}

	}

	@Given("^click on Activities menu and check page is open$")
	public void click_on_Activities_menu_and_check_page_is_open() throws Throwable {
	    PageObjects.ManageStacksPage.menu_activities(driver).click();
	    Thread.sleep(2000);
		String BodyText=PageObjects.ActivitiesPage.lbl_pagetitle(driver).getText();
		Thread.sleep(500);
		
		try {
			if(BodyText.contains("Activities"))
			{
				System.out.println("Case 5 [Check Activities Page Opened] : Paged Opened");
			}
			else
			{
				System.out.println("Case 5 [Check Activities Page Opened] : Paged Not Opened");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
			System.out.println("Case 5 [Check Activities Page Opened] : Paged Not Opened");
	}

	}

	@Given("^click on Dashbaord menu and check page is open$")
	public void click_on_Dashbaord_menu_and_check_page_is_open() throws Throwable {
	    PageObjects.ManageStacksPage.menu_dashboard(driver).click();
	    Thread.sleep(2000);
	    
		try {
			if(PageObjects.DashboardPage.ifram_dashboard(driver).isDisplayed())
			{
				System.out.println("Case 6 [Check Dashboard Page Opened] : Paged Opened");
			}
			else
			{
				System.out.println("Case 6 [Check Dashboard Page Opened] : Paged Not Opened");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
			System.out.println("Case 6 [Check Dashboard Page Opened] : Paged Not Opened");
	}    
		

	}

	@Given("^Make sure all catalog modules there and print all catalog list$")
	public void make_sure_all_catalog_modules_there_and_print_all_catalog_list() throws Throwable {
		PageObjects.ManageStacksPage.menu_catalog(driver).click();
		Thread.sleep(2000);
	    WebElement CatalogPage= PageObjects.CatalogPage.div_catlogitems(driver);
	    List <WebElement> CatItems= CatalogPage.findElements(By.cssSelector("div[class=\"panel panel-default b\"]"));
	    System.out.println("Available Catalog List");
	    System.out.println("----------------------------------------");
	    for (int i=0; i<=CatItems.size()-1; i++)
	    {
	    	
	    	System.out.println(CatItems.get(i).findElement(By.tagName("h4")).getText());
	    }
	    
	    System.out.println("Case 7 [Print All Catalog options] : All Options Printed");
	}

	@Given("^Go to catalog page and evaluate all available catalog options$")
	public void go_to_catalog_page_and_evaluate_all_available_catalog_options() throws Throwable {
		
		WebDriverWait wait=new WebDriverWait(driver, 300);
		PageObjects.ManageStacksPage.menu_catalog(driver).click();
		
		//wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));  
		Thread.sleep(2000);
	    WebElement CatalogPage= driver.findElement(By.xpath("//*[@id=\"x4c6cbea60b212200eff7ef9bb4673a29\"]"));
	    List <WebElement> CatItems= CatalogPage.findElements(By.cssSelector("div[class=\"panel panel-default b\"]"));
	    String CatTitle="";
	    String OpenedTitle="";
	    int j=0;
	    for (int i=0; i<=CatItems.size()-1; i++)
	    {
	    	j++;
	   
	    	try {
	    		Thread.sleep(5000);
	    		//wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
				CatalogPage= driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/sp-page-row/div/div[2]"));
				CatItems= CatalogPage.findElements(By.cssSelector("div[class=\"panel panel-default b\"]"));
				CatTitle=CatItems.get(i).findElement(By.tagName("h4")).getText();
				CatItems.get(i).findElement(By.tagName("h4")).click();
				wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
				//Thread.sleep(5000);
				//
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"xc7612a3a0bd32200eff7ef9bb4673a46\"]/div/div/div[1]/h1")));
				OpenedTitle=driver.findElement(By.xpath("//*[@id=\"xc7612a3a0bd32200eff7ef9bb4673a46\"]/div/div/div[1]/h1")).getText();
				
				Assert.assertTrue(CatTitle+" opened!", OpenedTitle.contains(CatTitle));
				System.out.println(j+". "+CatTitle+" opened!");
				
				driver.navigate().back();
				wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
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
