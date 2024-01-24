package com.elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAllTeacherPage {

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchTxt;

	@FindBy(xpath = "//select[@name='example1_length']")
	private WebElement showresultDropdwn;

	public AdminAllTeacherPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getShowresultDropdwn() {
		return showresultDropdwn;
	}
}
