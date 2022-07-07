package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");

		driver.switchTo().frame("iframeResult");

		List<WebElement> rows = driver.findElements(By.xpath("//table//tr[*]"));

		for (int i = 0; i < args.length; i++) {
		String name=	rows.get(i).getText();
		
		if(name.equals("Manual Test")) 
		{
			
		}
		
		}
		
		
//		System.out.println("no. of rows are="+rows.size());
//
//		List<WebElement> columns = driver.findElements(By.xpath("//table//tr[1]//th"));
//
//		System.out.println("no. of rows are="+columns.size());
//
//		System.out.println(driver.findElement(By.xpath("//table")).getText());


	}

}
