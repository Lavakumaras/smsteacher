package testNgPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.elementRepo.AppLoginPage;
import com.genericUtility.Fileutils;
import com.genericUtility.WebDriverUtils;

public class AddClassRoomUsingDataProvider {

	@Test(dataProviderClass=Dataprovider.class,dataProvider = "addRoom")
	public void datafromexcel(String name, String count) throws Throwable
	{
		//create object of utility classes
		Fileutils fileutil = new Fileutils();
		WebDriverUtils webutil = new WebDriverUtils();
		
		//launch chrome browser
		WebDriver driver = new ChromeDriver();
		
		//create the object of POM classes
		AppLoginPage lp = new AppLoginPage(driver);
		
		// maximise the browser
		webutil.maximiseWindow(driver);
		
		// implicit wait of 20sec
		webutil.implicitwait(driver, 20);
		
		//open app
		driver.get(fileutil.readDataFromPropertyFile("url"));
		lp.LoginAsAdmin();
		driver.findElement(By.xpath("//span[text()='Classroom']")).click();
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("student_count")).sendKeys(count);
		driver.findElement(By.id("btnSubmit")).click();
	}
}
