package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Day_2 {
	
	@Test
	public void launchSafari() {
		WebDriver driver = new SafariDriver();
		driver.get("https://google.com");
	}

}
