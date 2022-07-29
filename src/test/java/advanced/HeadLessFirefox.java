package advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadLessFirefox {
	
	@Test
	public void launchFirefoxAsHeadless() {
		
		FirefoxBinary firefoxBinary= new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		
		FirefoxOptions options= new FirefoxOptions();
		options.setBinary(firefoxBinary);
		
		WebDriver driver= new FirefoxDriver(options);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
	}

}
