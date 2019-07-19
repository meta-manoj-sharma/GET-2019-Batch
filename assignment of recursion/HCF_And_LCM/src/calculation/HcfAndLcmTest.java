package calculation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HcfAndLcmTest {
	HcfAndLcm object = new HcfAndLcm();

	// test case for highest Common Factor
	@Test
	public void highestCommonFactorTest1() {
		int k = object.highestCommonFactor(3, 5);
		assertEquals(1, k);
	}

	@Test
	public void highestCommonFactorTest2() {
		int k = object.highestCommonFactor(13, 5);
		assertEquals(1, k);
	}

	// test case for least Common Multiple
	@Test
	public void leastCommonMultipleTest1() {
		int k = object.leastCommonMultiple(3, 5);
		assertEquals(15, k);
	}

	@Test
	public void leastCommonMultipleTest2() {
		int k = object.leastCommonMultiple(13, 5);
		assertEquals(65, k);
	}

	/*
	 * assertion test for least Common Multiple
	 */
	@Test(expected = AssertionError.class)
	public void whenExceptionThrownInLcm() {
		object.leastCommonMultiple(0, 0);
	}

}
