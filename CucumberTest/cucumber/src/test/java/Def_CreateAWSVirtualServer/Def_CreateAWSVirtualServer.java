package Def_CreateAWSVirtualServer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Def_CreateAWSVirtualServer {
	
	WebDriver driver;
	
	@Given("^Login and click on catalog menu$")
	public void login_and_click_on_catalog_menu() throws Throwable {
		driver=Utils.CommonScripts.DoLogin();
		PageObjects.LandingPage.lbl_ManageStacks(driver).click();
		Thread.sleep(2000);
	    PageObjects.ManageStacksPage.menu_catalog(driver).click();
	    Thread.sleep(2000);
	}

	@Given("^Open virtual server$")
	public void open_virtual_server() throws Throwable {
	    PageObjects.CatalogPage.link_createvirtualserver(driver).click();	    
	}

	@Given("^fill virtual server form and click submit button$")
	public void fill_virtual_server_form_and_click_submit_button() throws Throwable {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		wait.until(ExpectedConditions.elementToBeClickable(PageObjects.CreateVirtualServerPage.cmb_LogicalDatacenterDropDown(driver)));
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectDataCenter(driver, "AWS");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectEnvironment(driver, "ATOS");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectRegion(driver, "AWS");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.txt_StackName(driver).sendKeys("virtualservertest-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectUserGroup(driver, "ATF2 CMP Root Admin");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectManagedOS(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectNeverExpire(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.txt_BusinessPurpose(driver).sendKeys("virtualservertest-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectApplication(driver, "RDSM178");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();",PageObjects.CreateVirtualServerPage.btn_ProvisionTab(driver));		
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectComputeProfile(driver, "Small");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectImage(driver, "Linux");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectVirtualNetwork(driver, "Tower");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectSubnet(driver, "Private");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectSecurityGroup(driver, "EPO");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectSSHKeyName(driver, "cmp");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		js.executeScript("arguments[0].click();",PageObjects.CreateVirtualServerPage.btn_AdditionalVMDetailsTab(driver));	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectAdditionalTagging(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectMaintenanceOptions(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.btn_AddTags(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.txt_Key(driver).sendKeys("key-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.txt_Value(driver).sendKeys("value-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectBackup(driver, "Cloud");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectBackupPolicy(driver, "Reboot");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.txt_cloudID(driver).sendKeys("cloudid-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectBDisasterRecovery(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.btn_Submit(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		
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
