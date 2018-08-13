package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_6 {

	@Test
	public void dynamicXpath() {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://test1.absofttrainings.com/my-account/");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("testuser1");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("test@123");

		driver.findElement(By.xpath("//input[contains(@name,'user')]")).sendKeys("testuser2");
		driver.findElement(By.xpath("//input[starts-with(@name,'user')]")).sendKeys("testuser3");
		// driver.findElement(By.xpath("//input[ends-with(@name,'username')]")).sendKeys("testuser4");

		// To find hyperlink
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
	}

	@Test
	public void findAllLinks() {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://test1.absofttrainings.com/");

		List<WebElement> allLink = driver.findElements(By.tagName("a"));
		System.out.println("Total Links available on this page is:" + allLink.size());

		for (int i = 0; i < allLink.size(); i++) {
			if (allLink.get(i).getText().isEmpty())
				System.out.println("Sr.No.#" + i + " BLANK");
			else
				System.out.println("Sr.No.#" + i + " " + allLink.get(i).getText());
		}
	}

}
