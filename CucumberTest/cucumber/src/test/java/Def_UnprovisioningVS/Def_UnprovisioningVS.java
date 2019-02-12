
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
		ArrayList<String> NewServerList =  new ArrayList<String>();
		ServerList=Utils.CommonScripts.GetServerList();
		Thread.sleep(3000);
		if (ServerList.size()<=0)
		{
			
			//System.out.print("No Virtual Server Found for Deletion");
    		DeleteStatus=0;
		}
		else
		{
        for (int i=0;i<=ServerList.size()-1;i++)
        {
        	
        	try {
				Thread.sleep(3000);
				String DelServer=ServerList.get(i);
				String DelCheck []=DelServer.split(";");
				String DeleteServer= DelCheck [0];
				if (DelCheck [1].contains("d") || DelCheck [1].contains("D"))
				{        	
				if (DeleteServer.equals(""))
				{
					//System.out.print("No Virtual Server Found for Deletion");
					DeleteStatus=0;
				}
				else
				{
					PageObjects.StacksPage.txt_search(driver).sendKeys(DeleteServer);
					PageObjects.StacksPage.btn_search(driver).click();
					Thread.sleep(5000);
					String SearchResult=PageObjects.StacksPage.Div_SearchResultArea(driver).getText();
					if (SearchResult.contains("No Results"))
					{
						DeleteStatus=1;
					}
					else
					{
						Thread.sleep(5000);
						PageObjects.StacksPage.div_searchrsults(driver).findElement(By.partialLinkText(DeleteServer)).click();
						Thread.sleep(5000);
						WebDriverWait wait=new WebDriverWait(driver, 300);
						if (driver.findElement(By.xpath("//*[@id=\"x4a6a1c9a373fd748b8280ba754990e27\"]/div")).getText().contains("Terminated"))
						{
							DeleteStatus=2;
						}
						else if(driver.findElement(By.xpath("//*[@id=\"x4a6a1c9a373fd748b8280ba754990e27\"]/div")).getText().contains("Resolving Error"))
						{
							Thread.sleep(3000);
							PageObjects.StacksPage.btn_deleteserver(driver).click();
							Thread.sleep(3000);
							DeleteStatus=3;
						}
						else
						{
							Thread.sleep(3000);
							PageObjects.StacksPage.cmb_DeprovisionAction(driver).click();
							driver.findElement(By.xpath("//*[@id=\"x4a6a1c9a373fd748b8280ba754990e27\"]/div/div[2]/div/select/option[2]")).click();
							Thread.sleep(2000);
							wait.until(ExpectedConditions.elementToBeClickable(PageObjects.StacksPage.btn_DeprovisionOK(driver)));
							Thread.sleep(2000);
							PageObjects.StacksPage.btn_DeprovisionOK(driver).click();
							
							
							

							try {
								wait=new WebDriverWait(driver, 300);
								Thread.sleep(3000);
								wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"status\"]/div/div[1]/div/div/div[2]")), "Request Completed"));
								GetStackStatusMessage();
								String RequestStatusMessage=driver.findElement(By.xpath("//*[@id=\"status\"]/div/div[1]/div/div/div[2]")).getText();
								String StackStatusMessage=driver.findElement(By.xpath("//*[@id=\"status\"]/div/div[2]/div/div/div[2]")).getText();
								if(RequestStatusMessage.contains("Failed") || StackStatusMessage.contains("Error"))
								{
									System.out.println("Operation failed");
									System.out.println(StackStatusMessage);
								}
								else if (RequestStatusMessage.contains("Completed")  && StackStatusMessage.contains("Completed"))
								{
									DeleteStatus=3;
								}
								else
								{
									
									System.out.println(StackStatusMessage);
									DeleteStatus=4;
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}				
				if (DeleteStatus==3)
				{
					ServerList.remove(i);
				}
				
				}

			}
				 
				
      }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
        	
        	
        }
        	if (DeleteStatus==3)
        	{
        	for (int j=0;j<=ServerList.size();j++)
        	{
        		String AddServer=ServerList.get(j);
        		String AddCheck []=AddServer.split(";");
        		NewServerList.add( AddCheck [0]);
        	}
	
        	Utils.CommonScripts.WriteServerList(NewServerList);
        	}
		}
			
		
	}

	@Given("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    driver.quit();
	}

	@Given("^Print test finished$")
	public void print_test_finished() throws Throwable {
		if (DeleteStatus==0)
		{
	    System.out.println("No Virtual Servers found for deletion in the Excel");
		}
		else if (DeleteStatus==1)
		{
		    System.out.println("No Virtual Server listed in the Search");
			}
		
		else if (DeleteStatus==2)
		{
		    System.out.println("Virtual Server already Terminated");
			}
		else if (DeleteStatus==3)
		{
			System.out.println("Virtual server Deleted Successfully");
		}
		else
		{
		    System.out.println("Some Eorror occured");
			}
	}

public String GetStackStatusMessage() throws InterruptedException {
		
		Thread.sleep(5000);
		String RequestStatusMessage=PageObjects.ActivitiesPage.lbl_requestmessages(driver).getText();
		String StackStatusMessage="";
		if (RequestStatusMessage.contains ("Request Completed"))
		{
			Thread.sleep(5000);
			StackStatusMessage=driver.findElement(By.xpath("//*[@id=\"status\"]/div/div[2]/div/div/div[2]")).getText();
			
		}
		else
		{
			Thread.sleep(5000);
			GetStackStatusMessage();
		}
		 
		return StackStatusMessage;
		
	}


}
