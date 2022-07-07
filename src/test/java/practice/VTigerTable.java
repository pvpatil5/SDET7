package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VTigerTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");

		driver.findElement(By.name("user_password")).sendKeys("12345");

		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Organizations']")).click();

		//String name="Lon567";

		//driver.findElement(By.xpath("//table[@class='lvt small']//tr[*]//td[3]/a[text()='"+name+"']/parent::td/parent::tr/td[1]/input")).click();


		List<WebElement> allorgs = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]//td[3]"));

		for (int i = 3; i < allorgs.size(); i++) 
		{
			String orgname=driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[3]")).getText();
			if(orgname.equalsIgnoreCase("Parker252")) 
			{
				System.out.println(i);

				driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[1]/input")).click();
			}

		}

	}

}
