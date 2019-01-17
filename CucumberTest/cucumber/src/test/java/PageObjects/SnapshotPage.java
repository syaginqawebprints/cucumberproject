package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnapshotPage {
	
	private static WebElement element = null;
	
	//Logical Data Center
	public static WebElement cmb_LogicalDataCenter(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]"));
		return element;
	}
	
	//Select Logical Data Center
		public static void  SelectLogicalDataCenter(WebDriver driver, String ServerTxt) throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver, 300);
			Thread.sleep(2000);	
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			Thread.sleep(2000);
			PageObjects.SnapshotPage.cmb_LogicalDataCenter(driver).click();
			
			wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
			Thread.sleep(1000);		
			WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]"));
			List<WebElement> list = DropValues.findElements(By.tagName("li"));	 
		       for (WebElement opt : list) {	 
		          if (opt.getAttribute("innerHTML").contains(ServerTxt)) {	 
		        	  opt.click(); 	 
		             break;	 
		          }	 
		       }
		       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		       Thread.sleep(1000);	
		       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		}
	
	//Cloud Account Drop down
	public static WebElement cmb_CloudAccount(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-5\"]"));
		return element;
	}
	
	//Select Cloud Account
	public static void  SelectCloudAccount(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		PageObjects.SnapshotPage.cmb_CloudAccount(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(1000);		
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-5\"]"));
		List<WebElement> list = DropValues.findElements(By.tagName("li"));	 
	       for (WebElement opt : list) {	 
	          if (opt.getAttribute("innerHTML").contains(ServerTxt)) {	 
	        	  opt.click(); 	 
	             break;	 
	          }	 
	       }
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	       Thread.sleep(1000);	
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	}
	
	//Location Drop down
	public static WebElement cmb_Location(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-3\"]"));
		return element;
	}
	
	//Select Cloud Account
	public static void  SelectLocation(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		PageObjects.SnapshotPage.cmb_Location(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(1000);		
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-3\"]"));
		List<WebElement> list = DropValues.findElements(By.tagName("li"));	 
	       for (WebElement opt : list) {	 
	          if (opt.getAttribute("innerHTML").contains(ServerTxt)) {	 
	        	  opt.click(); 	 
	             break;	 
	          }	 
	       }
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	       Thread.sleep(1000);	
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	}
	
	//Stack Name Text Box
	public static WebElement txt_StackName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sp_formfield_StackName\"]"));
		return element;
	}
	

	//User Group Drop down
	public static WebElement cmb_UserGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-4\"]"));
		return element;
	}
	
	//Select User Group
	public static void  SelectUserGroup(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		PageObjects.SnapshotPage.cmb_UserGroup(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(1000);		
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-4\"]"));
		List<WebElement> list = DropValues.findElements(By.tagName("li"));	 
	       for (WebElement opt : list) {	 
	          if (opt.getAttribute("innerHTML").contains(ServerTxt)) {	 
	        	  opt.click(); 	 
	             break;	 
	          }	 
	       }
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	       Thread.sleep(1000);	
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	}
	
	//Provision Tab
	public static WebElement btn_provision(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"section-1\"]"));
		return element;
	}
	
	//Volume Id drop down
	public static WebElement cmb_volumeid(WebDriver driver) {
		try {
			if (driver.findElement(By.xpath("//*[@id=\"select2-chosen-7\"]")).isDisplayed())
			{
			element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-7\"]"));
			}
			else
			{
				element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-8\"]"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return element;
	}
	
	//Select Volume Id
	public static void  SelectVolumeId(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		Thread.sleep(3000);	
		PageObjects.SnapshotPage.cmb_volumeid(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(1000);		
		
		WebElement DropValues=null;
		try {
			if (driver.findElement(By.xpath("//*[@id=\"select2-chosen-7\"]")).isDisplayed())
			{
				DropValues = driver.findElement(By.xpath("//*[@id=\"select2-results-7\"]"));
			}
			else
			{
				DropValues = driver.findElement(By.xpath("//*[@id=\"select2-results-8\"]"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		List<WebElement> list = DropValues.findElements(By.tagName("li"));	 
	       for (WebElement opt : list) {	 
	          if (opt.getAttribute("innerHTML").contains(ServerTxt)) {	 
	        	  opt.click(); 	 
	             break;	 
	          }	 
	       }
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	       Thread.sleep(1000);	
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	}
	
	//Description Text box
	public static WebElement txt_description(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sp_formfield_Snapshot_Description\"]"));
		return element;
	}
	
	//Submit button
	public static WebElement btn_submit(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"catItemSubmit\"]"));
		return element;
	}
	
}
