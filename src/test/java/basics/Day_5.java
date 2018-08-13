package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day_5 {

	@Test
	public void moveToElement() {
		// System.setProperty("webdriver.ie.driver","D:\\Webdriver\\drivers\\IEDriverServer.exe");
		// WebDriver driver = new InternetExplorerDriver();

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://html.com/");

		WebElement w1 = driver.findElement(By.partialLinkText("About"));
		Actions action = new Actions(driver);
		action.moveToElement(w1).build().perform();
	}

	@Test
	public void dragAndDrop() {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);

		WebElement w2 = driver.findElement(By.id("draggable"));
		WebElement w3 = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		action.clickAndHold(w2).moveToElement(w3).release().build().perform();
	}

}
