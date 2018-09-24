package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Day_4 {
	
	@Test
	public void alertTest() {
		
		System.setProperty("webdriver.ie.driver", "D:\\Webdriver\\drivers\\IEDriverServer.exe");
		WebDriver driver= new InternetExplorerDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		Alert a= driver.switchTo().alert();
		a.accept();
	
		//a.dismiss();
	}

	
}
