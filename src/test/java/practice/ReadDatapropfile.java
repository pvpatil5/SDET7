package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDatapropfile {

	public static void main(String[] args) throws IOException {

		WebDriver driver = null;
		FileInputStream fis= new FileInputStream("../SDET7/SDET7.PROPERTIES");

		Properties prop = new Properties();
		prop.load(fis);

		String BROWSER=prop.getProperty("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = WebDriverManager.chromedriver().create();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			driver = WebDriverManager.firefoxdriver().create();	
		}
		else
		{
			System.out.println("Give Proper Browser input");	
		}

		driver.get(prop.getProperty("url"));



	}

}
