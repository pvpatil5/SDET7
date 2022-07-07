package com.VTiger.TCs;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.VTiger.generic.FakeData;
import com.VTiger.generic.PropertyFile;
import com.VTiger.generic.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_101_Create_orgTest {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		//Step 1 : Getting the Data reqd for TC
		FakeData fakeData = new FakeData();
		String orgname = fakeData.companyname();

		// Step 2 : Reading Prop file for credentials
		PropertyFile prop = PropertyFile.getObjectPropfile();

		// Step 3 : Launching Browser based on Value provided in Property file
		String BROWSER = prop.readDatafromPropfile("browser");
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


		// Step 4 : Launching URL
		WebDriverUtil driverUtil = new WebDriverUtil(driver);
		driverUtil.maximiseWindow();
		driver.get(prop.readDatafromPropfile("url"));
		driverUtil.pageLoadTimeout();


		// Step 5 : Login to Application 
		driver.findElement(By.name("user_name")).sendKeys(prop.readDatafromPropfile("username"),Keys.TAB,prop.readDatafromPropfile("password"));
		driver.findElement(By.id("submitButton")).click();

		//Step 6 : Actual TC
		WebElement orglink = driver.findElement(By.xpath("//a[text()='Organizations']"));
		driverUtil.waitankclick(orglink);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);
		WebElement organization_name = driver.findElement(By.xpath("//select[@name='search_field']"));
		organization_name.click();
		driverUtil.selectDD(organization_name, 1);

		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		Thread.sleep(2500);
		driverUtil.refreshPage();
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();

		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();

		driver.switchTo().alert();
		driverUtil.acceptAlert();


		//Step : Logout and close the driver
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement signout= driver.findElement(By.xpath("//a[text()='Sign Out']"));

		driverUtil.moveToelement(signout);
		driverUtil.waitankclick(signout);
		Thread.sleep(5000);
		driver.close();


	}

}
