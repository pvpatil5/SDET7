package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {

		WebDriver driver =	WebDriverManager.firefoxdriver().create();

		driver.get("https://amazon.in");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		driver.manage().window().maximize();

		
		driver.findElement(By.xpath("some")).click();
		

	}

}
