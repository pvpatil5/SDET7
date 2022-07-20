package com.testng.pac;

import org.testng.annotations.Test;

public class Annotation_1 extends Annotation  {


	//@Parameters("PASSWORD")
	@Test(groups = "smoke")
	public void Annotation_1test1() {
		//System.out.println(password);
		System.out.println(" @Test Executing Annotation_1test1");

	}

	@Test(groups="regression")
	public void Annotation_2test2() {
		System.out.println(" @Test Executing Annotation_1test2");
	}

}
