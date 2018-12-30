package Def_ValidLogin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Def_ValidLogin {
	
	WebDriver driver;
	
@Given("^user open login page$")
	public void user_open_login_page() throws Throwable {
    
	driver=Utils.CommonScripts.DoLogin();
}


@When("^Make sure text appeared: Welcome to the Cloud User Portal$")
public void make_sure_text_appeared_Welcome_to_the_Cloud_User_Portal() throws Throwable {
	String BodyText=PageObjects.LandingPage.tag_header(driver).getText();
	try {
		if(BodyText.contains("Welcome to the Cloud User Portal"))
		{
			System.out.println("Case 1 [Valid Login] : Login Welcome Message Displayed");
		}
		else
		{
			System.out.println("Case 1 [Valid Login] : Login Welcome Message Not Displayed");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 1 [Valid Login] : Login Welcome Message Not Displayed");
}

   
}

@When("^Check icon apeared$")
public void check_icon_apeared() throws Throwable {

	try {
		if(PageObjects.LandingPage.img_icon(driver).isDisplayed())
		{
			System.out.println("Case 2 [Valid Login] : Icon Displayed");
		}
		else
		{
			System.out.println("Case 2 [Valid Login] : Icon Not Displayed");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 2 [Valid Login] : Icon Not Displayed");
}
	
	
	
}

@When("^Check Lanch a stack option appeared$")
public void check_Lanch_a_stack_option_appeared() throws Throwable {
    
	try {
		if(PageObjects.LandingPage.lbl_LanchAStack(driver).isDisplayed())
		{
			System.out.println("Case 2 [Valid Login] : Lanch a stack option Displayed");
		}
		else
		{
			System.out.println("Case 2 [Valid Login] : Lanch a stack option Not Displayed");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 2 [Valid Login] : Lanch a stack option Not Displayed");
}
	
	
}

@When("^Check manage stack option appeared$")
public void check_manage_stack_option_appeared() throws Throwable {
	
	try {
		if(PageObjects.LandingPage.lbl_ManageStacks(driver).isDisplayed())
		{
			System.out.println("Case 2 [Valid Login] : Manage stack option Displayed");
		}
		else
		{
			System.out.println("Case 2 [Valid Login] : Manage stack option Not Displayed");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 2 [Valid Login] : Manage stack option Not Displayed");
}
    
}

@When("^Check view activities option appeared$")
public void check_view_activities_option_appeared() throws Throwable {
	
	try {
		if(PageObjects.LandingPage.lbl_ViewActivities(driver).isDisplayed())
		{
			System.out.println("Case 2 [Valid Login] : View activities option Displayed");
		}
		else
		{
			System.out.println("Case 2 [Valid Login] : View activities option Not Displayed");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 2 [Valid Login] : View activities option Not Displayed");
}
    
}

@When("^Check view dashboard option appeared$")
public void check_view_dashboard_option_appeared() throws Throwable {
	try {
		if(PageObjects.LandingPage.lbl_ViewDashboard(driver).isDisplayed())
		{
			System.out.println("Case 2 [Valid Login] : View dashboard option Displayed");
		}
		else
		{
			System.out.println("Case 2 [Valid Login] : View dashboard option Not Displayed");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 2 [Valid Login] : View dashboard option Not Displayed");
}
    
}

@When("^Print all option are available$")
public void print_all_option_are_available() throws Throwable {
    

    List <WebElement> Options =PageObjects.LandingPage.div_HeadSection(driver).findElements(By.tagName("h3"));
    for (int i=0; i<=Options.size()-1; i++)
    {
    	System.out.println(Options.get(i).getText());
    }
    System.out.println("Case 3 [Valid Login] : All Available option printed ");
}

@When("^click on manage stock option validate (\\d+) option menu apeared and available -print text$")
public void click_on_manage_stock_option_validate_option_menu_apeared_and_available_print_text(int arg1) throws Throwable {
    
    PageObjects.LandingPage.lbl_ManageStacks(driver).click();
    Thread.sleep(2000);
    WebElement MenuBar = PageObjects.ManageStacksPage.div_menubar(driver);
    List <WebElement> Options =MenuBar.findElements(By.tagName("li"));
    
	try {
		if(Options.size()==6)
		{
			System.out.println("Case 4 [Valid Login] : "+ Options.size() +" options available");
		}
		else
		{
			System.out.println("Case 4 [Valid Login] : "+ Options.size() +" options available");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 4 [Valid Login] : "+ Options.size() +" options available");
}
  
}

@When("^Click on Catalog validate page catalog is open$")
public void click_on_Catalog_validate_page_catalog_is_open() throws Throwable {
    
    PageObjects.ManageStacksPage.menu_catalog(driver).click();
    Thread.sleep(2000);
    String PageText= PageObjects.CatalogPage.tag_body(driver).getText();
    
	try {
		if(PageText.contains("Service Categories"))
		{
			System.out.println("Case 5 [Valid Login] : Catalog page opened");
		}
		else
		{
			System.out.println("Case 5 [Valid Login] : Catalog page not opened");
		}
} catch (Exception e) {
	// TODO Auto-generated catch block
		System.out.println("Case 5 [Valid Login] : Catalog page not opened");
}  
    
    driver.quit();
    System.out.println("Test Completed !");
}


}
