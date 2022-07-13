package com.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPAge2 
{
	WebDriver driver;

//	public LoginPAge2(WebDriver driver)
//	{
//		this.driver=driver;
//		//PageFactory.initElements(driver, LoginPAge2.class);
//	}

	private WebElement usernametxtfld=driver.findElement(By.name("user_name"));
	private	WebElement passwordtxtfld=driver.findElement(By.xpath("//input[@name='user_password']"));

	public WebElement getUsernametxtfld(WebDriver driver) {
		return usernametxtfld;
	}
	public WebElement getPasswordtxtfld() {
		return passwordtxtfld;
	}

	private WebElement loginbtn=driver.findElement(By.id("submitButton"));
	public WebElement getloginbtn() {
		return loginbtn;
	}
}
