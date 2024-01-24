package testNgPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.elementRepo.AppLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.Fileutils;
import com.genericUtility.WebDriverUtils;

public class LogInUsingDataProvider {
	@DataProvider
	public Object[][] readdata() throws Throwable
	{
		ExcelUtils exlUtil = new ExcelUtils();
		Object[][] obj = new Object[2][2];
		
		obj[0][0] =  exlUtil.redDatafromExcel("LogInDetails",0, 0);
	    obj[0][1] =  exlUtil.redDatafromExcel("LogInDetails",0, 1);
		
		obj[1][0] =  exlUtil.redDatafromExcel("LogInDetails",1, 0);
		obj[1][1] =  exlUtil.redDatafromExcel("LogInDetails",1, 1);
	
		return obj;
	}

	@Test(dataProvider = "readdata")
	public void datafromexcel(String un, String pwd) throws Throwable
	{
		Fileutils fileutil = new Fileutils();
		WebDriverUtils webutil = new WebDriverUtils();
		WebDriver driver = new ChromeDriver();
		AppLoginPage lp = new AppLoginPage(driver);
		// maximise the browser
		webutil.maximiseWindow(driver);
		
		// implicit wait of 20sec
		webutil.implicitwait(driver, 20);
		
		//open app
		driver.get(fileutil.readDataFromPropertyFile("url"));
		
		lp.getuntext(un);
		lp.getpwdTxt(pwd);
		lp.getLoginBtn();
		
	}
}
