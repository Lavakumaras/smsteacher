package testNgPrograms;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtils;

public class windowhandle {
	public static void main(String[] args) throws Throwable {
		WebDriverUtils wlib = new WebDriverUtils();
		/* launches the chrome browser */
		WebDriver driver = new ChromeDriver();
		/* maximise or minimise browser */
		driver.manage().window().maximize();
		/* fetches the app and wait until it is loaded */
		driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");
		// identifies and click on followall button
		driver.findElement(By.id("followall")).click();

		wlib.handleWindows(driver, "LambdaTest | San Francisco CA | Facebook");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@name='pass'])[2]")).sendKeys("1234577");
		Thread.sleep(3000);

		wlib.handleWindows(driver, "LambdaTest (@lambdatesting) / X");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		wlib.handleWindows(driver, "Selenium Grid Online | Run Selenium Test On Cloud");
		driver.findElement(By.xpath("//input[@type='url']")).sendKeys("sadihghasoidg");
		Thread.sleep(3000);

		driver.quit();
	}
}