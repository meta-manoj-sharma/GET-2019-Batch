package polynomial;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

	/*
	 * test case for success of degree method
	 */
	@Test
	public void degreepassTest() {
		Polynomial p1 = new Polynomial(new int[] { 5, 8, 3 });
		int expected = 2;
		assertEquals(expected, p1.degree());
	}

	/*
	 * test case for success of degree method
	 */
	@Test
	public void degreeFailTest() {
		Polynomial p1 = new Polynomial(new int[] { 5, 4, 6, 7, 8, 0, 1 });
		int expected = 6;
		assertEquals(expected, p1.degree());
	}

	/*
	 * test case for null input of degree method
	 */
	@Test
	public void degreeTestNullInput() {
		Polynomial p1 = new Polynomial(new int[] {});
		int expected = 0;
		assertEquals(expected, p1.degree());
	}

	/*
	 * test case for failure of degree method
	 */
	@Test
	public void degreeTestcaseWithInput3() {
		Polynomial p1 = new Polynomial(new int[] { 5, 8, 3, 0, 0, 3 });
		int expected = 5;
		assertEquals(expected, p1.degree());
	}

	/*
	 * test case for success of evaluate method
	 */
	@Test
	public void evaluatePassTest() {
		Polynomial p1 = new Polynomial(new int[] { 5, 8, 3 });
		float value = 1;
		float expected = 16.0f;
		assertEquals(expected, p1.evaluate(value), 0);
	}

	/*
	 * test case for success of evaluate method
	 */
	@Test
	public void evaluatePassTest2() {
		Polynomial p1 = new Polynomial(new int[] { 5, 8, 3 });
		float value = -3;
		float expected = 8.0f;
		assertEquals(expected, p1.evaluate(value), 0);
	}

	/*
	 * test case for failure of mulPoly method
	 */
	@Test
	public void mulPolyFailTest2() {
		Polynomial p1 = new Polynomial(new int[] { 5, 8, 3 });
		Polynomial p2 = new Polynomial(new int[] { 1, 0, 3, 6 });
		int result[] = { 5, 8, 18, 54, 57, 18 };
		assertArrayEquals(result, Polynomial.mulPoly(p1, p2));
	}

}
