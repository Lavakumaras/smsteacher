package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {

	@FindBy(xpath = "//span[text()='Teacher']")
	private WebElement teacherLnk;

	@FindBy(xpath = "//a[text()=' Add Teacher']")
	private WebElement addTeacherLnk;

	@FindBy(xpath = "//a[text()=' All Teacher']")
	private WebElement allTeacherLnk;

	@FindBy(xpath = "//span[text()='Subject']")
	private WebElement subjectLnk;

	@FindBy(xpath = "//span[text()='Subject Routing']")
	private WebElement subjectRoutingLnk;

	@FindBy(xpath = "//a[text()=' Add Student']")
	private WebElement addSudentLnk;

	@FindBy(xpath = "//a[text()=' All Student']")
	private WebElement allSudentLnk;

	@FindBy(xpath = "//span[text()='Timetable']")
	private WebElement timeTableLnk;

	@FindBy(xpath = "//img[@class='user-image']")
	private WebElement ProfileMenu;

	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement logOutBtn;

	public AdminDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void getTeacherLnk() {
		teacherLnk.click();
	}

	public void getAddTeacherLnk() {
		addTeacherLnk.click();
	}

	public void getAllTeacherLnk() {
		allTeacherLnk.click();
	}

	public void getSubjectLnk() {
		subjectLnk.click();
	}

	public WebElement getSubjectRoutingLnk() {
		return subjectRoutingLnk;
	}

	public WebElement getAddSudentLnk() {
		return addSudentLnk;
	}

	public WebElement getAllSudentLnk() {
		return allSudentLnk;
	}

	public WebElement getTimeTableLnk() {
		return timeTableLnk;
	}

	public WebElement getProfileMenu() {
		return ProfileMenu;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	
	public void adminLogOut() throws Throwable {
		Thread.sleep(3000);
		ProfileMenu.click();
		logOutBtn.click();
	}
	
}
