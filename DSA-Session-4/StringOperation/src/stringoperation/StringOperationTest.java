package stringoperation;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationTest {

	@Test
	public void testCase1() {
		StringOperation obj = new StringOperation();
		assertEquals(3, obj.uniqueChar("Hello"));
	}

	@Test
	public void testCase2() {
		StringOperation obj = new StringOperation();
		assertEquals(4, obj.uniqueChar("Testcase"));
	}

	@Test
	public void testCase3() {
		StringOperation obj = new StringOperation();
		assertEquals(3, obj.uniqueChar("hello"));
	}

	@Test
	public void testCase4() {
		StringOperation obj = new StringOperation();
		assertEquals(0, obj.uniqueChar(""));
	}
}
