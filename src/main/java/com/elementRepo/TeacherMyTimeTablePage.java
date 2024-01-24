package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class TeacherMyTimeTablePage extends WebDriverUtils {

	//declaration
	@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")
	private WebElement addLookUpImg;
	
	@FindBy(id = "day")
	private WebElement dayDropdwn;
	
	@FindBy(id = "grade")
	private WebElement gradeDropdwn;
	
	@FindBy(id = "subject")
	private WebElement subjectDropdwn;
	
	@FindBy(id = "classroom")
	private WebElement classroomDropdwn;
	
	@FindBy(id = "start_time")
	private WebElement startTimeTxt;


	@FindBy(id = "end_time")
	private WebElement endTimeTxt;

	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;
	
	//initialisation
	public TeacherMyTimeTablePage(WebDriver driver) {
	PageFactory.initElements(driver ,this);
	}
	//utilisation
	
	//bussiness library
	public void createMyTimeTable(String day, String grade, String sub, String room,String startTime, String endTime ) {
		addLookUpImg.click();
		selectDropDown(day, dayDropdwn);
		selectDropDown(grade, gradeDropdwn);
		selectDropDown(sub, subjectDropdwn);
		selectDropDown(room, classroomDropdwn);
		startTimeTxt.sendKeys(startTime);
		endTimeTxt.sendKeys(endTime);
		submitBtn.click();
		
	} 
}
