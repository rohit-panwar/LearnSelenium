package basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_9 {

	@Test
	public void readPropertyFile() throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// To read the property
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\basics\\config.properties");
		prop.load(fis);

		System.out.println("Enviorment is:" + prop.getProperty("Environment"));
		driver.get(prop.getProperty("URL"));
		
		driver.quit();
	}

}
