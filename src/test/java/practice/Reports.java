package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports {
	// PAth , set theme, title (look and feel )
	ExtentSparkReporter reporter;

	// attch reports manual inputs
	ExtentReports reports;

	// To create entries in reports
	ExtentTest test;

	@Test
	public void reportCreation() throws IOException
	{
		reporter = new ExtentSparkReporter("../SDET7/SDET7.html");

		reporter.config().setDocumentTitle("Facebook");

		reporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Application Version", "5.0.9");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Env", "QA");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		Assert.assertFalse(true);

		test=reports.createTest("Facebook123");

		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		String path = "../SDET7/screenshots/Facebook.PNG";
		File dest = new File(path);
		FileUtils.copyFile(file, dest);

		test.addScreenCaptureFromPath(path);
		


		reports.flush();

	}



}
