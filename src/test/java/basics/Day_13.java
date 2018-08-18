package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_13 {

	@Test
	public void elementVisibility() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.freecrm.com/register/");
		
		// To check that element is available on screen
		System.out.println("Display property: "+driver.findElement(By.id("submitButton")).isDisplayed());
		
		// To check redio button/checkbox is selected or not
		WebElement check=driver.findElement(By.name("agreeTerms"));
		System.out.println("Selected property: "+check.isSelected());
		
		check.click();
		System.out.println("Selected property: "+check.isSelected());
		
		// To check element is enable or not
		System.out.println("Enabled property: "+driver.findElement(By.id("submitButton")).isEnabled());
		
		check.click();
		System.out.println("Enabled property: "+driver.findElement(By.id("submitButton")).isEnabled());
		
		driver.quit();
	}
}
