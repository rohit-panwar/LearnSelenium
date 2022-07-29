package testNG;

import org.testng.annotations.Test;

public class Basic_One {

	@Test(description = "*** This will print 1st ***")
	public void testCaseFirst() {
		System.out.println("1st Test Case");
	}

	@Test (priority=0)
	public void testCaseSecond() {
		System.out.println("2nd Test Case");
	}

	@Test(enabled = false)
	public void testCaseFifth() {
		System.out.println("5th Test Case");
	}

	@Test(priority=-100)
	public void testCaseSix() {
		System.out.println("6th Test Case");
	}
	
	@Test(priority = 100)
	public void testCaseSeven() {
		System.out.println("7th Test Case");
	}
}
