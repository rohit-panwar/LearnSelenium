package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_8 {
	
	@Test
	public void windowHandlers() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//Launch the home page
		driver.get("http://popuptest.com/goodpopups.html");
		System.out.println(driver.getTitle());
		
		// Click on popup link
		driver.findElement(By.linkText("Good PopUp #2")).click();
		System.out.println(driver.getTitle());
		
		// Store all window in handler
		Set<String> handler= driver.getWindowHandles();
		Iterator<String> it= handler.iterator();
		
		// Store the window id of home screen
		String parentWindowId=it.next();
		System.out.println("Parent Window: "+parentWindowId);
		
		// Store the window id of child screen
		String childWindowId=it.next();
		System.out.println("Child Window:"+childWindowId);
		
		// Switch to child window
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle());
		
		// Close only child window
		driver.close();
		
		// Switch to Parent window
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		
		// Close parent window
		driver.close();
	}
	
	@Test
	public void filePopup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//Launch the home page
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\Rohit\\Desktop\\seleniumAttachment.txt");
		//driver.findElement(By.xpath("//input[@value='submit']")).click();
	}
}
