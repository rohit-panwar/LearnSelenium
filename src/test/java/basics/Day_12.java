package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Day_12 {

	@Test
	public void hightlightElement() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
				
		driver.get("https://www.freecrm.com/index.html");
		
		WebElement btnLogin=driver.findElement(By.xpath("//input[@value='Login']"));
		
		// 1. To draw a border on an element
		drawBorder(driver, btnLogin);
		
		// 2. To display a custom alert with OWN message
		generateAlert(driver, "CAUTION!!! You have an alert !!!");
		Alert a=driver.switchTo().alert();
		a.accept();
		
		// 3. To click on element using JavaScript
		clickElementByJS(driver, btnLogin);
		
		// 4. To refresh the browser using JavaScript
		refreshBrowserByJS(driver);
		
		// 5. To get title using JavaScript
		System.out.println(getTitleByJS(driver));
		
		// 6. To get Page Text using JavaScript
		System.out.println(getInnerTextByJS(driver));
		
		// 7. To scroll to page end using JavaScript
		scrollPageDown(driver);
		
		// 8. To scroll to any element using JavaScript
		WebElement logout=driver.findElement(By.id(" "));
		scrollIntoView(driver, logout);
		
	}
	
	public static void drawBorder(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		String title=js.executeScript("return document.title").toString();
		return title;
	}
	
	public static String getInnerTextByJS(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
