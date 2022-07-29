package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day_3 {

	// Learn differnt locatator technique
	@Test
	public void locatorTechnique() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
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
		// Id #
		// Class .
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector("#et-info-email")).getText());
		System.out.println(driver.findElement(By.cssSelector(".myaccount_user")).getText());
		
		// 6. Search using PArtial link text
		driver.findElement(By.partialLinkText("Shop")).click();
		
		// how to fetch value from dropdown
		Select sorting= new Select(driver.findElement(By.name("orderby")));
		sorting.selectByIndex(2);
		Thread.sleep(5000);
		
		sorting= new Select(driver.findElement(By.name("orderby")));
		sorting.selectByValue("price-desc");
		Thread.sleep(5000);
		
		sorting= new Select(driver.findElement(By.name("orderby")));
		sorting.selectByVisibleText("Sort by popularity");
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void browseAttachment() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//<input type="file" name="fileupload" value="fileupload" id="fileupload">
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("fileupload")).sendKeys(System.getProperty("user.dir") +"\\src\\test\\java\\dataDriven\\seleniumAttachment.txt");
	}
}
