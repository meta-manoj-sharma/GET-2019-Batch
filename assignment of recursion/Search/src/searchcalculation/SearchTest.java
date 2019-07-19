package searchcalculation;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {
   // test cases for linear binary search 
	@Test
	public void testLinearSearch1() {
		int arrayCheck[] = new int[] { 1, 2, 3, 8, 9, 7, 5, 15, 9 };
		int k = LinearSearch.search(arrayCheck, 7, 0);
		assertEquals(6, k);
	}
	@Test
	public void testLinearSearch2() {
		int arrayCheck[] = new int[] { 1, 2, 3, 8, 15, 7, 5, 12, 9 };
		int k = LinearSearch.search(arrayCheck, 15, 0);
		assertEquals(5, k);
	}
	@Test
	public void testBinarySearch1() {
		int arrayCheck[] = new int[] { 1, 2, 3, 8, 9,  };
		int k = LinearSearch.search(arrayCheck, 3, 0);
		assertEquals(3, k);
	}
	@Test
	public void testBinarySearch2() {
		int arrayCheck[] = new int[] { 1, 2, 3, 8, 15, 25, 35, 42, 49 };
		int k = LinearSearch.search(arrayCheck, 15, 0);
		assertEquals(5, k);
	}


}
