package testNgPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.elementRepo.AppLoginPage;
import com.elementRepo.ParentDashBoardPage;
import com.elementRepo.ParentMyProfilePage;
import com.genericUtility.Fileutils;
import com.genericUtility.WebDriverUtils;

public class ParentTest {
	@Test(groups="smoke")
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


}
