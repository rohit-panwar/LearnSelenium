package testNG;

import org.testng.annotations.Test;

public class Basic_Groups {

	@Test(groups= {"Smoke Test"})
	public void testCase41() {
		System.out.println("41st Smoke Test Case");
	}

	@Test(groups= {"Regression Test"})
	public void testCase42() {
		System.out.println("42nd Regression Test Case");
	}

	@Test(groups= {"Smoke Test", "Regression Test"})
	public void testCase43() {
		System.out.println("43rd Smoke & Regression Test Case");
	}
	
	@Test(groups= {"Smoke Test", "Unit Test"})
	public void testCase44() {
		System.out.println("44th Smoke & Unit Test Case");
	}
	
}
