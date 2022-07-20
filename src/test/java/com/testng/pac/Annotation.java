package com.testng.pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotation 
{
	WebDriver driver;
	@BeforeSuite(groups = {"smoke", "regression"})
	public void beforesuite() {
		System.out.println("Before suite");
	}

	@AfterSuite(groups = {"smoke", "regression"})
	public void aftersuite() {
		System.out.println("after suite");
	}

	@BeforeTest(groups = {"smoke","regression"})
	public void beforetest() {
		System.out.println("before test");
	}
	@AfterTest(groups = {"smoke", "regression"})
	public void afterTest() {
		System.out.println("After test");
	}

	@Parameters("browser")
	@BeforeClass (groups = {"smoke", "regression"})
	public void beforeclass(String BROWSER) {


		//	String BROWSER = prop.readDatafromPropfile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid input");
		}

		System.out.println("before class");
	}

	@AfterClass(groups = {"smoke", "regression"})
	public void afterclass() {
		System.out.println("after class");
	}

	@BeforeMethod(groups = {"smoke", "regression"})
	public void beforemethod() {
		System.out.println("before method");
	}


	@AfterMethod(groups = {"smoke", "regression"})
	public void aftermethod() {
		System.out.println("After method");
	}





}

