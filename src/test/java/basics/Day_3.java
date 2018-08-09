package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day_3 {

	// Learn differnt locatator technique
	@Test
	public void locatorTechnique() throws InterruptedException {
		
		System.setProperty("webdriver.ie.driver", "D:\\Webdriver\\drivers\\IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		
		driver.get("http://test1.absofttrainings.com/");
		
		// 1. Search using LinkText
		driver.findElement(By.linkText("My Account")).click();
		
		Thread.sleep(2000);
		// 2. Search using "id" 
		driver.findElement(By.id("username")).sendKeys("testuser2");
		
		// 3. Search using "name"
		driver.findElement(By.name("password")).sendKeys("testpwd2");
		
		// 4. Search using "Class"
		driver.findElement(By.className("button")).click();
		
		// 5. Search using CSSSelector
		System.out.println(driver.findElement(By.cssSelector("#et-info-phone")).getText());
		System.out.println(driver.findElement(By.cssSelector(".myaccount_user")).getText());
		
		// 6. Search using PArtial link text
		driver.findElement(By.partialLinkText("Shop")).click();
		
		// how to fetch value from dropdown
		Select s= new Select(driver.findElement(By.name("orderby")));
		s.selectByIndex(2);
		
	}
	
	@Test
	public void browseAttachment() {
		System.setProperty("webdriver.ie.driver", "D:\\Webdriver\\drivers\\IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\Rohit\\Desktop\\seleniumAttachment.txt");
	}
}
