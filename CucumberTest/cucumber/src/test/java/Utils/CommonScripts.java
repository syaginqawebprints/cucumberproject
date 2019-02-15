package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
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
	
	// Generate Date and Time
	public static String GetDateTime() {
		String text = "";

		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy-HH-mm-ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   text=dtf.format(now);  
		return text;
	}
	
		public static String[][] GetServerList() {
			String filePath = readProperty("virtual.server.dbpath");
			Integer DataListSize=2;
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {

			}
			Workbook workbook = null;
			Sheet sheet;
			if (filePath.endsWith(".xlsx"))
				try {
					workbook = new XSSFWorkbook(fis);
				} catch (IOException e) {

				}
			else if (filePath.endsWith(".xls"))
				workbook = new HSSFWorkbook();
			else {
				System.err.println("Invalid file type");
			}
			sheet = workbook.getSheetAt(0);
			int RCount = sheet.getPhysicalNumberOfRows();
			String[][] ServerList = new String[RCount][2];
			for (int count = 0; count <= RCount - 1; count++) {
				Row row = sheet.getRow(count);
				for (int j = 0; j <= DataListSize - 1; j++) {
					try {
						if (row.getCell(j).toString() == null) {
							ServerList[count][j] = "";
						} else {
							ServerList[count][j] = row.getCell(j).toString();
						}

					} catch (NullPointerException e) {
						ServerList[count][j] = "";
					}
				}
			}

			return ServerList;

		}
	
		public static int WriteServerList(String ServerName, String DelStatus, int RowNumber)
				throws IOException {
			
			String filePath = readProperty("virtual.server.dbpath");
			String SheetName="VirtualServers";
			String WritefilePath = filePath;
			List<String> SheetNames = new ArrayList<String>();
			File file = new File(WritefilePath);
			XSSFWorkbook workbook = null;
			XSSFSheet sheet = null;
			// Managing Sheet Name Length
			if (SheetName.length() >= 31) {
				SheetName = SheetName
						.substring(0, Math.min(SheetName.length(), 31));

			}
			if (file.exists()) {

				FileInputStream input = new FileInputStream(file);
				workbook = new XSSFWorkbook(input);

				for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
					XSSFSheet currentSheet = workbook.getSheetAt(i);
					SheetNames.add(currentSheet.getSheetName());
				}

				if (SheetNames.contains(SheetName)) {
					sheet = workbook.getSheet(SheetName);
				} else {

					sheet = workbook.createSheet(SheetName);
				}

				input.close();
			} else {
				workbook = new XSSFWorkbook();
				sheet = workbook.createSheet(SheetName);
			}

			int rowNo = 0;
			Row row;
			Cell cell;
			
			try {
				FileOutputStream output = new FileOutputStream(file);
						//---------ROW4
				row = sheet.createRow(RowNumber);
				cell = row.createCell(0);
				cell.setCellValue(ServerName);
				cell = row.createCell(1);
				cell.setCellValue(DelStatus);
				
				if (RowNumber == 0) {
					RowNumber = rowNo++;
				}

				else {
					RowNumber = RowNumber + 1;
				}
			
				workbook.write(output);
				output.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return RowNumber;
	
	
}
		
		public static void RemoveRow(int RowNum) {
			String filePath = readProperty("virtual.server.dbpath");
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {

			}
			Workbook workbook = null;
			Sheet sheet;
			if (filePath.endsWith(".xlsx"))
				try {
					workbook = new XSSFWorkbook(fis);
				} catch (IOException e) {

				}
			else if (filePath.endsWith(".xls"))
				workbook = new HSSFWorkbook();
			else {
				System.err.println("Invalid file type");
			}
			sheet = workbook.getSheetAt(0);
			Row DelRow=sheet.getRow(RowNum);
			sheet.removeRow(DelRow);
			

			

		}
		
		public static void FocusElement(WebElement FElement)
		{
			  
			   Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
		        if (cp.getBrowserName().equals("chrome")) {
		            try {
		                ((JavascriptExecutor) driver).executeScript(
		                        "arguments[0].scrollIntoView(true);",FElement);
		            } catch (Exception e) {

		            }
		        }
		}
}
