package com.VTiger.TCs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepo.CreateOrgPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OrganizationsInfoPage;
import com.VTiger.generic.FakeData;
import com.VTiger.generic.PropertyFile;
import com.VTiger.generic.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_101_Create_orgTest {
	public  WebDriver driver;

	@Test
	public void createOrgz() throws Throwable {


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


		//Step 5 : Login to Application 
		LoginPage loginPage= new LoginPage(driver);
		loginPage.getUsernametextbox().sendKeys(prop.readDatafromPropfile("username"));
		loginPage.getPasswordtextbox().sendKeys(prop.readDatafromPropfile("password"));
		loginPage.getLoginbtn().click();


		//Step 6 : Actual TC
		HomePage homePage = new HomePage(driver);
		WebElement orglink = homePage.getOrglinkbtn();
		driverUtil.waitankclick(orglink);

		OrganizationsInfoPage organizationsInfoPage = new OrganizationsInfoPage(driver);
		organizationsInfoPage.getCreateorglinkbtn().click();

		CreateOrgPage createOrgPage = new CreateOrgPage(driver);
		createOrgPage.getOrgnametxtbox().sendKeys(orgname);
		createOrgPage.getSavebtn().click();
		Thread.sleep(2000);

		homePage.getOrglinkbtn().click();

		organizationsInfoPage.getSearchorgtxtbox().sendKeys(orgname);
		driverUtil.selectDD(organizationsInfoPage.getSelectorgtypeDD(), "accountname");
		organizationsInfoPage.getSearchorgbtn().click();


		Thread.sleep(2500);
		driverUtil.refreshPage();
		String actualorgname=organizationsInfoPage.getSearchedorgname().getText();
		
		Assert.assertEquals(actualorgname, orgname);

		//Step : Logout and close the driver
		Thread.sleep(2000);
		homePage.getSignoutimg().click();

		driverUtil.moveToelement(homePage.getSignoutimg());
		driverUtil.waitankclick(homePage.getSignoutlink());
		Thread.sleep(5000);
		driver.close();


	}

}
