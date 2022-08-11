package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

public class AdvancedLocator {

	@Test
	public void LocatorTest() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		//driver.get("https://www.facebook.com/");


		driver.get("https://www.facebook.com/r.php?locale=en_IN&display=page");
		driver.findElement(
				new ByAll(By.id("u_0_n"), By.name("firstname"), By.xpath("//input[@aria-label='First name']")))
				.sendKeys("Rohit");
		// 1. Search will be perform from LEFT to RIGHT
		// 2. If element is found by 1st statement it will ignore the other

		driver.findElement(new ByIdOrName("lastname")).sendKeys("Panwar");
		// Need to provide either NAME or ID

		driver.findElement(new ByChained(By.id("u_0_q"), By.id("u_0_r"),
				By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"),
				By.name("reg_email__")))
				.sendKeys("66468464");
		// It will find element in Parent-Child changing

		//driver.findElement(new ByChained(By.id("fullname_field"), By.className("uiStickyPlaceholderInput"), By.xpath("input[@name='lastname']"))).sendKeys("abc");
		// It will find element in Parent Child changing


	}
}
