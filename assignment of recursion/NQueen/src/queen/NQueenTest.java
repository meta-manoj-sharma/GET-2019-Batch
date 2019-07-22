package queen;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {
	NQueen object = new NQueen();
  // test cases for checking n queen method
	@Test
	public void testNqueen1() {
		int array[][] = new int[4][4];
		assertTrue(object.findPlaces(array, 0, 4));
	}

	@Test
	public void testNqueen2() {
		int array[][] = new int[8][8];
		assertTrue(object.findPlaces(array, 0, 8));
	}

	@Test
	public void testNqueen3() {
		int array[][] = new int[3][3];
		System.out.println("Return Value is" + object.findPlaces(array, 0, 3));
		assertFalse(object.findPlaces(array, 0, 3));
	}

	@Test
	public void testNqueen4() {
		int array[][] = new int[2][2];
		System.out.println("Return value is " + object.findPlaces(array, 0, 2));
		assertFalse(object.findPlaces(array, 0, 2));
	}
}
