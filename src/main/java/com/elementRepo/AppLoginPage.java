package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.Fileutils;

public class AppLoginPage {

	@FindBy(id = "email")
	private WebElement untext;

	@FindBy(id = "password")
	private WebElement pwdTxt;

	@FindBy(id = "btnSubmit")
	private WebElement loginBtn;

	public AppLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getuntext(String un) {
		untext.sendKeys(un);
	}

	public void getpwdTxt(String pwd) {
		pwdTxt.sendKeys(pwd);
	}

	public void getLoginBtn() {
		loginBtn.click();
	}


	public void LoginAsAdmin() {
		Fileutils fileutil = new Fileutils();

		try {
			untext.sendKeys(fileutil.readDataFromPropertyFile("adminusername"));
			pwdTxt.sendKeys(fileutil.readDataFromPropertyFile("loginpassword"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loginBtn.click();
	}



	public void LoginAsTeacher() {
		Fileutils fileutil = new Fileutils();

		try {
			untext.sendKeys(fileutil.readDataFromPropertyFile("teacherusername"));
			pwdTxt.sendKeys(fileutil.readDataFromPropertyFile("loginpassword"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loginBtn.click();
	}
	public void LoginAsParent() {
		Fileutils fileutil = new Fileutils();

		try {
			untext.sendKeys(fileutil.readDataFromPropertyFile("parentusername"));
			pwdTxt.sendKeys(fileutil.readDataFromPropertyFile("loginpassword"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loginBtn.click();
	}
}
