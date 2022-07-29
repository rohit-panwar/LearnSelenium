package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic_Parameter {

	@Test
	@Parameters({ "a", "b" })
	public void testAdd(int x, int y) {
		System.out.println(x + y);
	}

	@Test
	@Parameters({ "a", "b" })
	public void testSubstract(int x, int y) {
		System.out.println(x - y);
	}

	@Test
	@Parameters("mango")
	public void TestMango(String m) {
		System.out.println("Fruits names are:  " + m);
	}
	
	@Test
	@Parameters({"orange"})
	public void TestOrange(String o) {
		System.out.println("Fruits names are:  " + o);
	}
}
