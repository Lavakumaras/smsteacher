package com.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.elementRepo.AdminDashboardPage;

public class BaseClass {

	public DBUtils dblib = new DBUtils();
	public ExcelUtils elib = new ExcelUtils();
	public Fileutils flib = new Fileutils();
	public WebDriverUtils wlib = new WebDriverUtils();

	public WebDriver driver;
	public static WebDriver sdriver;    // for listener to capture screenshot

	@BeforeSuite(alwaysRun = true)//for batch r group execution
	public void config_BS() throws Throwable {
		dblib.connectToDB();
		
		Reporter.log("--DB connceted successfully-- ", true);
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void config_BC(/*String BROWSER*/) throws Throwable {  
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
	/*	String	BROWSER=flib.readDataFromPropertyFile("browser");    
	
	 if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver= new FirefoxDriver();
		
	}
	 else if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}	
		else {
			System.out.println("-- invalid browser--");
		}
	*/
		sdriver= driver;
		wlib.maximiseWindow(driver);

		Reporter.log("browser launched", true);
	
	}

	@BeforeMethod(alwaysRun = true) //for batch r group execution
	public void config_BM() throws Throwable {
		//driver.get(flib.readDataFromPropertyFile("irctcUrl"));
		wlib.implicitwait(driver, 20);
		
		Reporter.log("application launched", true);
	
	}

	@AfterMethod(alwaysRun = true)//for batch r group execution
	public void config_AM() throws Throwable {
		//AdminDashboardPage adb = new AdminDashboardPage(driver);
		//adb.adminLogOut();
		Reporter.log("logged out ", true);
	}
	
	@AfterClass(alwaysRun = true)//for batch r group execution
	public void config_AC() {

		driver.quit();

		Reporter.log("browser closed", true);
	
	}

	@AfterSuite(alwaysRun = true)//for batch r group execution
	public void config_AS() throws Throwable {
		dblib.closeDB();
		Reporter.log("DB closed", true);
	}

}
