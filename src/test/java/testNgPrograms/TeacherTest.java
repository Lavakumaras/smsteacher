package testNgPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.elementRepo.AdminAddTimeTablePage;
import com.elementRepo.AdminDashboardPage;
import com.elementRepo.AdminSubjectRoutingPage;
import com.elementRepo.AppLoginPage;
import com.elementRepo.TeacherDashBoardPage;
import com.elementRepo.TeacherMySubjectPage;
import com.elementRepo.TeacherMyTimeTablePage;
import com.genericUtility.Fileutils;
import com.genericUtility.WebDriverUtils;

public class TeacherTest {
	@Test(groups="integration")
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

	@Test(groups= {"integration","system"})
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

@Test(groups="system")
public void VerifyMySubjectTest() throws Throwable {

		// create utility classes objects
		Fileutils fileutil = new Fileutils();
		WebDriverUtils webutil = new WebDriverUtils();

		// launch browser
		WebDriver driver = new ChromeDriver();

		// create obeject of POM classes
		AppLoginPage lp = new AppLoginPage(driver);
		AdminDashboardPage adb = new AdminDashboardPage(driver);
		AdminSubjectRoutingPage sub = new AdminSubjectRoutingPage(driver);
		TeacherDashBoardPage tdb = new TeacherDashBoardPage(driver);
		TeacherMySubjectPage ms = new TeacherMySubjectPage(driver);
		
		// maximize window
		webutil.maximiseWindow(driver);
		
		// implicit wait of 20 sec
		webutil.implicitwait(driver, 20);
		
		// open app
		driver.get(fileutil.readDataFromPropertyFile("url"));
		
		// login to app as admin
		lp.LoginAsAdmin();
		
		// store subject name
		String SUBJECT = "Manual";
		
		// click on subject routing
		adb.getSubjectRoutingLnk().click();
		
		
		// click on add lookup img
		sub.getAddLookUpImg().click();
		
		// select and enter all the details
		sub.AddSubject("QSpiders", SUBJECT, "sms", "111");
		
		//log out
		adb.adminLogOut();
		
		// enter the app url
		driver.navigate().to(fileutil.readDataFromPropertyFile("url"));
		
		// login to app as teacher
		lp.LoginAsTeacher();
		
		// click on subject link
		tdb.getSubject().click();
		
		// click on my subject link
		tdb.getMySubject().click();
		
		//varify my subject
		ms.verifyTheSbuject(SUBJECT, driver);
		
		//log out
		tdb.teacherLogOut();
		
		//close the browser
		driver.quit();
	}

}
