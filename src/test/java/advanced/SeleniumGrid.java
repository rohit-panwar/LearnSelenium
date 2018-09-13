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
//java -jar selenium-server-standalone-3.14.0.jar -role hub

//java -Dwebdriver.gecko.driver="D:\\Webdriver\\drivers\\geckodriver.exe" -jar selenium-server-standalone-3.14.0.jar -role node -hub http://localhost:4444/register