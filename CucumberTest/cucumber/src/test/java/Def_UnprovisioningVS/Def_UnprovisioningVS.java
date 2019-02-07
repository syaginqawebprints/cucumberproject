
package Def_UnprovisioningVS;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import jxl.write.Label;

public class Def_UnprovisioningVS {
	WebDriver driver;
	int DeleteStatus=0;
	@Given("^Open and Login to Application$")
	public void open_and_Login_to_Application() throws Throwable {
		driver=Utils.CommonScripts.DoLogin();
		Thread.sleep(2000);
	    
	}

	@Given("^Open Stack page$")
	public void open_Stack_page() throws Throwable {
		PageObjects.LandingPage.lbl_ManageStacks(driver).click();
	    Thread.sleep(2000);
	}

	@Given("^Search Virtual Server for Delete$")
	public void search_Virtual_Server_for_Delete() throws Throwable {
		//Here we are searching Virtual Servers with part of text
		
	    Thread.sleep(2000);
	}

	@Given("^Delete Virtual Server$")
	public void delete_Virtual_Server() throws Throwable {
		Thread.sleep(3000);
		ArrayList<String> ServerList =  new ArrayList<String>();
		ServerList=Utils.CommonScripts.GetServerList();
		Thread.sleep(3000);
		if (ServerList.size()<=0)
		{
			
			//System.out.print("No Virtual Server Found for Deletion");
    		DeleteStatus=2;
		}
		else
		{
        for (int i=0;i<=ServerList.size()-1;i++)
        {
        	
        	Thread.sleep(3000);
        	String DelServer=ServerList.get(i);
        	
        	if (DelServer.equals(""))
        	{
        		//System.out.print("No Virtual Server Found for Deletion");
        		DeleteStatus=0;
        	}
        	else
        	{
        	PageObjects.StacksPage.txt_search(driver).sendKeys(DelServer);
    		PageObjects.StacksPage.btn_search(driver).click();
    		String SearchResult=PageObjects.StacksPage.Div_SearchResultArea(driver).getText();
    		if (SearchResult.contains("No Results"))
    		{
    			DeleteStatus=3;
    		}
    		else
    		{
    		PageObjects.StacksPage.div_searchrsults(driver).findElements(By.partialLinkText(DelServer)).get(1).click();
    		Thread.sleep(3000);
    		WebDriverWait wait=new WebDriverWait(driver, 300);
    		if(!PageObjects.StacksPage.cmb_DeprovisionAction(driver).isDisplayed()){
    			driver.navigate().back();
    			PageObjects.StacksPage.div_searchrsults(driver).findElements(By.partialLinkText(DelServer)).get(1).click();
    			Thread.sleep(3000);
    			PageObjects.StacksPage.cmb_DeprovisionAction(driver).click();
    			driver.findElement(By.xpath("//*[@id=\"x4a6a1c9a373fd748b8280ba754990e27\"]/div/div[2]/div/select/option[2]")).click();
    			
    			}else{
    				Thread.sleep(3000);
    				PageObjects.StacksPage.cmb_DeprovisionAction(driver).click();
    				driver.findElement(By.xpath("//*[@id=\"x4a6a1c9a373fd748b8280ba754990e27\"]/div/div[2]/div/select/option[2]")).click();
    				Thread.sleep(2000);
    			}
    		
    		wait.until(ExpectedConditions.elementToBeClickable(PageObjects.StacksPage.btn_DeprovisionOK(driver)));
    		Thread.sleep(2000);
    		PageObjects.StacksPage.btn_DeprovisionOK(driver).click();
    		
    		ServerList.remove(i);
    		DeleteStatus=1;

        	}
        	Utils.CommonScripts.WriteServerList(ServerList);
    		//System.out.println("Virtual Server Removed ");
        	}	
        }
		}
		
		
		
	}

	@Given("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	}

	@Given("^Print test finished$")
	public void print_test_finished() throws Throwable {
		if (DeleteStatus==1)
		{
	    System.out.println("Virtual Server Deprovision Finished");
		}
		else if (DeleteStatus==2)
		{
		    System.out.println("No Virtual Server Found for Deletion");
			}
		
		else if (DeleteStatus==3)
		{
		    System.out.println("Virtual servers not listed in the search");
			}
		else
		{
		    System.out.println("Some of the Servers ware not deleted");
			}
	}



}
