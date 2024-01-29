package AssgnmentPrograms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.ExcelUtils;
import com.genericUtility.IPathConstants;
import com.genericUtility.WebDriverUtils;

public class StorePriceInExcel8Test {

	public static void wrireDataintoExcel(String SheetName, int row, int cell, String data,String value) throws Throwable {
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		sh.getRow(row).createCell(cell+1).setCellValue(value);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
	}
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		ExcelUtils elib= new ExcelUtils();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("iPhone 13");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> moblist = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> pricelist = driver.findElements(By.xpath(
				"//div[@class='_4rR01T']//ancestor::div[@class='_3pLy-c row']//descendant::div[@class='col col-5-12 nlI3QM']//descendant::div[@class='_30jeq3 _1_WHN1']"));

	

		for (int i = 0; i < pricelist.size(); i++) {
			String price = pricelist.get(i).getText();
			String name = moblist.get(i).getText();
			price = price.replace("₹", "");
			price = price.replace(",", "");
			int intAmount = Integer.parseInt(price);
			String amount=Integer.toString(intAmount);
			wrireDataintoExcel("pricelist", i, 0, name, amount);
			
		}
		
	}
}