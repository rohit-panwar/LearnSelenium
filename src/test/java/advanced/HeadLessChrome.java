package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadLessChrome {
	
	@Test
	public void headLessTesting() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("window-size=1400,800");
		option.addArguments("headless");
		
		WebDriver driver= new ChromeDriver(option);
		
		driver.get("http://test1.absofttrainings.com/my-account/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testuser2");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("testpwd2");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//Thread.sleep(5000);
		System.out.println(driver.getTitle());
	}
	

}
