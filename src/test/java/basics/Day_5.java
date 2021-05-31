package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Day_5 {

	@Test
	public void moveToElement() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://html.com/");

		Thread.sleep(5000);
		WebElement w1 = driver.findElement(By.xpath("(//a[text()='About'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(w1).build().perform();
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void dragAndDrop() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
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
	
	@Test(description="Keyboard Events")
	public void keyBorad() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.seleniumframework.com/Practiceform/");
		WebElement w1=driver.findElement(By.name("email"));
		w1.sendKeys("India");
				
		Actions actions= new Actions(driver);
		
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		actions.sendKeys(Keys.TAB).build().perform();
		actions.sendKeys(Keys.TAB).build().perform();
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		actions.sendKeys(Keys.ENTER).build().perform();
		//actions.contextClick().build().perform();
		//Thread.sleep(2000);
		actions.contextClick(w1).build().perform();
	}

}
