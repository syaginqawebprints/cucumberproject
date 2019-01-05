package Def_Createsnapshot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Def_Createsnapshot {
	WebDriver driver;
	
	@Given("^Login and click on catalog menu$")
	public void login_and_click_on_catalog_menu() throws Throwable {
		driver=Utils.CommonScripts.DoLogin();
		PageObjects.LandingPage.lbl_ManageStacks(driver).click();
		Thread.sleep(2000);
	    PageObjects.ManageStacksPage.menu_catalog(driver).click();
	    Thread.sleep(2000);
	}

	@Given("^Open snapshot$")
	public void open_snapshot() throws Throwable {
		PageObjects.CatalogPage.link_snapshot(driver).click();
	}

	@Given("^fill snapshot form and click submit button$")
	public void fill_snapshot_form_and_click_submit_button() throws Throwable {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjects.SnapshotPage.cmb_CloudAccount(driver)));
			   wait.until(ExpectedConditions.elementToBeClickable(PageObjects.SnapshotPage.txt_StackName(driver)));
			   wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			   JavascriptExecutor js = (JavascriptExecutor) driver; 
			   js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.cmb_CloudAccount(driver));
			   wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			   PageObjects.SnapshotPage.txt_StackName(driver).sendKeys("snapshottest-"+Utils.CommonScripts.GetDateTime());
			   js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.cmb_Location(driver));
			   wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			   js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.cmb_UserGroup(driver));
			   wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			   js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.btn_provision(driver));
			   wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			   js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.cmb_volumeid(driver));
			   wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			   PageObjects.SnapshotPage.txt_description(driver).sendKeys("snapshot-description");
			   js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.btn_submit(driver));
			   wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	@Given("^Check Status and print message$")
	public void check_Status_and_print_message() throws Throwable {
		try {
			WebDriverWait wait=new WebDriverWait(driver, 300);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.LandingPage.div_HeadLoader(driver)));
			wait.until(ExpectedConditions.textToBePresentInElement(PageObjects.ActivitiesPage.lbl_requestmessages(driver), "View stack details"));
			String RequestStatusMessage=PageObjects.ActivitiesPage.lbl_requestmessage(driver).getText();
			String StackStatusMessage=PageObjects.ActivitiesPage.lbl_stackmessage(driver).getText();
			if (RequestStatusMessage.contains("Failed"))
			{
				System.out.println("Operation failed");
				System.out.println(RequestStatusMessage);
			}
			else if (RequestStatusMessage.contains("Success"))
			{
				System.out.println("Operation Success");
				System.out.println(RequestStatusMessage);
			}
			
			System.out.println(RequestStatusMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//e.printStackTrace();
		}
	}

	@Given("^close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	}

	@Given("^Print test finished$")
	public void print_test_finished() throws Throwable {
	    System.out.println("Test Completed");
	}



}
