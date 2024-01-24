package com.elementRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentMyProfilePage {

	@FindBy(xpath="//a[@id='btnEdit']")
	private WebElement editBtn;

	@FindBy(xpath="//input[@id='full_name1']")
	private WebElement fullNameTxt;
	
	@FindBy(xpath="//button[@id='btnUpdate']")
	private WebElement updateBtn;

	public ParentMyProfilePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	public WebElement getFullNameTxt() {
		
		return fullNameTxt;
	}

	public void validateUpdateMyProfileByName(WebDriver driver, String parentName) {
		String updatedname = driver.findElement(By.xpath("//td[text()='" + parentName + "']")).getText();
		if (updatedname.contains(parentName)) {
			System.out.println("Update Parent Profile name successfully");
		} else {
			System.out.println("fail to update the profile ");
		}

	}
}
