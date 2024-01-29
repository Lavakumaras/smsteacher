package AssgnmentPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtils;

public class lastnameXpath5Test {
	public static void main(String[] args) throws Throwable {
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wlib.implicitwait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.findElement(By.xpath("//input[@maxlength='15']")).sendKeys("abcdef");
	
	}

}
