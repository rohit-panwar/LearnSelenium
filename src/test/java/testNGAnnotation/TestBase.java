package testNGAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println(" ***** Class: Base, Before Suite *****");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println(" ***** Class: Base, After Suite *****");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\t <<<<< Class: Base, Before Test >>>>> ");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("\t <<<<< Class: Base, After Test >>>>> ");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("\t\t +++++ Class: Base, Before Class +++++ ");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("\t\t +++++ Class: Base, After Class +++++ ");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t ----- Class: Base, Before Method ----- ");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\t\t ----- Class: Base, After Method ----- ");
	}
}
