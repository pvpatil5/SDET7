package practice;

import java.io.IOException;

import org.testng.annotations.Test;

import com.VTiger.generic.PropertyFile;

public class Sample 
{
	PropertyFile prop = PropertyFile.getObjectPropfile();

	@Test
	public void test1() throws IOException {

		System.out.println(prop.readDatafromPropfile("browser"));

	}

	@Test
	public void test2() throws IOException {

		System.out.println(prop.readDatafromPropfile("username"));
	}

	@Test
	public void test3() throws IOException {

		System.out.println(prop.readDatafromPropfile("password"));
	}


}
