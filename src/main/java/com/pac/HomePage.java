package com.pac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	//WebDriver driver;
	String menulink="//a[text()='%s']";

	public WebElement newxpath(WebDriver driver,String name) {
		String newxpath=String.format(menulink, name);
		return HomePage.element(driver, newxpath);
		
	}

	public static WebElement element(WebDriver driver, String str) {
		return driver.findElement(By.xpath(str));
	}



}

