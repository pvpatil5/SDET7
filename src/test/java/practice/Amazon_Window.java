package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Window {

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

		driver.findElement(By.xpath("//span[normalize-space()='OnePlus Nord CE 2 Lite 5G (Black Dusk, 6GB RAM, 128GB Storage)']")).click();

		String page1title=driver.getTitle();

		System.out.println(page1title);

		Set<String> windowids = driver.getWindowHandles();

		Iterator<String> it = windowids.iterator();

		String window1=it.next();
		String window2=it.next();

		driver.switchTo().window(window2);
		String str=	driver.findElement(By.id("productTitle")).getText();
		System.out.println(str);
		System.out.println(driver.getTitle());

		String price = driver.findElement(By.xpath("//span[normalize-space()='OnePlus Nord CE 2 Lite 5G (Black Dusk, 6GB RAM, 128GB Storage)']/ancestor::div[@id='centerCol']//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText();
		System.out.println(price);

	}

}
