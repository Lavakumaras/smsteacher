package com.genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtils {
	/**
	 * This method is used to maximise the browser
	 * 
	 * @param driver
	 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to minimise browser
	 * 
	 * @param driver
	 */
	public void minimiseWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used to wait until page load
	 * 
	 * @param driver
	 * @param sec
	 */
	public void implicitwait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	/**
	 * This method is used to wait For Visibility Of Element
	 * 
	 * @param sec
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(int sec, WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		//WebDriverWait is a class
		//Duration is a final class
		// ofSeconds is a static method
		//until is a function
		//ExpectedConditions is a class
		//visibilityOf is a static methos
		
	}
	

	/**
	 * This method is used to wait Until Title Contains
	 * 
	 * @param sec
	 * @param driver
	 * @param title
	 */
	public void waitUntilTitleContains(int sec, WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * This method is used to wait until Element To Be Selected
	 * 
	 * @param sec
	 * @param driver
	 * @param element
	 */
	public void waituntilElementToBeSelected(int sec, WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * This method is used to wait until Element To Be Clickable
	 * 
	 * @param sec
	 * @param driver
	 * @param element
	 */
	public void waituntilElementToBeClickable(int sec, WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to handle dropDown Select By Index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDown(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	/**
	 * This method is used to handle dropDown Select By Value
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * This method is used to handle drop Down Select By Visible Text
	 * 
	 * @param element
	 * @param text
	 */
	public void selectDropDown(String text,WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method is move over action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * This method is used to Click On Element Action
	 * 
	 * @param driver
	 * @param element
	 */
	public void ClickOnElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	/**
	 * This method is used to Right Click On Element Action
	 * 
	 * @param driver
	 * @param element
	 */
	public void RightClickOnElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method is used to Double Click On Element Action
	 * 
	 * @param driver
	 * @param element
	 */
	public void DoubleClickOnElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method is used to Scroll To Element Action
	 * 
	 * @param driver
	 * @param element
	 */
	public void ScrollToElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	/**
	 * This method is used to Drag And Drop Action
	 * 
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void DragAndDropAction(WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

	/**
	 * This method is used to accept the Alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to dismiss the Alert
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to get text from Alert
	 * 
	 * @param driver
	 */
	public void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	/**
	 * This method is used to send keys to the Alert
	 * 
	 * @param driver
	 * @param keys
	 */
	public void sendKeysAlert(WebDriver driver, String keys) {
		driver.switchTo().alert().sendKeys(keys);
	}

	/**
	 * This method is used to handle frame by index
	 * 
	 * @param driver
	 * @param frameindex
	 */
	public void frameHandleByIndex(WebDriver driver, int frameindex) {
		driver.switchTo().frame(frameindex);
	}

	/**
	 * This method is used to handle frame by Name or Id
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	public void frameHandleByIdrName(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method is used to handle frame by FrameElement
	 * 
	 * @param driver
	 * @param frameElement
	 */
	public void frameHandleByElement(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	/**
	 * This method is used to Switch to immediate parent Frame
	 * 
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * This method is used to switch to main Frame
	 * 
	 * @param driver
	 */
	public void switchToMainFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * This method is used to open new Window
	 * 
	 * @param driver
	 */
	public void openNewWindow(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	/**
	 * This method is used to open new Tab
	 * 
	 * @param driver
	 */
	public void openNewTab(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	/**
	 * This method is used to capture screen shot
	 * 
	 * @param driver
	 * @param screenShotname
	 * @return
	 * @throws Throwable
	 */
	public static String captureScreenshot(WebDriver driver, String screenShotname) throws Throwable {
		Javautils jlib= new Javautils();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);  //temporary location
		File dst = new File("./Screenshots/"+screenShotname+jlib.getSystemdateInFormat()+".png");	
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
	}
	/**
	 * This method is used to hanle windows
	 * 
	 * @param driver
	 * @param expectedPartialTitle
	 */
	public void handleWindows(WebDriver driver, String expectedPartialTitle) {
		Set<String> allWindows = driver.getWindowHandles();// capture all windoes Id's

		for (String win : allWindows) {
			String actualTitle = driver.switchTo().window(win).getTitle();// switch to each window and capture the each window title
			if (actualTitle.contains(expectedPartialTitle)) // compare the required window title
			{
				break;
			}
		}

	}

	/**
	 * This method is used to scroll down for 500 units
	 * 
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}

	/**
	 * This method is used to scroll up for 500 units
	 * 
	 * @param driver
	 */
	public void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,-500);", "");
	}
	
	/**
	 * THis method will scroll untill the specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executeScript("argument[0].scrollIntoView()",element);
				
	}

	

}
