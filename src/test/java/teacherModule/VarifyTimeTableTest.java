package teacherModule;

import static org.testng.Assert.fail;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.elementRepo.AdminAddTimeTablePage;
import com.elementRepo.AdminDashboardPage;
import com.elementRepo.AppLoginPage;
import com.elementRepo.TeacherDashBoardPage;
import com.genericUtility.BaseClass;

//@Listeners(com.genericUtility.ListnerClass.class)   //we dont need this statement to capture screen shot 
//we use the same statement in suite level that applied during execution to all the test scripts in suite
public class VarifyTimeTableTest extends BaseClass {
	@Test

	public void varifyTimeTableTest() throws Throwable {

		// create obeject of POM classes
		AppLoginPage lp = new AppLoginPage(driver);
		AdminDashboardPage adb = new AdminDashboardPage(driver);
		AdminAddTimeTablePage att = new AdminAddTimeTablePage(driver);
		TeacherDashBoardPage tdb = new TeacherDashBoardPage(driver);

		// login to app
		lp.LoginAsAdmin();

		// click on time table link
		adb.getTimeTableLnk().click();

		// store subject name
		String Subject = "DBMS";
	
Assert.fail();
		// add time table select and enter all data
		att.addTimeTable("QSpiders", "Friday", Subject, "sms", "QSpiders_Premium", "2", "4");

		// logout from admin module
		adb.adminLogOut();

		// login as teacher
		lp.LoginAsTeacher();

		// click on time table
		tdb.getTimetable().click();
		
		// click on my time table
		tdb.getMytimeTable().click();

		// varifyb the time table
		att.varifyTimetable(driver);

	}

}
