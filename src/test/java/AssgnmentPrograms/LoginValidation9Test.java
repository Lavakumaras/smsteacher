package AssgnmentPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtility.WebDriverUtils;

public class LoginValidation9Test {
	@Test
	public void  LoginWithValidDataTest(){
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wlib.implicitwait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
	Assert.assertEquals("Logged In Successfully",driver.findElement(By.xpath("//h1[text()='Logged In Successfully']")).getText());	
	}
	@Test
	public void  LoginWithInvalidDataTest(){
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wlib.implicitwait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("invalidstudent");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
	Assert.assertEquals("Your username is invalid!",driver.findElement(By.xpath("//div[text()='Your username is invalid!']")).getText());	
	}
}
