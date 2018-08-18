package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Day_16 {

	@Test
	public void calanderControl() {

		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CALENDAR")).click();
		
		String date="14-November-1987";
		String dateArr[]=date.split("-");
		
		String day=dateArr[0];
		String month=dateArr[1];
		String year=dateArr[2];
		
		Select months=new Select(driver.findElement(By.name("slctMonth")));
		months.selectByValue(month);
		
		Select years=new Select(driver.findElement(By.name("slctYear")));
		years.selectByValue(year);
		
		//*[@id="crmcalendar"]table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]
		String beforeXpath="//*[@id='crmcalendar']table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath="]/td[";
		boolean flag=false;
		
		for(int row=2; row<7; row++) {
			for(int col=1; col<8; col++) {
				String dayVal=driver.findElement(By.xpath(beforeXpath+row+afterXpath+"]")).getText();
				System.out.println(dayVal);
				if(dayVal.equals(day)) {
					driver.findElement(By.xpath(beforeXpath+row+afterXpath+col+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag)
				break;
		}		
	}

}
