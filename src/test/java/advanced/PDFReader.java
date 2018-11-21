package advanced;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFReader {
	
	@Test
	public void readPDFTest() throws IOException {
		
		/*
		System.setProperty("webdriver.chrome.driver", "D:\\Webdriver\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.africau.edu/images/default/sample.pdf");
		String currentUrl= driver.getCurrentUrl();
		
		URL url= new URL(currentUrl);
		*/
		//URL url = new URL("http://www.africau.edu/images/default/sample.pdf");
		//URL url = new URL("file:///C:/Users/Rohit/Desktop/Files/sample.pdf");
		URL url = new URL("file:///D:/The%20Immortals%20Of%20Meluha.pdf");
		
		InputStream is = url.openStream();
		BufferedInputStream fileParse= new BufferedInputStream(is);
		PDDocument document= null;
		
		document=PDDocument.load(fileParse);
		String pdfContent= new PDFTextStripper().getText(document);
		
		System.out.println(pdfContent);
		
		Assert.assertTrue(pdfContent.contains("A Simple PDF File"));
		
	}

}
