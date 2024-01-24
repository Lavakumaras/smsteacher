package testNgPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.elementRepo.AdminAddTeacherPage;
import com.elementRepo.AdminAddTimeTablePage;
import com.elementRepo.AdminDashboardPage;
import com.elementRepo.AppLoginPage;
import com.elementRepo.ParentDashBoardPage;
import com.elementRepo.ParentMyProfilePage;
import com.elementRepo.TeacherDashBoardPage;
import com.elementRepo.TeacherMyTimeTablePage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.Fileutils;
import com.genericUtility.WebDriverUtils;

public class Testnagscripts {
	@Test
	public void AddNewTeacherTest() throws Throwable {
			
			// create object of utility classes
			Fileutils fileutil = new Fileutils();
			WebDriverUtils webutil = new WebDriverUtils();
			ExcelUtils exlutil = new ExcelUtils();
			
			// launch browser
			WebDriver driver = new FirefoxDriver();
			
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

	@Test
	public void UpdateParentProfileTest() throws Throwable {

			// create object of utility classes
			Fileutils fileutil = new Fileutils();
			WebDriverUtils webutil = new WebDriverUtils();

			// launch browser
			WebDriver driver = new ChromeDriver();

			// maximise the browser
			webutil.maximiseWindow(driver);

			// implicit wait of 20sec
			webutil.implicitwait(driver, 20);

			// create obeject of POM classes
			AppLoginPage lp = new AppLoginPage(driver);
			ParentDashBoardPage pdb = new ParentDashBoardPage(driver);
			ParentMyProfilePage mpp = new ParentMyProfilePage(driver);

			// open app
			driver.get(fileutil.readDataFromPropertyFile("url"));

			// login to app as parent
			lp.LoginAsParent();
			
			//click on profile link
			pdb.getProfileLnk().click();
			
			//click on my profile link
			pdb.getMyProfileLnk().click();
			
			//click on edit button
			mpp.getEditBtn().click();
			
			//store the parent name
			String parentName = "sudeep";
			
			//clear the parent full name text field
			mpp.getFullNameTxt().clear();
			
			//enter the updated parent full name
			mpp.getFullNameTxt().sendKeys(parentName);
			
			//click on update button
			mpp.getUpdateBtn().click();

			//refresh the page
			driver.navigate().refresh();
			
			//validate the updated field 
			mpp.validateUpdateMyProfileByName(driver, parentName);
			
			//log out
			pdb.parentLogOut();
			
			//close the browser
			driver.quit();
		}

	@Test
	public void CreateTimeTableTest() throws Throwable {
		// create object of utility classes
			Fileutils fileutil = new Fileutils();
			WebDriverUtils webutil = new WebDriverUtils();
			
			// launch browser
			WebDriver driver = new ChromeDriver();
			
			// maximise the browser
			webutil.maximiseWindow(driver);
			
			// implicit wait of 20sec
			webutil.implicitwait(driver, 20);
			
			// create obeject of POM classes
			AppLoginPage lp = new AppLoginPage(driver);
			TeacherDashBoardPage tdb = new TeacherDashBoardPage(driver);
			TeacherMyTimeTablePage mtt = new TeacherMyTimeTablePage(driver);
			
			// open app
			driver.get(fileutil.readDataFromPropertyFile("url"));
			
			// login to app as teacher
			lp.LoginAsTeacher();
			
			// click on time table link
			tdb.getTimetable().click();
			
			// click on my time table link
			tdb.getMytimeTable().click();

			// create my table by fill all the fields
			mtt.createMyTimeTable("Tuesday", "QSpiders", "Selenium", "java", "8", "10");
			
			//log out
			tdb.teacherLogOut();
			
			//close the browser
			driver.quit();
		}

	@Test
	public void VarifyTimeTableTest() throws Throwable {

		
			// create object of utility classes
					Fileutils fileutil = new Fileutils();
					WebDriverUtils webutil = new WebDriverUtils();
			
					
					// launch browser
					WebDriver driver = new ChromeDriver();
					
					// create obeject of POM classes
					AppLoginPage lp = new AppLoginPage(driver);
					AdminDashboardPage adb = new AdminDashboardPage(driver);
					AdminAddTimeTablePage att= new AdminAddTimeTablePage(driver);
					TeacherDashBoardPage tdb= new TeacherDashBoardPage(driver);
					// maximise the browser
					webutil.maximiseWindow(driver);
					
					// implicit wait of 20sec
					webutil.implicitwait(driver, 20);
					
					//open app
					driver.get(fileutil.readDataFromPropertyFile("url"));
				
					// login to app
					lp.LoginAsAdmin();
					
					//click on time table link
					adb.getTimeTableLnk().click();
					
					//store subject name
					String Subject = "DBMS";
					
					//add time table select and enter all data
					att.addTimeTable("QSpiders", "Friday", Subject, "sms", "QSpiders_Premium", "2", "4");
					
					driver.navigate().to(fileutil.readDataFromPropertyFile("url"));
					
					//login as teacher
					lp.LoginAsTeacher();
					
					//click on time table
					tdb.getTimetable().click();
					
					//click on my time table
					tdb.getMytimeTable().click();
					
					//varifyb the time table
					att.varifyTimetable(driver);
					
					//log out
					tdb.teacherLogOut();
					
					//close the browser
					driver.quit();

		}

}
