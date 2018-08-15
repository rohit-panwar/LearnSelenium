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
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
				
		driver.get("https://www.freecrm.com/index.html");
		
		WebElement btnLogin=driver.findElement(By.xpath("//input[@value='Login']"));
		flash(driver, btnLogin);
		
	}
	
	public static void flash(WebDriver driver, WebElement element) {
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		String bgcolor= element.getCssValue("backgroundColor");
		System.out.println("*****"+bgcolor);
		for(int i=0; i<100;i++) {
			changeColor(driver, element, "rgb(0,200,0)");
			changeColor(driver, element, bgcolor);
		}
	}
	
	public static void changeColor(WebDriver driver, WebElement element, String color) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
	}
}
