package com.testng.pac;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_MMT {

	@Test(dataProvider = "getValue")
	public void test1(String src,String dest) throws InterruptedException, EncryptedDocumentException, IOException {

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
		System.out.println(src +" --> "+ dest);

		driver.findElement(By.id("fromCity")).sendKeys(src);
		driver.findElement(By.xpath("//div[.='"+src+"']")).click();

		driver.findElement(By.id("toCity")).sendKeys(dest);
		driver.findElement(By.xpath("//div[.='"+dest+"']")).click();


		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();

		driver.findElement(By.xpath("//div[@aria-label='Sat Jul 16 2022']")).click();

		Thread.sleep(3000);
	}
	@DataProvider
	public Object[][] getValue() 
	{
		Object [][] arr = new Object [5][2];

		arr [0][0]="DEL";
		arr [0] [1]="HYD";

		arr [1][0]="BOM";
		arr [1][1]="MAA";

		arr [2][0]="GOI";
		arr [2][1]="NYC";

		arr [3][0]="BOM";
		arr [3][1]="HYD";

		arr [4][0]="DEL";
		arr [4][1]="PNQ";

		return arr;
	}
}
