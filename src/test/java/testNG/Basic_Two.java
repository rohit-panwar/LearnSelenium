package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Basic_Two {
	
	@Test
	public void testCaseThird() {
		System.out.println("3rd Test Case");
	}

	@Test
	public void testCaseFourth() {
		System.out.println("4th Test Case");
	}
	
	@Test(dependsOnMethods = "testCaseFine")
	public void testCaseEight() {
		System.out.println("8th Test Case");
	}
	
	@Test
	public void testCaseFine() {
		//Assert.assertTrue(false);
		System.out.println("9th Test Case");
	}
}
