package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChatPopupHandle {
	
	@Test
	public void closeChatPopup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.revechat.com/");
		
		Thread.sleep(10000);
		driver.findElement(By.id("txt2")).click();
		Thread.sleep(5000);
		driver.findElement(By.className("icons minimize_button")).click();
	}

}
