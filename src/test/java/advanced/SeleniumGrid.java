package advanced;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid {
	
	@Test
	public void grid() throws MalformedURLException {
		
		// 1. Define desire Capabilities
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.WIN8_1);
		
		String urls="http://192.168.43.92:4444/wd/hub";
		WebDriver driver= new RemoteWebDriver(new URL(urls),cap);
		driver.get("https://www.google.com/");
	}

}
