package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateVirtualServerPage {
	
	private static WebElement element = null;
	private static JavascriptExecutor js = null; 
	//Logical Data center Drop-down
	public static WebElement cmb_LogicalDatacenterDropDown(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-1\"]"));
		return element;
	}

	//Select Data Center
	public static void  SelectDataCenter(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		PageObjects.CreateVirtualServerPage.cmb_LogicalDatacenterDropDown(driver).click();
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
	
	//Environment  Drop-down
	public static WebElement cmb_Environment(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-6\"]"));
		return element;
	}
	
	//Select Environment
	public static void  SelectEnvironment(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_Environment(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(1000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-6\"]"));
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
	
	//Region Drop Down
	public static WebElement cmb_Region(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-2\"]"));
		return element;
	}
	
	//Select Region
	public static void  SelectRegion(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_Region(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(1000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]"));
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
	
	//User Group Drop Down
	public static WebElement cmb_UserGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-3\"]"));
		return element;
	}
	
	//Select User Group
	public static void  SelectUserGroup(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_UserGroup(driver).click();
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
	
	//Managed OS Drop Down
	public static WebElement cmb_ManagedOS(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-7\"]"));
		return element;
	}
	
	//Select Managed OS
	public static void  SelectManagedOS(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_ManagedOS(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(1000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-7\"]"));
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
	
	//Never Expire Drop Down
	public static WebElement cmb_NeverExpire(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-4\"]"));
		return element;
	}
	
	//Select Never Expire
	public static void  SelectNeverExpire(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_NeverExpire(driver).click();
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

	
	//Business Purpose Text Box
	public static WebElement txt_BusinessPurpose(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sp_formfield_BusinessPurpose\"]"));
		return element;
	}
	
	//Application Drop Down
	public static WebElement cmb_Application(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_Application\"]/a"));
		return element;
	}
	
	//Select Application
	public static void  SelectApplication(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_Application(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-30\"]"));
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
	
	//Provision Tab button
	public static WebElement btn_ProvisionTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"section-1\"]"));
		return element;
	}
	
	//Compute Profile Drop Down
	public static WebElement cmb_ComputeProfile(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-8\"]"));
		return element;
	}
	

	//Select Compute Profile
	public static void  SelectComputeProfile(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_ComputeProfile(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-8\"]"));
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
	

	//Image Drop Down
	public static WebElement cmb_Image(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-13\"]"));
		return element;
	}
	
	//Select Image
	public static void  SelectImage(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.cmb_Image(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-13\"]"));
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
	
	//Virtual Network Drop Down
	public static WebElement cmb_VirtualNetwork(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-9\"]"));
		return element;
	}
	
	//Select Virtual Network
	public static void  SelectVirtualNetwork(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(3000);	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.cmb_VirtualNetwork(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-9\"]"));
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
	
	//Subnet Drop Down
	public static WebElement cmb_Subnet(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-14\"]"));
		return element;
	}
	
	//Select Subnet
	public static void  SelectSubnet(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(3000);	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.cmb_Subnet(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-14\"]"));
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
	
	//Security Group Text box
	public static WebElement txt_SecurityGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_Virtual_Server_SecurityGroupArray\"]"));
		return element;
	}
	
	//Select Security Group
	public static void  SelectSecurityGroup(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.txt_SecurityGroup(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"s2id_autogen31_results\"]"));
		List<WebElement> list = DropValues.findElements(By.tagName("li"));	 
	       for (WebElement opt : list) {	
	          if (opt.getAttribute("innerHTML").contains(ServerTxt)) {	 
	        	  opt.click();
	             break;	 
	          }	 
	       }
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	       Thread.sleep(2000);	
	       wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
	}
	
	//SSH Key Name Drop Down
	public static WebElement cmb_SSHKeyName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-15\"]"));
		return element;
	}
	
	//Select SSH Key Name
	public static void  SelectSSHKeyName(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(3000);	
		PageObjects.CreateVirtualServerPage.cmb_SSHKeyName(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-15\"]"));
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
	
	
	//Additional VM Details Tab button
	public static WebElement btn_AdditionalVMDetailsTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"section-2\"]"));
		return element;
	}
	
	 
	//Auto Recovery Drop Down
	public static WebElement cmb_AutoRecovery(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"s2id_sp_formfield_{{::field.name}}\"]/a"));
		return element;
	}
	
		
	//Additional Tagging Drop Down
	public static WebElement cmb_AdditionalTagging(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-28\"]"));
		return element;
	}
	
	//Select Additional Tagging
	public static void  SelectAdditionalTagging(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_AdditionalTagging(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-28\"]"));
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
	
	//Maintenance Options Drop Down
	public static WebElement cmb_MaintenanceOptions(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-22\"]"));
		return element;
	}
	
	//Select Maintenance Options
	public static void  SelectMaintenanceOptions(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(3000);	
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		PageObjects.CreateVirtualServerPage.cmb_MaintenanceOptions(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-22\"]"));
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
	
	//Add Tags button
	public static WebElement btn_AddTags(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"addRow\"]"));
		return element;
	}
	
	//Key text box
	public static WebElement txt_Key(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"Virtual_Server_TagsCMPGrid\"]/table/tbody/tr/td[1]/div/input"));
		return element;
	}
		
	//Value text box
	public static WebElement txt_Value(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"Virtual_Server_TagsCMPGrid\"]/table/tbody/tr/td[2]/div/input"));
		return element;
	}
	
	//Remove Tag button
	public static WebElement btn_RemoveTag(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"Virtual_Server_TagsCMPGrid\"]/table/tbody/tr/td[3]/i"));
		return element;
	}
	
	//Backup Drop Down
	public static WebElement cmb_Backup(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-23\"]"));
		return element;
	}
	
	//Select Backup
	public static void  SelectBackup(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_Backup(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-23\"]"));
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
	
	//Backup Policy Drop Down
	public static WebElement cmb_BackupPolicy(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-24\"]"));
		return element;
	}
	
	//Select Backup Policy
	public static void  SelectBackupPolicy(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_BackupPolicy(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-24\"]"));
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
	
	
	//Cloud ID Text Box
	public static WebElement txt_cloudID(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sp_formfield_Virtual_Server_CloudID\"]"));
		return element;
	}
	
	//Disaster Recovery Drop Down
	public static WebElement cmb_DisasterRecovery(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-25\"]"));
		return element;
	}
	
	//Select Disaster Recovery
	public static void  SelectBDisasterRecovery(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_DisasterRecovery(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-25\"]"));
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
	
	//DR Region Drop Down
	public static WebElement cmb_DRRegion(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-chosen-26\"]"));
		return element;
	}
	
	//Select DR Region
	public static void  SelectDRRegion(WebDriver driver, String ServerTxt) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		PageObjects.CreateVirtualServerPage.cmb_DRRegion(driver).click();
		wait.until(ExpectedConditions.invisibilityOf(PageObjects.BucketResourcePage.div_loading(driver)));
		Thread.sleep(2000);	
		WebElement DropValues=driver.findElement(By.xpath("//*[@id=\"select2-results-26\"]"));
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
	
	
	//Submit Button
	public static WebElement btn_Submit(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"catItemSubmit\"]"));
		return element;
	}
}
