package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Day_4 {

	@Test
<<<<<<< HEAD
	public void alertTest() {

		System.setProperty("webdriver.ie.driver", "D:\\Webdriver\\drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
=======
	public void alertTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
>>>>>>> d6edd99e2e17688388f14af192a390fb48a5f060

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

		driver.findElement(By.name("proceed")).click();
		Alert a = driver.switchTo().alert();
<<<<<<< HEAD
		a.accept();

		// a.dismiss();
	}
=======
		System.out.println(a.getText());
		Thread.sleep(2000);
		a.accept();

		// a.dismiss();
		driver.close();
	}

	@Test
	public void allAlertTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		driver.findElement(By.xpath("(//div[text()='Java Script Alert Box']/following-sibling::div/button)[1]")).click();
		Alert a= driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("1st ALERT TEXT: "+a.getText());
		a.accept();
		
		driver.findElement(By.xpath("(//div[text()='Java Script Confirm Box']/following-sibling::div/button)[1]")).click();
		Alert b= driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("2nd ALERT TEXT: "+b.getText());
		b.dismiss();
		
		driver.findElement(By.xpath("(//div[text()='Java Script Alert Box']/following-sibling::div/button)[2]")).click();
		Alert c= driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("3rd ALERT TEXT: "+c.getText());
		c.sendKeys("Rohit");
		c.accept();
		
		driver.quit();
	}

>>>>>>> d6edd99e2e17688388f14af192a390fb48a5f060
}
