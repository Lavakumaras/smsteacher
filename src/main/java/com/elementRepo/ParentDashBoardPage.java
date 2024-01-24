package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentDashBoardPage {
	@FindBy(xpath="//span[normalize-space()='Profile']")
	private WebElement profileLnk;

	@FindBy(xpath="//a[normalize-space()='My Profile']")
	private WebElement myProfileLnk;
	
	@FindBy(xpath = "//img[@class='user-image']")
	private WebElement ProfileMenu;

	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement logOutBtn;

	public ParentDashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getProfileLnk() {
		return profileLnk;
	}

	public WebElement getMyProfileLnk() {
		return myProfileLnk;
	}
	
	public WebElement getProfileMenu() {
		return ProfileMenu;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}

	
	public void parentLogOut() throws Throwable {
		Thread.sleep(3000);
		ProfileMenu.click();
		logOutBtn.click();
	}
}
