package com.VTiger.TCs;

import java.io.IOException;
import java.time.Duration;
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

public class TC_99_Create_org_DDTest {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		//Step 1 : Getting the Data reqd for TC
		FakeData fakeData = new FakeData();
		String orgname=fakeData.companyname();


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
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys(orgname);


		WebElement	industry_dd=driver.findElement(By.name("industry"));
		WebElement	rating_dd=driver.findElement(By.name("rating"));
		WebElement	accounttype_dd=driver.findElement(By.name("accounttype"));

		Select select_industrydd= new Select(industry_dd);
		select_industrydd.selectByIndex(3);

		Select select_rstingdd= new Select(rating_dd);
		select_rstingdd.selectByVisibleText("Active");

		Select select_accounttypedd = new Select(accounttype_dd);
		select_accounttypedd.selectByValue("Customer");

		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		WebElement searchorg_dd=driver.findElement(By.id("bas_searchfield"));

		Select select_searchorg_dd= new Select(searchorg_dd);
		select_searchorg_dd.selectByValue("accountname");

		driver.findElement(By.name("submit")).click();

		Thread.sleep(6000);

		String actual_orgname=	driver.findElement(By.xpath("//a[@title='Organizations']")).getText();

		System.out.println(actual_orgname);

		System.out.println(orgname);

		if(actual_orgname.equalsIgnoreCase(orgname)){
			System.out.println("TC Pass");
		}

		else
		{
			System.out.println("TC fail");
		}

		//Step : Logout and close the driver
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		WebElement signout= driver.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout);
		signout.click();
		Thread.sleep(5000);
		driver.close();





	}


}
