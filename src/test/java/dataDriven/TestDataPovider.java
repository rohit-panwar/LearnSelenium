package dataDriven;

import java.util.ArrayList;
import java.util.Iterator;

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
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecontactform.com/html_form.php");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testData=DataProvideExcelReader.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getData")
	public void dataProviderTest(String fname, String lname, String email, String phone, String comment) {
		
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys(fname);

		driver.findElement(By.name("last_name")).clear();
		driver.findElement(By.name("last_name")).sendKeys(lname);

		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);

		driver.findElement(By.name("telephone")).clear();
		driver.findElement(By.name("telephone")).sendKeys(phone);

		driver.findElement(By.xpath("//textarea[@name='comments']")).clear();
		driver.findElement(By.xpath("//textarea[@name='comments']")).sendKeys(comment);

		driver.findElement(By.xpath("//input[@value=' Submit Form ']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
