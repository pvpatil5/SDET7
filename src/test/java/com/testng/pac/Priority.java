package com.testng.pac;

import org.testng.annotations.Test;

public class Priority 
{

	@Test(priority = 0)
	public void  buysimcard() {
		System.out.println("Buy sim card");

	}

	@Test(priority = 2)
	public void activatesimcard() {
		System.out.println("Sim Activated");
	}



	@Test(priority = -1)
	public void customersupport() {
		System.out.println("Customer care");
	}


}
