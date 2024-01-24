package teacherModule;


import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.elementRepo.AdminDashboardPage;
import com.elementRepo.AppLoginPage;
import com.elementRepo.TeacherMySubjectPage;
import com.elementRepo.AdminSubjectRoutingPage;
import com.elementRepo.TeacherDashBoardPage;
import com.genericUtility.BaseClass;

//@Listeners(com.genericUtility.ListnerClass.class)   //we dont need this statement to capture screen shot 
//we use the same statement in suite level that applied during execution to all the test scripts in suite
public class VerifyMySubjectTest extends BaseClass {
@Test(/*retryAnalyzer = com.genericUtility.RetryImpClass.class*/)   //pass retry class at test level and if use data provoder then use comma and write the retry class
public void verifyMySubjectTest() throws Throwable {
	
		// create obeject of POM classes
		AppLoginPage lp = new AppLoginPage(driver);
		AdminDashboardPage adb = new AdminDashboardPage(driver);
		AdminSubjectRoutingPage sub = new AdminSubjectRoutingPage(driver);
		TeacherDashBoardPage tdb = new TeacherDashBoardPage(driver);
		TeacherMySubjectPage ms = new TeacherMySubjectPage(driver);
		
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
	
		// login to app as teacher
		lp.LoginAsTeacher();
		
		// click on subject link
		tdb.getSubject().click();
		
		// click on my subject link
		tdb.getMySubject().click();
		
		//varify my subject
		ms.verifyTheSbuject(SUBJECT, driver);
	}

}
