package advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HTMLtable {
	
	@Test
	public void readHTMLtable() {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String beforeXpath_company="//*[@id='customers']/tbody/tr[";
		String afterXpath_company="]/td[1]";
		
		String beforeXpath_contact="//*[@id='customers']/tbody/tr[";
		String afterXpath_contact="]/td[2]";
		
		String beforeXpath_country="//*[@id='customers']/tbody/tr[";
		String afterXpath_country="]/td[3]";
		
		for(int i=2;i<=7;i++) {
			String actualXpath_company=beforeXpath_company+i+afterXpath_company;
			String companyName=driver.findElement(By.xpath(actualXpath_company)).getText();
			System.out.println(companyName);
			
			String actualXpath_contact=beforeXpath_contact+i+afterXpath_contact;
			String contactNo=driver.findElement(By.xpath(actualXpath_contact)).getText();
			System.out.println(contactNo);
			
			String actualXpath_country=beforeXpath_country+i+afterXpath_country;
			String country=driver.findElement(By.xpath(actualXpath_country)).getText();
			System.out.println(country);
		}
		
		driver.quit();
	}

}
