package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_17 {

	@Test
	public void datePickerByJS() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.spicejet.com/");
		
		WebElement datePicker=driver.findElement(By.id("view_fulldate_id_1"));
		String value="Sun, Aug 26 2018";
		
		selectDateByJS(driver, datePicker, value);
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+dateValue+"');", element);
	}
}
