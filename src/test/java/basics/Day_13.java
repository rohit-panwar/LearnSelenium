package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_13 {

	@Test
	public void elementVisibility() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://register.freecrm.com/register/");

		// To check that element is available on screen
		System.out.println("Display property: " + driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());

		// To check radio button/check box is selected or not
		WebElement check = driver.findElement(By.xpath("//input[@name='terms']"));
		System.out.println("Selected property: " + check.isSelected());

		check.click();
		System.out.println("Selected property: " + check.isSelected());

		// To check element is enable or not
		driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_pushbutton_disabled2");
		driver.switchTo().frame("iframeResult");
		System.out.println("Enabled property: " + driver.findElement(By.id("myBtn")).isEnabled());

		driver.findElement(By.xpath("//button[@id='myBtn']/following-sibling::button")).click();
		System.out.println("Enabled property: " + driver.findElement(By.id("myBtn")).isEnabled());

		driver.quit();
	}
}
