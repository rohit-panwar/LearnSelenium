package testNG;

import org.testng.annotations.Test;

public class Basic_IncludeExcludeMethods {

	@Test
	public void testCase31() {
		System.out.println("31st Test Case");
	}

	@Test(description = "Will exclude this method")
	public void testCase32() {
		System.out.println("32nd Test Case");
	}

	@Test(description = "Will include this method")
	public void testCase33() {
		System.out.println("33rd Test Case");
	}
}
