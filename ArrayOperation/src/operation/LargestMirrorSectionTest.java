package operation;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LargestMirrorSectionTest {
	/*
	 * Testing function with @Parameters So these test cases will executes one
	 * by one(By Iteration) so here we don't require to write too much test
	 * cases
	 */
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays
				.asList(new Object[][] {
						{ 3, new int[] { 1, 2, 1, 4 } },
						{ 3, new int[] { 1, 2, 3, 8, 7, 3, 2, 1 } },
						{ 7, new int[] { 1, 4, 5, 7, 5, 4, 1 } },
						{11,new int[] { 1, 4, 3, 4, 6, 5, 11, 5, 6, 4, 3, 4, 6, 9 } },
						{ 3, new int[] { 1, 4, 5, 6, 5, 6, 4 } },
						{ 1, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 } },
						{ 5, new int[] { 5, 5, 5, 5, 5 } } });
	}

	private int expected;
	private int inputArray[];

	/*
	 * Constructor Value for each testCase
	 */
	public LargestMirrorSectionTest(int expected, int[] inputArray) {
		this.expected = expected;
		this.inputArray = inputArray;
	}

	/*
	 * Runs For Each test Case
	 */
	@Test
	public void test() throws Exception {
		int actual = ArrayOperation.largestMirrorSection(inputArray);
		assertEquals(expected, actual);
	}

}
