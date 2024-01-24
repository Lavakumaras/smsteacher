package com.elementRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherMySubjectPage {

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTxt;

	public TeacherMySubjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
	
	public void verifyTheSbuject(String SUBJECT, WebDriver driver) {
		searchTxt.sendKeys(SUBJECT);
		String Subject = driver.findElement(By.xpath("//td[text()='" + SUBJECT + "']")).getText();
		if (SUBJECT.contains(Subject)) {
			System.out.println("subject added successfully");
		} else {
			System.out.println("fail to add subject");
		}
		
	}
}
