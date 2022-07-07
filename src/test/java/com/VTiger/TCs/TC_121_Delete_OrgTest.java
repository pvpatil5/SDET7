package com.VTiger.TCs;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_121_Delete_OrgTest {

	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
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
		driver.manage().window().maximize();
		driver.get(prop.readDatafromPropfile("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 5 : Login to Application 
		driver.findElement(By.name("user_name")).sendKeys(prop.readDatafromPropfile("username"),Keys.TAB,prop.readDatafromPropfile("password"));
		driver.findElement(By.id("submitButton")).click();

		//Step 6 : Actual TC
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);
		WebElement drop_d = driver.findElement(By.xpath("//select [@id='bas_searchfield']"));
		Select s = new Select(drop_d);
		s.selectByVisibleText("Organization Name");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		Alert a1 = driver.switchTo().alert();
		a1.accept();

		Thread.sleep(3000);
		driver.findElement(By.name("submit")).click();

		boolean value=driver.findElement(By.xpath("//span[normalize-space()='No Organization Found !']")).isDisplayed();

		if(value==true) {
			System.out.println("TC Pass");
		}
		else
		{
			System.out.println("TC fail");
		}

		//Step  : Logout and close the browser
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(7000);
		driver.close();

	}
}
