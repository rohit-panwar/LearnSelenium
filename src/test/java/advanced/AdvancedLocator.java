package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

public class AdvancedLocator {

	@Test
	public void LocatorTest() {

		System.setProperty("webdriver.gecko.driver", "D:\\Webdriver\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.facebook.com/");
		driver.findElement(
				new ByAll(By.name("firstname"), By.id("u_0_n"), By.xpath("//input[@aria-label='First name']")))
				.sendKeys("Rohit");
		// 1. SEarch will be perfrom from LEFT to RIGHT
		// 2. If element is found by 1st stattement it will ignore the other

		driver.findElement(new ByIdOrName("lastname")).sendKeys("Panwar");
		// Need to provide either NAME or ID

		driver.findElement(new ByChained(By.id("u_0_q"), By.id("u_0_r"),
				By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"),
				By.name("reg_email__")))
				.sendKeys("66468464");
		// It will find element in Parent Child changing

	}

}
