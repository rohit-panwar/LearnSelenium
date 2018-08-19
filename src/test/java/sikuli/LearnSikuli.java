package sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class LearnSikuli {
	
	@Test
	public void googleTestBySikuli() throws FindFailed {
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		Screen s= new Screen();
		
		// Click on "Sign In" button
		Pattern clickSignin= new Pattern("signin.PNG");
		s.wait(clickSignin, 2000);
		s.click();
		
		// Click on "Create Account" link
		Pattern clickCreateAccount= new Pattern("createAccount.JPG");
		s.wait(clickCreateAccount, 2000);
		s.click();
	}

}
