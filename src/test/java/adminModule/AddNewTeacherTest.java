package adminModule;

import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.elementRepo.AdminAddTeacherPage;
import com.elementRepo.AdminDashboardPage;
import com.elementRepo.AppLoginPage;
import com.genericUtility.BaseClass;

//@Listeners(com.genericUtility.ListnerClass.class)   //we dont need this statement to capture screen shot 
//we use the same statement in suite level that applied during execution to all the test scripts in suite
public class AddNewTeacherTest extends BaseClass {
	@Test
	public void addNewTeacherTest() throws Throwable {
		//SoftAssert sa = new SoftAssert();
		// create obeject of POM classes
		AppLoginPage login = new AppLoginPage(driver);
		AdminAddTeacherPage atp = new AdminAddTeacherPage(driver);
		AdminDashboardPage adb = new AdminDashboardPage(driver);

		// login to app
		login.LoginAsAdmin();
//		String actualurl = driver.getCurrentUrl();
//		String expectedurl = "http://rmgtestingserver/domain/Student_Management_System/view/dashboard.php";
//		sa.assertEquals(actualurl, expectedurl);
	
		// click on teacher kink
		adb.getTeacherLnk();

		// click on add teacher link
		adb.getAddTeacherLnk();

		// get last row count in the excel sheet
		elib.getLastRowNum("AdminCreateTeacher");

		// retrive the dat from excel and fill all the details
		atp.hashmapdata(elib, "AdminCreateTeacher", 0, driver);
		

		// click on submit button
		// atp.getSubmitBtn().click();
		//sa.assertAll();
	}
}
