package testNGAnnotation;

import org.testng.annotations.Test;

public class TestTwo extends TestBase {
	
	@Test
	public void testD() {
		System.out.println("Class: Two, TEST: D");
	}

	@Test
	public void testE() {
		System.out.println("Class: Two, TEST: E");
	}

	@Test
	public void testF() {
		System.out.println("Class: Two, TEST: F");
	}
}
