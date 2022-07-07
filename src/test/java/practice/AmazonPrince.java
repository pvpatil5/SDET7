package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPrince {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://amazon.in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobiles under 20000");

		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='OnePlus']")).click();

		Thread.sleep(2000);

	}

}
