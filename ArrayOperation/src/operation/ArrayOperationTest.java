package operation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayOperationTest {
	/*
	 * test for largest mirror section
	 */
	@Test
	public void testLargestMirror() {
		int arrayCheck[] = new int[] { 1, 2, 3, 8, 9, 3, 2, 1 };
		int k = ArrayOperation.largestMirrorSection(arrayCheck);
		assertEquals(3, k);
	}

	/*
	 * assertion test for largest mirror section
	 */
	@Test(expected = AssertionError.class)
	public void whenExceptionThrowninMirror1() {
		int blank[] = {};
		ArrayOperation.largestMirrorSection(blank);
	}

	/*
	 * test for number Of Clumps
	 */
	@Test
	public void testLargestMirrornoOfClumps1() {
		int arrayCheck[] = new int[] { 1, 1, 2, 1, 1 };
		int k = ArrayOperation.numberOfClumps(arrayCheck);
		assertEquals(2, k);
	}

	@Test
	public void testLargestMirrornoOfClumps2() {
		int arrayCheck[] = new int[] { 1, 1, 1, 1, 2, 2, 3, 4, 4, 6, 6 };
		int k = ArrayOperation.numberOfClumps(arrayCheck);
		assertEquals(4, k);
	}

	/*
	 * test for fix x y
	 */
	@Test
	public void fixXY1() {
		int arrayCheck[] = new int[] { 5, 4, 9, 4, 9, 5 };
		int arrayExpected[] = new int[] { 9, 4, 5, 4, 5, 9 };
		int X = 4;
		int Y = 5;
		assertArrayEquals(arrayExpected, ArrayOperation.fixXY(arrayCheck, X, Y));
	}

	@Test
	public void fixXY2() {
		int arrayCheck[] = new int[] { 1, 4, 1, 5 };
		int arrayExpected[] = new int[] { 1, 4, 5, 1 };
		int X = 4;
		int Y = 5;
		assertArrayEquals(arrayExpected, ArrayOperation.fixXY(arrayCheck, X, Y));
	}

	/*
	 * test for split array
	 */
	@Test
	public void testSplitArray1() {
		int arrayCheck[] = new int[] { 1, 1, 1, 2, 1 };
		int k = ArrayOperation.splitArray(arrayCheck);
		assertEquals(3, k);
	}

	@Test
	public void testSplitArray2() {
		int arrayCheck[] = new int[] { 2, 1, 3, 1, 2, 3 };
		int k = ArrayOperation.splitArray(arrayCheck);
		assertEquals(3, k);
	}

	@Test
	public void testSplitArray3() {
		int arrayCheck[] = new int[] { 7, 1, 1, 2, 1 };
		int k = ArrayOperation.splitArray(arrayCheck);
		assertEquals(-1, k);
	}

	/*
	 * assertion test for numberO f Clumps to check array is null or not
	 */
	@Test(expected = AssertionError.class)
	public void whenExceptionThrownClumps() {
		int blank[] = {};
		ArrayOperation.numberOfClumps(blank);
	}

	/*
	 * assertion test for largest mirror section to check array is null or not
	 */
	@Test(expected = AssertionError.class)
	public void whenExceptionThrowninMirror() {
		int blank[] = {};
		ArrayOperation.largestMirrorSection(blank);
	}

	/*
	 * assertion test for fix x y
	 */
	@Test(expected = AssertionError.class)
	public void whenExceptionFixXY() {
		int blank[] = {};
		ArrayOperation.fixXY(blank, 4, 5);
	}

	/*
	 * assertion test for check x to be last element
	 */
	@Test(expected = AssertionError.class)
	public void fixXY1CheckExceptionLast() {
		int arrayCheck[] = new int[] { 5, 4, 9, 4, 9, 5, 4 };
		int X = 4;
		int Y = 5;
		ArrayOperation.fixXY(arrayCheck, X, Y);
	}

	/*
	 * assertion test for check x and y to be equal
	 */
	@Test(expected = AssertionError.class)
	public void fixXY2CheckExceptionUnequal() {
		int arrayCheck[] = new int[] { 4, 4, 4, 9, 4, 9, 5 };
		int X = 4;
		int Y = 5;
		ArrayOperation.fixXY(arrayCheck, X, Y);
	}
}
