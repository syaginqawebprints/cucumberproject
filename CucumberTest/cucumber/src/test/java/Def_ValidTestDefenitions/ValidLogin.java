package Def_ValidTestDefenitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ValidLogin {
	
	WebDriver driver;
	
@Given("^user open login page$")
	public void user_open_login_page() throws Throwable {
    
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://atoscmpdev.service-now.com/cloud_portal");
}

@When("^enter valid user name and valid password and cick login$")
public void enter_valid_user_name_and_valid_password_and_cick_login() throws Throwable {
    
	driver.findElement(By.id("username")).sendKeys("cmp.atos.admin");
	driver.findElement(By.id("password")).sendKeys("cmp.atos.admin");
	driver.findElement(By.name("login")).click();
	Thread.sleep(2000);
}

@When("^Make sure text appeared: Welcome to the Cloud User Portal$")
public void make_sure_text_appeared_Welcome_to_the_Cloud_User_Portal() throws Throwable {
	String BodyText=driver.findElement(By.tagName("h2")).getText();
	Assert.assertTrue("Text not found!", BodyText.contains("Welcome to the Cloud User Portal"));
   
}

@When("^Check icon apeared$")
public void check_icon_apeared() throws Throwable {
    
	WebElement icon = driver.findElement(By.xpath("/html/body/div/section/header/div/div/nav/div[1]/a[1]/img"));
	Assert.assertEquals(true, icon.isDisplayed());
}

@When("^Check Lanch a stack option appeared$")
public void check_Lanch_a_stack_option_appeared() throws Throwable {
    
	WebElement LaunchStackOption = driver.findElement(By.xpath("//*[@id=\"x9bd766440b472200eff7ef9bb4673acb\"]/div/a"));
	Assert.assertEquals(true, LaunchStackOption.isDisplayed());
}

@When("^Check manage stack option appeared$")
public void check_manage_stack_option_appeared() throws Throwable {
	
	WebElement ManageStackOPtion = driver.findElement(By.xpath("//*[@id=\"x84e766440b472200eff7ef9bb4673ad7\"]/div/a"));
	Assert.assertEquals(true, ManageStackOPtion.isDisplayed());
    
}

@When("^Check view activities option appeared$")
public void check_view_activities_option_appeared() throws Throwable {
	
	WebElement ViewActivitiesOption = driver.findElement(By.xpath("//*[@id=\"x5ee7a6440b472200eff7ef9bb4673a2e\"]/div/a"));
	Assert.assertEquals(true, ViewActivitiesOption.isDisplayed());
    
}

@When("^Check view dashboard option appeared$")
public void check_view_dashboard_option_appeared() throws Throwable {
	WebElement ViewDashBoard = driver.findElement(By.xpath("/html/body/div/section/main/div[1]/div/sp-page-row/div/div/div[2]/sp-page-row/div/div[4]"));
	Assert.assertEquals(true, ViewDashBoard.isDisplayed());
    
}

@When("^Print all option are available$")
public void print_all_option_are_available() throws Throwable {
    
    WebElement HeadSection = driver.findElement(By.xpath("/html/body/div/section/main/div[1]/div/sp-page-row/div/div/div[2]"));
    List <WebElement> Options =HeadSection.findElements(By.tagName("h3"));
    for (int i=0; i<=Options.size()-1; i++)
    {
    	System.out.println(Options.get(i).getText());
    }
    
}

@When("^click on manage stock option validate (\\d+) option menu apeared and available -print text$")
public void click_on_manage_stock_option_validate_option_menu_apeared_and_available_print_text(int arg1) throws Throwable {
    
    driver.findElement(By.xpath("//*[@id=\"x84e766440b472200eff7ef9bb4673ad7\"]/div/a")).click();
    Thread.sleep(2000);
    WebElement MenuBar = driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul"));
    List <WebElement> Options =MenuBar.findElements(By.tagName("li"));
    Assert.assertEquals(true, Options.size()==6);
}

@When("^Click on Catalog validate page catalog is open$")
public void click_on_Catalog_validate_page_catalog_is_open() throws Throwable {
    
    driver.findElement(By.xpath("//*[@id=\"xb726f9960b212200eff7ef9bb4673a4b\"]/ul/li[2]/a")).click();
    Thread.sleep(2000);
    String PageText= driver.findElement(By.tagName("body")).getText();
    Assert.assertTrue("Catalog is opened", PageText.contains("Service Categories"));
    
    driver.quit();
    System.out.println("Test Completed !");
}


}
