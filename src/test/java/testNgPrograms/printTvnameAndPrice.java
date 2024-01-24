package testNgPrograms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class printTvnameAndPrice {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("LG tv");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> moblist = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> pricelist = driver.findElements(By.xpath(
				"//div[@class='_4rR01T']//ancestor::div[@class='_3pLy-c row']//descendant::div[@class='col col-5-12 nlI3QM']//descendant::div[@class='_30jeq3 _1_WHN1']"));

		for (int i = 0; i < moblist.size(); i++) {
			String Names = moblist.get(i).getText();
			String price = pricelist.get(i).getText();

			price = price.replace("₹", "");
			price = price.replace(",", "");
			int intAmount = Integer.parseInt(price);

			if (intAmount > 50000) {
				System.out.println(Names + " = " + intAmount);
			}
		}
	}
}
