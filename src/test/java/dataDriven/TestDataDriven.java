package dataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDataDriven {

	@Test
	public void readDataFromExcel() {
		Xls_Reader reader = new Xls_Reader(
				System.getProperty("user.dir") + "\\src\\test\\java\\dataDriven\\ExcelData.xlsx");

		int totalRows = reader.getRowCount("RegPage");
		System.out.println("Total rows available in excel :: " + totalRows);

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.freecontactform.com/forms/contact-form-free");
		driver.switchTo().frame(0);
		reader.addColumn("RegPage", "Status");

		for (int i = 2; i <= totalRows; i++) {
			String getFirstName = reader.getCellData("RegPage", "firstname", i);
			System.out.println(getFirstName);
			driver.findElement(By.name("Name")).clear();
			driver.findElement(By.name("Name")).sendKeys(getFirstName);

			/*
			 * String getLastName = reader.getCellData("RegPage", "lastname", i);
			 * System.out.println(getLastName);
			 * driver.findElement(By.name("last_name")).clear();
			 * driver.findElement(By.name("last_name")).sendKeys(getLastName);
			 */

			String email = reader.getCellData("RegPage", "email", i);
			System.out.println(email);
			driver.findElement(By.name("Email")).clear();
			driver.findElement(By.name("Email")).sendKeys(email);

			String getPhone = reader.getCellData("RegPage", "phone", i);
			System.out.println((int) Double.parseDouble(getPhone));
			driver.findElement(By.name("Phone")).clear();
			driver.findElement(By.name("Phone")).sendKeys(getPhone);

			String getComments = reader.getCellData("RegPage", "comments", i);
			System.out.println(getComments);
			driver.findElement(By.xpath("//textarea[@name='Message']")).clear();
			driver.findElement(By.xpath("//textarea[@name='Message']")).sendKeys(getComments);

			//driver.findElement(By.xpath("//input[@value=' Submit Form ']")).click();
			//Alert alert = driver.switchTo().alert();
			//alert.accept();

			if (i % 2 == 0) {
				reader.setCellData("RegPage", "Status", i, "Pass");
			} else
				reader.setCellData("RegPage", "Status", i, "Fail");
		}
		driver.quit();
	}

	@Test(enabled = true)
	public void excelOperations() {
		Xls_Reader reader = new Xls_Reader(
				System.getProperty("user.dir") + "\\src\\test\\java\\dataDriven\\ExcelData.xlsx");

		// To get the total rows
		int totalRows = reader.getRowCount("RegPage");
		System.out.println("Total rows available in excel :: " + totalRows);

		// To add a new column
		reader.addColumn("RegPage", "Status");

		// to add new sheet
		if (!reader.isSheetExist("New"))
			reader.addSheet("New");
	}
}
