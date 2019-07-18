package operation;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitArrayTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 3, new int[] { 1, 1, 1, 2, 1 } },
				{ 2, new int[] { 3, 1, 1, 1, 1, 1 } },
				{ -1, new int[] { 2, 4, 1, 2, 1 } },
				{ 2, new int[] { 7, 7, 7, 7 } },
				{ 3, new int[] { 5, 4, 2, 9, 2 } },
				{12,new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3,4, 6 } },
				{ 6, new int[] { 1, -1, 4, -1, -1, 4, 3, 2, 1 } } });
	}

	private int expected;
	private int[] inputArray;
	/*
	 * Constructor Value for each testCase
	 */
	public SplitArrayTest(int expected, int[] inputArray) {
		this.expected = expected;
		this.inputArray = inputArray;
	}
	/*
	 * Runs For Each test Case
	 */
	@Test
	public void test() throws Exception {
		int actual = ArrayOperation.splitArray(inputArray);
		assertEquals(expected, actual);
	}
}
