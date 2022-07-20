package com.testng.pac;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer_1  implements IRetryAnalyzer
{
	int count =0;
	int rerun =3;

	public boolean retry(ITestResult result) {

		if (count<rerun) 
		{
			count++;
			return true;
		}

		return false;
	}

}
