package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day_1 {

	@Test
	public void launchFirefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Webdriver\\drivers\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver",    "D:\\R\\BrowserDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.seleniumhq.org/download/");
	}
	
	@Test
	public void lanuchChrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void lanuchIE() {
		System.setProperty("webdriver.ie.driver", "D:\\Webdriver\\drivers\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://facebook.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();

	}
	
	@Test
	public void chrome() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();
	}
}
