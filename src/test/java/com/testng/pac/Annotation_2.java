package com.testng.pac;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(ListnersImplementation.class)
public class Annotation_2  {
	public 	static WebDriver driver;

	@Test(retryAnalyzer=RetryAnalyzer_1.class,groups = "regression")
	public void facebook() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://facebook.com");
		String actualURL=driver.getCurrentUrl();
		assertEquals(actualURL, "https://facebook.com");


	}

	@Test(retryAnalyzer=RetryAnalyzer_1.class,groups= {"smoke","regression"})
	public void amazon() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://amazon.in");
		String actualURL=driver.getCurrentUrl();
		assertEquals(actualURL, "https://www.amazon.in/");

	}



}
