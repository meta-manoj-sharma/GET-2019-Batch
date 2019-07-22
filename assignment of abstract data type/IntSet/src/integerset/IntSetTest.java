package integerset;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {
	// test case for is member
	@Test
	public void isMemberPassTest() {
		boolean expected = true;
		int number = 8;
		assertEquals(expected,
				new IntSet(new int[] { 3, 6, 4, 8, 9, 11, 15 })
						.isMember(number));
	}

	// fail test case for is member
	@Test
	public void isMemberFailTest() {
		boolean expected = true;
		int number = 12;
		assertNotEquals(expected, new IntSet(
				new int[] { 3, 6, 4, 8, 9, 11, 15 }).isMember(number));
	}

	@Test
	public void complementPassTest() {
		int[] expected = new int[997];
		for (int i = 0; i <= 1000 - 4; i++)
			expected[i] = i + 4;
		int[] number = new int[] { 1, 2, 3 };
		assertArrayEquals(expected, new IntSet(number).getComplement());
	}
}
