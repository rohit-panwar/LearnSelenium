package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChatPopupHandle {
	
	@Test
	public void closeChatPopup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--start-maximized");
		WebDriver driver= new ChromeDriver(option);
		
		/*driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("naveenk");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@123");*/
		
		driver.get("https://www.onlinesbi.com/");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='payjo-preview-item']")).click();
		driver.findElement(By.xpath("//div[@class='payjo-image-container close']")).click();
	}

}
