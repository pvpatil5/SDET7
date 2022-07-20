package com.testng.pac;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListnersImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TC Pass");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("TC fail");

		TakesScreenshot ts = (TakesScreenshot)Annotation_2.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String pathofscreenshot="../SDET7/screenshots/"+result.getMethod().getMethodName()+".png";
		File dest = new File(pathofscreenshot);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("TC Skip");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("On Start");

	}

	public void onFinish(ITestContext context) {
		System.out.println("At last");

	}


}
