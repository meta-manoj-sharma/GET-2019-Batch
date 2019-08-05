package stringoperation;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationTest {

	@Test
	public void testCase1() {
		StringOperation obj = new StringOperation();
		assertEquals(4, obj.uniqueChar("Hello"));
	}

	@Test
	public void testCase2() {
		StringOperation obj = new StringOperation();
		assertEquals(6, obj.uniqueChar("Testcase"));
	}

	@Test
	public void testCase3() {
		StringOperation obj = new StringOperation();
		assertEquals(12, obj.uniqueChar("@man#$ 123Wee"));
	}

	@Test
	public void testCase4() {
		StringOperation obj = new StringOperation();
		assertEquals(0, obj.uniqueChar(""));
	}
}
