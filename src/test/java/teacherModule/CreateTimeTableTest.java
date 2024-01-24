package teacherModule;


import static org.testng.Assert.fail;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.elementRepo.AppLoginPage;
import com.elementRepo.TeacherMyTimeTablePage;
import com.elementRepo.TeacherDashBoardPage;
import com.genericUtility.BaseClass;

//@Listeners(com.genericUtility.ListnerClass.class)   //we dont need this statement to capture screen shot 
//we use the same statement in suite level that applied during execution to all the test scripts in suite
public class CreateTimeTableTest extends BaseClass {
	@Test
	public void createTimeTableTest() {
		
		// create obeject of POM classes
		AppLoginPage lp = new AppLoginPage(driver);
		TeacherDashBoardPage tdb = new TeacherDashBoardPage(driver);
		TeacherMyTimeTablePage mtt = new TeacherMyTimeTablePage(driver);
		
		// login to app as teacher
		lp.LoginAsTeacher();
		
		// click on time table link
		tdb.getTimetable().click();
		
		// click on my time table link
		tdb.getMytimeTable().click();
	
		
		// create my table by fill all the fields
		mtt.createMyTimeTable("Tuesday", "QSpiders", "Selenium", "java", "8", "10");
		

	}

}
