package com.testng.pac;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Priority123
{

	@Test()
	public void  buysimcard() {
		System.out.println("Buy sim card");
			Assert.assertFalse(true);
	}

	@Test()
	public void activatesimcard() {
		System.out.println("Sim Activated");

	}



	@Test(enabled = true)
	public void customersupport() {
		System.out.println("Customer care");
		Assert.assertFalse(true);

	}
	@Test
	public void ss() {
		System.out.println("new method");
	}


}
