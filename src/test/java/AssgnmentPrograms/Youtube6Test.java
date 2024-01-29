package AssgnmentPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtils;

public class Youtube6Test {
	public static void main(String[] args) throws Throwable {
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wlib.implicitwait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("song");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(" ");
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//b[text()=' new']"));
		wlib.waitForVisibilityOfElement( 30,driver, search);	
		search.click();
		
	
	}

}
