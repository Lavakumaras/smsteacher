package com.elementRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.ExcelUtils;

public class AdminAddTeacherPage {

	@FindBy(id = "index_number")
	private WebElement techerIndexNumTxt;

	@FindBy(id = "full_name")
	private WebElement teacherFullNameTxt;

	@FindBy(id = "i_name")
	private WebElement teacherFullNameWithInitialTxt;

	@FindBy(id = "address")
	private WebElement teacheraddresstxt;

	@FindBy(id = "gender")
	private WebElement teacherGenderDropdown;

	@FindBy(id = "phone")
	private WebElement teacherPhNumTxt;

	@FindBy(id = "email")
	private WebElement teacherEmailTxt;

	@FindBy(id = "fileToUpload")
	private WebElement teacherphotoUploadBtn;

	@FindBy(id = "btnSubmit")
	private WebElement submitBtn;

	public AdminAddTeacherPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTecherIndexNumTxt() {
		return techerIndexNumTxt;
	}

	public WebElement getTeacherFullNameTxt() {
		return teacherFullNameTxt;
	}

	public WebElement getTeacherFullNameWithInitialTxt() {
		return teacherFullNameWithInitialTxt;
	}

	public WebElement getTeacheraddresstxt() {
		return teacheraddresstxt;
	}

	public WebElement getTeacherGenderDropdown() {
		return teacherGenderDropdown;
	}

	public WebElement getTeacherPhNumTxt() {
		return teacherPhNumTxt;
	}

	public WebElement getTeacherEmailTxt() {
		return teacherEmailTxt;
	}

	public WebElement getTeacherphotoUploadBtn() {
		return teacherphotoUploadBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void hashmapdata(ExcelUtils excelutil, String SheetName, int cellNo, WebDriver driver) throws Throwable {
		HashMap<String, String> map = excelutil.hashMapData(SheetName, cellNo);

		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.id(set.getKey())).sendKeys(set.getValue());
		}
	}
}