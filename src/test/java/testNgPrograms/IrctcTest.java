package testNgPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericUtility.BaseClass;
@Listeners(com.genericUtility.ListnerClass.class)
public class IrctcTest extends BaseClass {
	@Test
	public void IRCTCTest() throws Throwable {
		driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
		wlib.handleWindows(driver, "IRCTC Bus - Online Bus Ticket Booking | Bus Reservation");
		driver.findElement(By.id("departFrom")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		driver.findElement(By.id("goingTo")).sendKeys("mysore");
		driver.findElement(By.xpath("//div[text()='Mysore']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.id("departDate")).click();
	//	Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//span[text()='January']/ancestor::div[@class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']/descendant::table[@class='ui-datepicker-calendar']/descendant::a[text()='29']")).click();
			
		driver.findElement(By.xpath("//button[text()='Search Bus ']")).click();
		driver.findElement(By.xpath("//h4[text()='Departure Time']//ancestor::div[@class='heading-02-wrap']/descendant::li/label[text()='After 6 pm']")).click();
		
		
		driver.findElement(By.xpath("//label[text()='SRS Travels']/ancestor::div[@class='search-result-card']/descendant::div[@class='SearchCard SearchCard07']")).click();
		
		driver.findElement(By.xpath("//span[@title='Seat No. : 1U | Fare : INR 945.00']")).click();
		driver.findElement(By.xpath("//div[@class='Seat-right-wrap']/descendant::p[text()='Madiwala']/ancestor::tr/td//input[@class='ng-untouched ng-pristine ng-valid']")).click();
		driver.findElement(By.xpath("//div[@class='Seat-right-wrap']/descendant::p[text()='Gandhi Square']/ancestor::tr/td//input[@class='ng-untouched ng-pristine ng-valid']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed to Book']")).click();
		driver.findElement(By.id("profile-tab")).click();
		driver.findElement(By.id("emailLogin")).sendKeys("lava.llp2512@gmail.com");
		driver.findElement(By.id("phoneLogin")).sendKeys("9113018001");
		driver.findElement(By.xpath("//div[@id='profile']//button[@type='submit' and text()='Login']")).click();
		
		driver.findElement(By.xpath("//input[@name='mobileno']")).sendKeys("9123456789");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("bangalore");
		WebElement country= driver.findElement(By.xpath("//select[@name='country']"));
		wlib.selectDropDown("India",country);
		WebElement state= driver.findElement(By.xpath("//select[@name='state']"));
		wlib.selectDropDown("KARNATAKA",state);

		driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("577560");
		
		driver.findElement(By.xpath("//input[@placeholder='Traveller Name']")).sendKeys("abcdef");
		driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("30");
		wlib.selectDropDown("Male", driver.findElement(By.xpath("//select[@name='select']")));
		WebElement con=driver.findElement(By.xpath("//input[@id='agree']"));
		wlib.ClickOnElementAction(driver, con);
		//wlib.mouseOverAction(driver, con);
		//con.click();
		driver.findElement(By.xpath("//button[text()='Continue to Book ']")).click();
		
		
	
	}
}