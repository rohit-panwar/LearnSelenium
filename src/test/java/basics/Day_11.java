package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_11 {

	@Test
	public void hightlightElement() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.freecrm.com/index.html");

		WebElement btnLogin = driver.findElement(By.xpath("//a[text()='Compare']"));
		flash(driver, btnLogin);
		driver.quit();

	}

	public static void flash(WebDriver driver, WebElement element) {

		String bgcolor = element.getCssValue("backgroundColor");
		System.out.println("*****" + bgcolor);
		for (int i = 0; i < 200; i++) {
			changeColor(driver, element, "rgb(127,255,0)");
			changeColor(driver, element, bgcolor);
		}
	}

	public static void changeColor(WebDriver driver, WebElement element, String color) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
	}
}
