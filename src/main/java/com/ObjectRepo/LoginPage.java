package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


//Rule 1 Class name should be page name
public class LoginPage {

	WebDriver driver;
	//rule 3: Create constructor for initilizing Page elements
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	//rule 2 = Locate all the web element with @findby annotation
	@FindBy(name="user_name")
	private	WebElement usernametextbox;

	@FindBy(xpath="//input[@name='user_password']")
	private	WebElement passwordtextbox;

	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	
	//Rule 4 : Create Getters for accessing webelements 
	
	public WebElement getUsernametextbox() {
		return usernametextbox;
	}

	public WebElement getPasswordtextbox() {
		return passwordtextbox;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}


}
