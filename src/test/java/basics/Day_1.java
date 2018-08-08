package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Day_1 {

	@Test
	public void launchFirefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Webdriver\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.seleniumhq.org/download/");
		
	}
}
