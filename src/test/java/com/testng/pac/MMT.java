package com.testng.pac;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.VTiger.generic.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMT {


	@Test
	public void test1() throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelUtility excelUtility = new ExcelUtility();
		int lastrowcount=	excelUtility.getLastRowcount("../SDET7/SDET7.xlsx", "Sheet2");

		String src=null;
		String dest=null;

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("disable-infobars");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.switchTo().frame("notification-frame-~19713b227");
		driver.findElement(By.xpath("//a[@class='close']")).click();

		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		for (int i = 1; i <= lastrowcount; i++) {



			src = excelUtility.readDataFromExcel("../SDET7/SDET7.xlsx", "Sheet2", i, 0);
			dest = excelUtility.readDataFromExcel("../SDET7/SDET7.xlsx", "Sheet2", i, 1);
			System.out.println(src +" --> "+ dest);
			
			driver.findElement(By.id("fromCity")).sendKeys(src);
			driver.findElement(By.xpath("//div[.='"+src+"']")).click();

			driver.findElement(By.id("toCity")).sendKeys(dest);
			driver.findElement(By.xpath("//div[.='"+dest+"']")).click();


			driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();

			driver.findElement(By.xpath("//div[@aria-label='Sat Jul 16 2022']")).click();
		}
	}
}
