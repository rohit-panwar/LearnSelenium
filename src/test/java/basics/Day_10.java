package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class Day_10 {
	
	@Test
	public void htmlUnitDriver() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		//WebDriver driver = new ChromeDriver();
		WebDriver driver= new HtmlUnitDriver();
		
		driver.get("http://test1.absofttrainings.com");
		System.out.println("Home Page Title:"+driver.getTitle());

		driver.findElement(By.linkText("My Account")).click();
		System.out.println("My Accout Title:"+driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testuser2");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("testpwd2");

		// To Click Login hyperlink
		driver.findElement(By.name("login")).click();
		System.out.println("After Login:"+driver.getTitle());
	}
	

}
