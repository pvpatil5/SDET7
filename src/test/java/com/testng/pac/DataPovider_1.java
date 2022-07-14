package com.testng.pac;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPovider_1 
{

	@Test(dataProvider = "getValue")
	
	public void testMMT(String src, String dest) {

		System.out.println(src+" --> "+dest);
	}

	@DataProvider
	public Object[][] getValue() 
	{
		Object [][] arr = new Object [5][2];

		arr [0][0]="del";
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
