package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonScripts {
	
	public static WebDriver driver;
	static WebDriverWait wait;
	public static String WritefilePath;



	public static WebDriver openUrl() {
		String browser = readProperty("browser");
		int browserno=0;
		if (browser.contains("Mozilla Firefox"))
		{
			browserno=1;
		}
		else if (browser.contains("Google Chrome"))
		{
			browserno=2;
		}
		else if (browser.contains("Internet Explorer"))
		{
			browserno=3;
		}
		String environment = readProperty("test.environment");
		String baseUrl = GetURL(environment);
		String chromeDriverPath = readProperty("chrome.driver.path");
		String ieDriverPath = readProperty("ie.driver.path");
		String MozillaDriverPath = readProperty("mozilla.driver.path");
		String downloadPath = readProperty("file.download.path");
		switch (browserno) {
		case 1:
			System.setProperty("webdriver.gecko.driver", MozillaDriverPath);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        capabilities.setCapability("marionette", true);
	        driver = new FirefoxDriver();
			break;
		case 2:
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;
		case 3:
			System.setProperty("webdriver.ie.driver", ieDriverPath);
			driver = new InternetExplorerDriver();
			break;

		default:
			System.err.println("Browser not recognized");
			break;
		}
		long startTime = System.currentTimeMillis();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(baseUrl);
		return driver;

	}

	// /-----------------------READ PROPERTY FUNCTION
	public static String readProperty(String property) {
		Properties properties = new Properties();
		try {

			InputStream input = new FileInputStream(
					"Config/testsettings.properties");
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (properties.getProperty(property));
	}
	
	// ------GET URL
	public static String GetURL(String environment) {
		String baseUrl = null;
		if (environment.contains("Test")) {
			baseUrl = readProperty("test.url");
		} else if (environment.contains("Development")) {
			baseUrl = readProperty("dev.url");
		} else if (environment.contains("Production")) {
			baseUrl = readProperty("live.url");
		}
		
		return baseUrl;
	}

	// ------GET URL
	public static WebDriver DoLogin()  {
		driver=Utils.CommonScripts.openUrl();
		String UName=readProperty("user.name");
		String Pwd=readProperty("password");
		PageObjects.LoginPage.txt_username(driver).sendKeys(UName);
		PageObjects.LoginPage.txt_password(driver).sendKeys(Pwd);
		PageObjects.LoginPage.btn_login(driver).click();
		
		return driver;
	}

	// Random Text Generation
	public static String RandomText(int len) {
		String text = "";

		String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		for (int i = 0; i < len; i++)
			text += charset.charAt((int) Math.floor(Math.random()
					* charset.length()));

		return text;
	}
	
	// Random Small Text Generation
	public static String RandomSmallText(int len) {
		String text = "";

		String charset = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < len; i++)
			text += charset.charAt((int) Math.floor(Math.random()
					* charset.length()));

		return text;
	}
}
