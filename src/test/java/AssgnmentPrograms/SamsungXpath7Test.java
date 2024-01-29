package AssgnmentPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtils;

public class SamsungXpath7Test {

	public static void main(String[] args) throws Throwable {
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wlib.implicitwait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[text()='Appliances']")).click();
		WebElement tv = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
		wlib.mouseOverAction(driver, tv);
		WebElement samsung = driver.findElement(By.xpath("//a[text()='Samsung']"));
		wlib.ClickOnElementAction(driver, samsung);
		
}
}