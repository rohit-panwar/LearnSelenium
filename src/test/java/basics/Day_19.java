package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_19 {

	@Test
	public void bootStrapDropDown1() {
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
	
	@Test
	public void bootStrapDropDown2() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://v4-alpha.getbootstrap.com/components/dropdowns/");
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		
		List<WebElement> list2= driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu')]//a"));
		
		System.out.println("Total Element: "+list2.size());
		for(int i=0; i<list2.size();i++) {
			System.out.println(list2.get(i).getText());
		}
	}
}
