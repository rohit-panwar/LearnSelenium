package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_19 {

	@Test
	public void bootStrapDropDown() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

		driver.findElement(By.xpath("//button[contains(@class,'multiselect dropdown')]")).click();

		List<WebElement> list = driver
				.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//li//a//label"));

		System.out.println("Total lists:" + list.size());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).click();
			System.out.println(list.get(i).getText());
		}
	}
}
