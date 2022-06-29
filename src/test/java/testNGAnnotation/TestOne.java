package testNGAnnotation;

import org.testng.annotations.Test;

public class TestOne extends TestBase {
	
	@Test
	public void testA() {
		System.out.println("Class: One, TEST: A");
	}

	@Test
	public void testB() {
		System.out.println("Class: One, TEST: B");
	}

	@Test
	public void testC() {
		System.out.println("Class: One, TEST: C");
	}
	
	

}
