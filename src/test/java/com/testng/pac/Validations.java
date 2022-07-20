package com.testng.pac;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Validations 
{

	@Test
	public void login() {

		System.out.println("Lainch browser");

		System.out.println("enter URL");

		SoftAssert softAssert = new SoftAssert();

		softAssert.assertEquals(false, true);
		

		//Assert.assertEquals(true,false);

		System.out.println("Login page should display");

		System.out.println("Enter Username");

		System.out.println("Enter PAssword");

		System.out.println("click to login btn");

		System.out.println("Home page should display");

		String actualtitle="get Title";

		String expectedtitle="get Tile";

		softAssert.assertAll();
		
		Assert.assertEquals(actualtitle,expectedtitle);
		
	}






}
