package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class AdminSubjectRoutingPage extends WebDriverUtils {
	
@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']")
private WebElement addLookUpImg;

public WebElement getAddLookUpImg() {
	return addLookUpImg;
}

@FindBy(id = "grade")
private WebElement gradeDropdwn;

@FindBy(id = "subject")
private WebElement subjectDropdwn;

@FindBy(id = "teacher")
private WebElement teacherDropdwn;

@FindBy(id = "fee")
private WebElement feeTxt;

@FindBy(id = "btnSubmit")
private WebElement submitBtn;


public AdminSubjectRoutingPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void AddSubject(String grade, String subject, String teacher, String fee) {

	selectDropDown(grade, gradeDropdwn);
	selectDropDown(subject, subjectDropdwn);
	selectDropDown(teacher, teacherDropdwn);
	feeTxt.sendKeys(fee);
	submitBtn.click();
}





}
