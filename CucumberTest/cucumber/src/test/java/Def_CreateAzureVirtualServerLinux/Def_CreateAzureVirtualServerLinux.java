package Def_CreateAzureVirtualServerLinux;

import java.util.ArrayList;
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

public class Def_CreateAzureVirtualServerLinux {
	
	WebDriver driver;
	String ServerName;
	
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
		PageObjects.CreateVirtualServerPage.SelectDataCenter(driver, "Azure");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectEnvironment(driver, "ATOS");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectRegion(driver, "AWS");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		ServerName="azurelinux-"+Utils.CommonScripts.GetDateTime();
		PageObjects.CreateVirtualServerPage.txt_StackName(driver).sendKeys(ServerName);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectUserGroup(driver, "ATF2 CMP Root Admin");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectManagedOS(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectNeverExpire(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.txt_BusinessPurpose(driver).sendKeys("azurelinux-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectApplication(driver, "RDSM178");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();",PageObjects.CreateVirtualServerPage.btn_ProvisionTab(driver));		
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectComputeProfile(driver, "Small");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectImage(driver, "Linux");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.SelectVirtualNetwork(driver, "gla");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectSubnet(driver, "Private");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectSecurityGroup(driver, "EPO");
		PageObjects.CreateVirtualServerPage.SelectResourceGroup(driver, "gla");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectSSHKeyName(driver, "cmp");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		js.executeScript("arguments[0].click();",PageObjects.CreateVirtualServerPage.btn_AdditionalVMDetailsTab(driver));	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectAdditionalTagging(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectMaintenanceOptions(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.btn_AddTags(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.txt_Key(driver).sendKeys("key-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.txt_Value(driver).sendKeys("value-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectBackup(driver, "EMC");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectBackupPolicy(driver, "SQL");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.txt_cloudID(driver).sendKeys("AZure-"+Utils.CommonScripts.GetDateTime());
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectBDisasterRecovery(driver, "Yes");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		//PageObjects.CreateVirtualServerPage.SelectDRRegion(driver, "AWS");
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",PageObjects.CreateVirtualServerPage.btn_Submit(driver));
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		
	}

	@Given("^Check Status and print message$")
	public void check_Status_and_print_message() throws Throwable {
		
		try {
			WebDriverWait wait=new WebDriverWait(driver, 300);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.textToBePresentInElement(PageObjects.ActivitiesPage.lbl_requestmessages(driver), "Deploying Stack"));
			GetStackStatusMessage();
			String RequestStatusMessage=PageObjects.ActivitiesPage.lbl_requestmessages(driver).getText();
			String StackStatusMessage=PageObjects.ActivitiesPage.lbl_stackmessage(driver).getText();
		
			
			if(RequestStatusMessage.contains("Failed") || StackStatusMessage.contains("Error"))
			{
				System.out.println("Operation failed");
				System.out.println(StackStatusMessage);
			}
			else if (RequestStatusMessage.contains("Deployment Successful")  && StackStatusMessage.contains("Completed"))
			{
				String[][] ServerList;
				ServerList=Utils.CommonScripts.GetServerList();
				int totalrows=ServerList.length;
				Utils.CommonScripts.WriteServerList(ServerName, "",totalrows);
				System.out.println("Azure Linux Virtual Server Created");
				
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
		//System.out.println("Test Completed");
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
