
package Def_Createsnapshot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Def_Createsnapshot {
	WebDriver driver;
	String snapshottext;
	
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
			//PageObjects.SnapshotPage.SelectLogicalDataCenter(driver, "AWS");
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			//PageObjects.SnapshotPage.SelectCloudAccount(driver, "ATOS");
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			//PageObjects.SnapshotPage.SelectLocation(driver, "AWS");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			snapshottext="snapshot-"+Utils.CommonScripts.GetDateTime();
			PageObjects.SnapshotPage.txt_StackName(driver).sendKeys(snapshottext);
			Thread.sleep(2000);
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.btn_provision(driver));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			Thread.sleep(2000);
			PageObjects.SnapshotPage.SelectVolumeId(driver, "vol");
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", PageObjects.SnapshotPage.btn_submit(driver));
			Thread.sleep(2000);
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
			//wait.until(ExpectedConditions.textToBePresentInElement(PageObjects.ActivitiesPage.lbl_stackmessage(driver), "response"));
			wait.until(ExpectedConditions.textToBePresentInElement(PageObjects.ActivitiesPage.lbl_requestmessages(driver), "Deploying Stack"));
			GetStackStatusMessage();
			String RequestStatusMessage=PageObjects.ActivitiesPage.lbl_requestmessage(driver).getText();
			String StackStatusMessage=PageObjects.ActivitiesPage.lbl_stackmessage(driver).getText();
			
			
			if (RequestStatusMessage.contains("Failed") || StackStatusMessage.contains("Error"))
			{
				System.out.println("Operation failed");
				System.out.println(StackStatusMessage);
				
			}
			else if (RequestStatusMessage.contains("Deployment Successful")  && StackStatusMessage.contains("Completed"))
			{
				System.out.println(snapshottext +" Created ");
				
			}
			else
			{
				System.out.println("Operation failed");
				System.out.println(StackStatusMessage);
			}
			
			
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
	   // System.out.println("Test Completed");
	}


	public String GetStackStatusMessage() throws InterruptedException {
		
		Thread.sleep(5000);
		String RequestStatusMessage=PageObjects.ActivitiesPage.lbl_requestmessages(driver).getText();
		String StackStatusMessage="";
		if (RequestStatusMessage.contains("Deploying Stack") && !RequestStatusMessage.contains("View"))
		{
			Thread.sleep(5000);
			GetStackStatusMessage();
		}
		else
		{
			Thread.sleep(5000);
			StackStatusMessage=PageObjects.ActivitiesPage.lbl_stackmessage(driver).getText();
		}
		 
		return StackStatusMessage;
		
	}
	
}

