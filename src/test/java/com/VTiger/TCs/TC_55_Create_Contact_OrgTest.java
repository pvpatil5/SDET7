package com.VTiger.TCs;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

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
public class TC_55_Create_Contact_OrgTest {

	public static WebDriver driver;

	@Test
	public void createcontactwithorg() throws IOException, InterruptedException {

		//Step 1 : Getting the Data reqd for TC
		FakeData fakeData = new FakeData();
		String firstname = fakeData.firstName();
		String lastname = fakeData.lastname();

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
		driver.findElement(By.xpath("//td[@class='tabUnSelected'][4]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
		WebElement list = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select s=new Select(list);
		s.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		String mainid = driver.getWindowHandle();
		Set<String> Allid = driver.getWindowHandles();
		for(String i:Allid) {
			if(!mainid.equals(i))  {
				driver.switchTo().window(i);
			}
		}
		WebElement org=driver.findElement(By.xpath("//input[@name='search_text']"));
		org.sendKeys("Mango");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();

		driver.findElement(By.xpath("//a[text()='MANGO']")).click();
		driver.switchTo().window(mainid);

		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		WebElement s1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		String compare = s1.getText();

		if(compare.contains(firstname)) {
			System.out.println("organization is added and verified");
		}

		//Step : Logout from Application and Close Browser

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement ele1=driver.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1);
		ele1.click();
		Thread.sleep(7000);
		driver.close();
	}

}


