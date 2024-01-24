package testNgPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.elementRepo.AdminAddTeacherPage;
import com.elementRepo.AdminDashboardPage;
import com.elementRepo.AppLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.Fileutils;
import com.genericUtility.WebDriverUtils;

public class AdminTest {
	@Test(groups="smoke")
	public void AddNewTeacherTest() throws Throwable {
			
			// create object of utility classes
			Fileutils fileutil = new Fileutils();
			WebDriverUtils webutil = new WebDriverUtils();
			ExcelUtils exlutil = new ExcelUtils();
			
			// launch browser
			WebDriver driver = new ChromeDriver();
			
			// create obeject of POM classes
			AppLoginPage login = new AppLoginPage(driver);
			AdminAddTeacherPage atp = new AdminAddTeacherPage(driver);
			AdminDashboardPage adb = new AdminDashboardPage(driver);
		
			// maximise the browser
			webutil.maximiseWindow(driver);
			
			// implicit wait of 20sec
			webutil.implicitwait(driver, 20);
			
			//open app
			driver.get(fileutil.readDataFromPropertyFile("url"));
		
			// login to app
			login.LoginAsAdmin();
			
			// click on teacher kink
			adb.getTeacherLnk();
			
			// click on add teacher link
			adb.getAddTeacherLnk();
			
			// get last row count in the excel sheet
			exlutil.getLastRowNum("AdminCreateTeacher");
			
			// retrive the dat from excel and fill all the details
			atp.hashmapdata(exlutil, "AdminCreateTeacher", 0, driver);
			
			// click on submit button
			//atp.getSubmitBtn().click();
			
			//log out
			adb.adminLogOut();
			
			//close the browser
			driver.quit();
		}

}
