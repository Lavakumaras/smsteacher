package parentModule;



import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.elementRepo.AppLoginPage;
import com.elementRepo.ParentDashBoardPage;
import com.elementRepo.ParentMyProfilePage;
import com.genericUtility.BaseClass;

//@Listeners(com.genericUtility.ListnerClass.class)   //we dont need this statement to capture screen shot 
//we use the same statement in suite level that applied during execution to all the test scripts in suite
public class UpdateParentProfileTest extends BaseClass {
@Test
public void updateParentProfileTest()
{
		// create obeject of POM classes
		AppLoginPage lp = new AppLoginPage(driver);
		ParentDashBoardPage pdb = new ParentDashBoardPage(driver);
		ParentMyProfilePage mpp = new ParentMyProfilePage(driver);

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
	
	}

}
