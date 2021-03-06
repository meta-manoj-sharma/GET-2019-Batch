package operation;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NumberOfClumpsTest {
	/*
	 * Testing function with @Parameters So these test cases will executes one
	 * by one(By Iteration) so here we don't require to write too much test
	 * cases
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, new int[] { 1, 1, 1, 2, 1 } },
				{ 2, new int[] { 1, 2, 2, 3, 4, 5, 5, 5 } },
				{4,new int[] { 1, 1, 4, 6, 9, 3, 3, 3, 3, 4, 4, 4, 6, 7,5, 5 } },
				{ 0, new int[] { 1, 2, 3, 4, 5, 6, 7, 8 } },
				{ 3, new int[] { 1, 2, 2, 3, 3, 3, 4, 4, 4 } } });
	}
	private int expected;
	private int[] inputArray;

	/*
	 * Constructor Value for each testCase
	 */
	public NumberOfClumpsTest(int expected, int[] inputArray) {
		this.expected = expected;
		this.inputArray = inputArray;
	}

	/*
	 * Runs For Each test Case
	 */
	@Test
	public void test() throws Exception {
		int actual = ArrayOperation.numberOfClumps(inputArray);
		assertEquals(expected, actual);
	}
}
