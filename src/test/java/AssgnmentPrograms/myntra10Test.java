package AssgnmentPrograms;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.genericUtility.WebDriverUtils;

public class myntra10Test {
	public static void waitForVisibilityOfElements(int sec, WebDriver driver, List<WebElement> images) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOfAllElements(images));
	}

	public static void main(String[] args) throws Throwable {
		ChromeOptions act = new ChromeOptions();
		act.addArguments("--disable-notifications");
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver = new ChromeDriver(act);
		wlib.implicitwait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		WebElement homeAndLiving = driver.findElement(By.xpath("//a[text()='Home & Living']"));
		wlib.mouseOverAction(driver, homeAndLiving);
		List<WebElement> homeDecor = driver.findElements(By.xpath("//li[@data-reactid='576']/following-sibling::li"));

		for (WebElement lv : homeDecor) {
			System.out.println(lv.getText());
		}
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		wlib.mouseOverAction(driver, men);
		Thread.sleep(2000);
		wlib.ClickOnElementAction(driver, driver.findElement(By.xpath("//a[text()='Jackets']")));
		Thread.sleep(5000);
		List<WebElement> img = driver.findElements(By.xpath("//img[@class='img-responsive']"));
		for (WebElement image : img) {
			wlib.scrollAction(driver, image);
		}
		int images = driver.findElements(By.xpath("//img[@class='img-responsive']")).size();

		System.out.println("number of images = " + images);

	}
}