package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherDashBoardPage {

	@FindBy(xpath = "//span[text()='Subject']")
	private WebElement subject;

	@FindBy(xpath = "//a[text()=' My Subject']")
	private WebElement mySubject;

	@FindBy(xpath = "//a[text()=' All Subject']")
	private WebElement allSubject;

	@FindBy(xpath = "//span[text()='Timetable']")
	private WebElement timetable;

	@FindBy(xpath = "//a[text()=' My Timetable']")
	private WebElement mytimeTable;
	
	@FindBy(xpath = "//img[@class='user-image']")
	private WebElement ProfileMenu;

	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement logOutBtn;

	public TeacherDashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getMySubject() {
		return mySubject;
	}

	public WebElement getAllSubject() {
		return allSubject;
	}

	public WebElement getTimetable() {
		return timetable;
	}

	public WebElement getMytimeTable() {
		return mytimeTable;
	}
	public WebElement getProfileMenu() {
		return ProfileMenu;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	
	public void teacherLogOut() throws Throwable {
		Thread.sleep(3000);
		ProfileMenu.click();
		logOutBtn.click();
	}
}
