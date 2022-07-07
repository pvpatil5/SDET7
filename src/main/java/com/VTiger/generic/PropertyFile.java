package com.VTiger.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	private static PropertyFile prop;
	
	private  PropertyFile () {

	}

	public static PropertyFile getObjectPropfile() {
		return prop= new PropertyFile();
	}





	public String readDatafromPropfile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("../SDET7/SDET7.PROPERTIES");

		Properties prop = new Properties();
		prop.load(fis);

		return	prop.getProperty(key);

	}
	public String readDatafromPropfile(String key, String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);

		Properties prop = new Properties();
		prop.load(fis);

		return	prop.getProperty(key);

	}

}
