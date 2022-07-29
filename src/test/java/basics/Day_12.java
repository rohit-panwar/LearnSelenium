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
	public void hightlightElement() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
				
		driver.get("https://freecrm.com/");
		
		WebElement btnLogin=driver.findElement(By.xpath("//a[text()='About']"));
		
		// 1. To draw a border on an element
		drawBorder(driver, btnLogin);
		Thread.sleep(2000);
		
		// 2. To display a custom alert with OWN message
		generateAlert(driver, "CAUTION!!! You have an alert !!!");
		Alert a=driver.switchTo().alert();
		Thread.sleep(2000);
		a.accept();
		
		// 3. To click on element using JavaScript
		clickElementByJS(driver, btnLogin);
		
		// 4. To refresh the browser using JavaScript
		refreshBrowserByJS(driver);
		
		// 5. To get title using JavaScript
		System.out.println(getTitleByJS(driver));
		
		// 6. To get Page Text using JavaScript
		System.out.println(getInnerTextByJS(driver));
				
		// 7. To scroll to any element using JavaScript
		WebElement policy=driver.findElement(By.linkText("Privacy Policy"));
		scrollIntoView(driver, policy);
		Thread.sleep(2000);
		policy.click();
		
		// 8. To scroll to page end using JavaScript
		scrollPageDown(driver);
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
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
}
