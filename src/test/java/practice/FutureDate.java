package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FutureDate {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		for (int i = 0; i < 11; i++) 
		{
			try {
				driver.findElement(By.xpath("//div[@aria-label=\"Mon Nov 07 2022\"]")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}
}
