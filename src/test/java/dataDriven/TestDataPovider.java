package dataDriven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataPovider {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.freecontactform.com/forms/contact-form-free");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testData = DataProvideExcelReader.getDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider = "getData")
	public void dataProviderTest(String name, String email, String phone, String comment) {

		driver.switchTo().frame(0);
		driver.findElement(By.name("Name")).clear();
		driver.findElement(By.name("Name")).sendKeys(name);

		// driver.findElement(By.name("last_name")).clear();
		// driver.findElement(By.name("last_name")).sendKeys(lname);

		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.name("Email")).sendKeys(email);

		driver.findElement(By.name("Phone")).clear();
		driver.findElement(By.name("Phone")).sendKeys(phone);

		driver.findElement(By.xpath("//textarea[@name='Message']")).clear();
		driver.findElement(By.xpath("//textarea[@name='Message']")).sendKeys(comment);
	}

}
