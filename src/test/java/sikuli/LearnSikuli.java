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
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		
		Screen s= new Screen();
		
		// Click on "Sign In" button
		Pattern clickSignin= new Pattern(System.getProperty("user.dir") + "\\signIn.PNG");
		s.wait(clickSignin, 2000);
		s.click();
		
		// Click on "Create Account" link
		Pattern clickCreateAccount= new Pattern(System.getProperty("user.dir") + "\\createAccount.JPG");
		s.wait(clickCreateAccount, 2000);
		s.click();
		
		// Click on "MySelf" option
		Pattern clickMySelfOption= new Pattern(System.getProperty("user.dir") + "\\self.PNG");
		s.wait(clickMySelfOption,2000);
		s.click();
		
		driver.quit();
	}
	
	@Test
	public void notePadOpen() throws FindFailed {
		
		Screen s= new Screen();
		
		s.click(System.getProperty("user.dir") + "\\notepadIcon.JPG");
		s.find(System.getProperty("user.dir") + "\\notepad.PNG");
		s.type(System.getProperty("user.dir") + "\\notepad.PNG", "Hello World");
	}
	
	@Test
	public void rightClick() throws FindFailed {
		
		Screen s= new Screen();
		
		s.find(System.getProperty("user.dir") + "\\notepadIcon.JPG");
		s.rightClick(System.getProperty("user.dir") + "\\notepadIcon.JPG");
	}
	
	@Test
	public void doubleClick() throws FindFailed {
		
		Screen s= new Screen();
		
		s.click("mini.JPG");
		s.doubleClick("edge.JPG");
	}
	
	@Test
	public void elementExist() throws FindFailed {
		
		Screen s= new Screen();
		
		s.click("mini.JPG");
		s.exists("edge.JPG");
	}
	
	@Test
	public void wheeling() throws FindFailed {
		
		Screen s= new Screen();
		
		s.click("mini.JPG");
		s.wheel("edge.JPG", 200, 0);
	}
	
	@Test
	public void hover() throws FindFailed {
		
		Screen s= new Screen();
		
		s.click("mini.JPG");
		s.hover("edge.JPG");
	}
	
	@Test
	public void type() throws FindFailed {
		
		Screen s= new Screen();
		
		//s.find("cortana.JPG");
		s.type("cortana.JPG", "NOTEPAD");
	}
	
	@Test
	public void paste() throws FindFailed {
		
		Screen s= new Screen();
		
		//s.find("cortana.JPG");
		s.paste("cortana.JPG", "NOTEPAD");
	}
	
	@Test
	public void dragNdrop() throws FindFailed {
		
		Screen s= new Screen();
		
		s.click("mini.JPG");
		s.dragDrop("edge.JPG", "dom.JPG");
	}

}
