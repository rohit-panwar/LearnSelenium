package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_15 {

	@Test
	public void dynamicGoogleSearch() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.id("lst-ib")).sendKeys("India");
		
		Thread.sleep(2000);
		
		List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		
		System.out.println("Total suggestions: "+list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("indian railways")) {
				System.out.println("Search results \"indian railways\" found at "+i+"th position");
				break;
			}
		}
	}
}
