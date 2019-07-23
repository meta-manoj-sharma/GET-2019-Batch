package sparsematrix;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SparseMatrixTest {

	static SparseMatrix sparseMatrix;

	/*
	 * @Before method for initializing a sparse matrix for every new test cases
	 */
	@BeforeClass
	public static void init() throws Exception {
		sparseMatrix = new SparseMatrix(new int[][] { { 0, 4, 0 }, { 1, 6, 0 },
				{ 0, 0, 5 }, { 0, 10, 0 } });
	}

	/*
	 * method for test transpose of matrix
	 */
	@Test
	public void transposeTest() {
		assertArrayEquals(new int[][] { { 0, 1, 0, 0 }, { 4, 6, 0, 10 },
				{ 0, 0, 5, 0 } }, sparseMatrix.transpose());
	}

	/*
	 * method for testing for null input matrix
	 */
	@Test(expected = AssertionError.class)
	public void intializeWithNull() throws Exception {
		try {
			new SparseMatrix(null);
		} catch (NullPointerException ex) {
			assertEquals("Input Matrix is Null", ex.getMessage());
		}
	}
}
