package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//rule 1 : page name should be class name
public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//rule 2 : locate elements using @find by and make webelement as private
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglinkbtn;

	public WebElement getOrglinkbtn() {
		return orglinkbtn;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;


	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;
	public WebElement getSignoutimg() {
		return signoutimg;
	}


	public WebElement getSignoutlink() {
		return signoutlink;
	}




}
