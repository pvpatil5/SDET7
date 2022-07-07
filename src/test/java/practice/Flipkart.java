package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	static WebDriver driver;

	public static WebElement element(String xpath)
	{
		return	driver.findElement(By.xpath(xpath));
	}
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://flipkart.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		element("//button[@class='_2KpZ6l _2doB4z']").click();

		element("//input[@name='q']").sendKeys("Iphone 13",Keys.ENTER);
		
		WebElement ele= driver.findElement(By.xpath(""));

		String mobilename=element("//div[@class='_1YokD2 _3Mn1Gg']/child::div[@class='_1AtVbE col-12-12'][1]//div[@class='_4rR01T']").getText();

		String price =element("//div[@class='_1YokD2 _3Mn1Gg']/child::div[@class='_1AtVbE col-12-12'][1]//div[@class='_30jeq3 _1_WHN1']").getText();

		System.out.println(mobilename +"--> "+price);

		element("//div[@class='_1YokD2 _3Mn1Gg']/child::div[@class='_1AtVbE col-12-12'][1]//div[@class='_4rR01T']").click();

		Set<String> winids = driver.getWindowHandles();

		Iterator<String> it = winids.iterator();

		String parent=	it.next();
		String child=	it.next();

		driver.switchTo().window(child);

		element("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']").click();

		Thread.sleep(2000);

		WebElement plusbtn=element("//button[@class='_23FHuj' and text()='+']");

		Actions action = new Actions(driver);
		action.moveToElement(plusbtn).build().perform();

		Thread.sleep(1000);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView();", plusbtn);

		Thread.sleep(1000);
		plusbtn.click();

		Thread.sleep(2000);
		String finalprice=element("//div[text()='Total Amount']/ancestor::div[@class='Ob17DV']//div/span").getText();

		System.out.println(finalprice);
	}

}
