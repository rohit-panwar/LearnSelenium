package advanced;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinks {

	@Test
	public void findBrokenLinks() throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://test1.absofttrainings.com/");

		// Find all the links on the page
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Total links :" + list.size());

		// Find all the imags on the page and add it with link
		list.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total links and images :" + list.size());

		// Display all links and images
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + "." + list.get(i).getAttribute("href"));
		}

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		// Add only those link that has URL
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAttribute("href") != null && (!list.get(i).getAttribute("href").contains("mailto"))) {
				activeLinks.add(list.get(i));
			}
		}

		// Total active links and images
		System.out.println("*************************");
		System.out.println("Total active links and images :" + activeLinks.size());
		
		/*// Display all links and images
		for (int i = 0; i < activeLinks.size(); i++) {
			System.out.println((i + 1) + "." + activeLinks.get(i).getAttribute("href"));
		}*/

		// Check the href url with HTTPConnection
		for (int j = 0; j < activeLinks.size(); j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			System.out.println((j+1)+". "+activeLinks.get(j).getAttribute("href")+"--->"+response);
		}
		
		driver.quit();
	}

}
