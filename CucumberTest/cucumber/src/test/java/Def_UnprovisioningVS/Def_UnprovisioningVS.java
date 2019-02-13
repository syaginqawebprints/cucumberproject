
package Def_UnprovisioningVS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		String[][] ServerList;
		String ServerName="";
		ServerList=Utils.CommonScripts.GetServerList();
		int totalrows=ServerList.length;
		Thread.sleep(3000);
		if (totalrows<=0)
		{
			
			DeleteStatus=0;
		}
		else 
		{
			int DelRow=0;
			for (int i=0;i<=totalrows-1;i++)
			{
				
				if (ServerList[i][1].contains("d") || ServerList[i][1].contains("D"))
						{
							String DeleteServer=ServerList[i][0];
							if (ServerList[i][0].equals(""))
								{
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
										driver.navigate().refresh();
										Thread.sleep(3000);										
										PageObjects.StacksPage.cmb_DeprovisionAction(driver).click();
										driver.findElement(By.xpath("//*[@id=\"x4a6a1c9a373fd748b8280ba754990e27\"]/div/div[2]/div/select/option[2]")).click();
										Thread.sleep(5000);										
										wait.until(ExpectedConditions.elementToBeClickable(PageObjects.StacksPage.btn_DeprovisionOK(driver)));
										//JavascriptExecutor js = (JavascriptExecutor) driver; 
										//js.executeScript("arguments[0].click();",PageObjects.StacksPage.btn_DeprovisionOK(driver));
										Thread.sleep(3000);
										PageObjects.StacksPage.btn_DeprovisionOK(driver).click();

										try {
											wait=new WebDriverWait(driver, 300);
											Thread.sleep(10000);
											GetStackStatusMessage();
											String RequestStatusMessage=driver.findElement(By.xpath("//*[@id=\"status\"]/div/div[1]/div/div/div[2]")).getText();
											String StackStatusMessage=driver.findElement(By.xpath("//*[@id=\"status\"]/div/div[2]/div/div/div[2]")).getText();
											if(RequestStatusMessage.contains("Failed") || StackStatusMessage.contains("Error"))
											{
												System.out.println("Operation failed");
												System.out.println(StackStatusMessage);
											}
											else if (RequestStatusMessage.contains("Completed") && StackStatusMessage.contains("Completed"))
											{
												//Utils.CommonScripts.RemoveRow(i);
												String filePath = Utils.CommonScripts.readProperty("virtual.server.dbpath");
												FileInputStream fis = null;
												
												 
												    fis = new FileInputStream(filePath);
												    XSSFWorkbook wb = new XSSFWorkbook(fis);
												    XSSFSheet sheet = wb.getSheetAt(0);
												    Row DelRows=sheet.getRow(i);												    
												    sheet.removeRow(DelRows);
												    File outWB = new File(filePath);
												    OutputStream out = new FileOutputStream(outWB);
												    wb.write(out);
												    out.flush();
												    out.close();
												    System.out.println(DeleteServer);
												DeleteStatus=4;						
											}
											else
											{
												
												System.out.println(StackStatusMessage);
												DeleteStatus=5;
											}
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}
								}
							}
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
			System.out.println("Virtual Server Resolving error state");
		}
		else if (DeleteStatus==4)
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
