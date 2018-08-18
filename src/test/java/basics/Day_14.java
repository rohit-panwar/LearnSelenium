package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_14 {

	@Test
	public void dynamicGoogleSearch() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(
				"http://www.espncricinfo.com/series/8039/scorecard/433606/india-vs-sri-lanka-final-icc-cricket-world-cup-2010-11");
		System.out.println(driver.findElement(By.id("gp-inning-00/descendant::div[@class='wrap batsmen']")));
	}
}
