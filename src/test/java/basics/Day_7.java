package basics;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Day_7 {

	@Test
	public void navigation() {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		System.out.println("In Google");
		driver.navigate().to("https://www.bing.com/");
		System.out.println("Navigated to Bing");
		driver.navigate().back();
		System.out.println("In Google again");
		driver.navigate().forward();
		System.out.println("In Bing Back");
	}

	@Test
	public void takeScreenshot() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		//File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// FileUtils.copyFile(src, new File("//google.png"));
	}

	@Test
	public void explicitWait() {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://test1.absofttrainings.com/my-account/");
		clickOn(driver, driver.findElement(By.name("login")), 10);
		
	}

	public static void clickOn(WebDriver driver, WebElement locate, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locate));
		locate.click();
	}
}
