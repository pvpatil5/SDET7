package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {

	WebDriver driver;

	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="accountname")
	private WebElement orgnametxtbox;


	public WebElement getOrgnametxtbox() {
		return orgnametxtbox;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
}
