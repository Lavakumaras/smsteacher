package com.elementRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class AdminAddTimeTablePage {
	@FindBy(id = "grade")
	private WebElement graddeDropdwn;

	@FindBy( xpath= "//button[text()='Submit']")
	private WebElement gradeSubmitBtn;

	@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")
	private WebElement addTimetableBtn;

	@FindBy(id = "day")
	private WebElement dayDropdwn;

	@FindBy(id = "subject")
	private WebElement subjectDropdwn;

	@FindBy(id = "teacher")
	private WebElement teacherDropdwn;

	@FindBy(id = "classroom")
	private WebElement classroomDropdwn;

	@FindBy(id = "start_time")
	private WebElement startTimeTxt;

	@FindBy(id = "end_time")
	private WebElement endtTimeTxt;
	
	@FindBy(id = "btnSubmit")
	private WebElement timetableFieldSubmitBtn;

	public AdminAddTimeTablePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getGraddeDropdwn() {
		return graddeDropdwn;
	}

	public WebElement getSubmitBtn() {
		return gradeSubmitBtn;
	}

	public WebElement getAddTimetableBtn() {
		return addTimetableBtn;
	}

	public WebElement getDayDropdwn() {
		return dayDropdwn;
	}

	public WebElement getSubjectDropdwn() {
		return subjectDropdwn;
	}

	public WebElement getTeacherDropdwn() {
		return teacherDropdwn;
	}

	public WebElement getClassroomDropdwn() {
		return classroomDropdwn;
	}

	public WebElement getStartTimeTxt() {
		return startTimeTxt;
	}

	public WebElement getEndtTimeTxt() {
		return endtTimeTxt;
	}
	
	public WebElement getTimetableFieldSubmitBtn() {
		return timetableFieldSubmitBtn;
	}
	
	public void addTimeTable(String grade, String day, String subject, String teacher, String room, String startTime, String endTime) {
	WebDriverUtils wlib=new WebDriverUtils();
	wlib.selectDropDown(grade, graddeDropdwn);
	gradeSubmitBtn.click();
	addTimetableBtn.click();
	wlib.selectDropDown(day, dayDropdwn);
	wlib.selectDropDown(subject, subjectDropdwn);
	wlib.selectDropDown(teacher, teacherDropdwn);
	wlib.selectDropDown(room, classroomDropdwn);
	startTimeTxt.sendKeys(startTime);
	endtTimeTxt.sendKeys(endTime);
	timetableFieldSubmitBtn.click();
	}
	
	public void varifyTimetable(WebDriver driver) {
		WebElement timetable = driver.findElement(By.xpath("(//tr[@id='2.00_4.00']//td)[2]//a[text()='Edit']"));

		if (timetable.isDisplayed()) {
			System.out.println("time table added successfully");
		} else {
			System.out.println("failed to add time table");
		}
	}
	
}
