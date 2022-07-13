package com.pac;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	WebDriver driver;

	@Test
	public void test() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();

		driver.get("http://localhost:8888");

		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"12345");
		driver.findElement(By.id("submitButton")).click();

		HomePage homePage= new HomePage();
		WebElement contactslink = homePage.newxpath(driver, "Contacts");
		contactslink.click();

	}
}
