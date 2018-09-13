package dataDriven;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDriven {

	@Test
	public void readDataFromExcel() {
		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\Rohit\\eclipse-workspace\\LearnSelenium\\src\\test\\java\\dataDriven\\ExcelData.xlsx");

		int totalRows = reader.getRowCount("RegPage");
		System.out.println("Total rows available in excel :: " + totalRows);

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.freecontactform.com/html_form.php");

		reader.addColumn("RegPage", "Status");
		
		for (int i = 2; i <= totalRows; i++) {
			String getFirstName = reader.getCellData("RegPage", "firstname", i);
			System.out.println(getFirstName);
			driver.findElement(By.name("first_name")).clear();
			driver.findElement(By.name("first_name")).sendKeys(getFirstName);

			String getLastName = reader.getCellData("RegPage", "lastname", i);
			System.out.println(getLastName);
			driver.findElement(By.name("last_name")).clear();
			driver.findElement(By.name("last_name")).sendKeys(getLastName);

			String email = reader.getCellData("RegPage", "email", i);
			System.out.println(email);
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(email);

			String getPhone = reader.getCellData("RegPage", "phone", i);
			System.out.println((int) Double.parseDouble(getPhone));
			driver.findElement(By.name("telephone")).clear();
			driver.findElement(By.name("telephone")).sendKeys(getPhone);

			String getComments = reader.getCellData("RegPage", "comments", i);
			System.out.println(getComments);
			driver.findElement(By.xpath("//textarea[@name='comments']")).clear();
			driver.findElement(By.xpath("//textarea[@name='comments']")).sendKeys(getComments);

			driver.findElement(By.xpath("//input[@value=' Submit Form ']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();

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
				"C:\\Users\\Rohit\\eclipse-workspace\\LearnSelenium\\src\\test\\java\\dataDriven\\ExcelData.xlsx");

		// To get the total rows
		int totalRows = reader.getRowCount("RegPage");
		System.out.println("Total rows available in excel :: " + totalRows);

		// To add a new column
		reader.addColumn("RegPage", "Status");
		
		// to add new sheet
		if(!reader.isSheetExist("New"))
			reader.addSheet("New");
	}

	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testData=dataDriven.DataProvideExcelReader();
		return testData.iterator();
	}
	
	@Test(dataProvider="getData()")
	public void dataProviderTest(String fname, String lname, String email, String phone, String comment) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.freecontactform.com/html_form.php");
		
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
