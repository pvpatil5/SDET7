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
import org.testng.annotations.Test;

import com.VTiger.generic.FakeData;
import com.VTiger.generic.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TC_151_Create_Campaign_Del_CampTest
{
	public static WebDriver driver;

	@Test
	public void createcamp() throws Throwable {

		//Step 1 : Getting the Data reqd for TC
		FakeData fakeData = new FakeData();
		String campname = fakeData.companyname();

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
		WebElement move=driver.findElement(By.xpath("//a[text()='More']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(move).perform();
		
		driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campname);
		
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	
		driver.findElement(By.xpath("(//a[text()='Campaigns'])[1]")).click();
	
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(campname);

		WebElement camtype=driver.findElement(By.xpath("//select[@id='bas_searchfield']"));

		Select sl=new Select(camtype);
		sl.selectByValue("campaignname");

		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		driver.findElement(By.xpath("//input[@name='selected_id']")).click();

		driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();

		Alert al=driver.switchTo().alert();
		al.accept();
		

		// Logout from Application and close the browser
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		ac.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(5000);
		driver.close();	

	}

}
