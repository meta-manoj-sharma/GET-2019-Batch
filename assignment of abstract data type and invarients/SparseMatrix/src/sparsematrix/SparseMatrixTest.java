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
	public static void init() throws Exception 
	{
		sparseMatrix = new SparseMatrix(new int[][] { { 0, 4, 0 }, { 1, 6, 0 }, { 0, 0, 5 }, { 0, 10, 0 } });
		
	}

	/*
	 * method for test transpose of matrix
	 */
	@Test
	public void transposeTest() 
	{
		assertArrayEquals(new int[][] { { 0, 1, 0, 0 }, { 4, 6, 0, 10 }, { 0, 0, 5, 0 } }, sparseMatrix.transpose());
	}

	/*
	 * method for testing symmetrical matrix 
	 */
	@Test
	public void symmetricalTest() throws Exception 
	{
		assertTrue(new SparseMatrix(new int[][] { { 0, 4, 0 }, { 4, 0, 0 }, { 0, 0, 5 } }).isSymmetricalMatrix());
	}

	/*
	 * method for testing addition of sparse matrix
	 */
	@Test
	public void additionTest() throws Exception
	{
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 1, 2, 0 }, { 0, -3, 0 }, { 0, 2, 0 }, { 0, 10, 0 } });
		assertArrayEquals(new int[][] { { 1, 6, 0 }, { 1, 3, 0 }, { 0, 2, 5 }, { 0, 20, 0 } },
				SparseMatrix.addSparseMatrix(sparseMatrix, matrix2));
	}

	/*
	 * method for testing multply of sparse matrix
	 */
	@Test
	public void multiplyTest() throws Exception
	{
		SparseMatrix matrix2 = new SparseMatrix(new int[][] { { 1, 2, 0, 0 }, { 0, -3, 0, 10 }, { 0, 2, 0, 0 } });
		assertArrayEquals(new int[][] { { 0, -12, 0, 40 }, { 1, -16, 0, 60 }, { 0, 10, 0, 0 }, { 0, -30, 0, 100 } },
				SparseMatrix.multiplySparseMatrix(sparseMatrix, matrix2));
	}

	/*
	 * method for testing for null input matrix
	 */
	@Test(expected=AssertionError.class)
	public void intializeWithNull() throws Exception
	{
		try 
		{
			new SparseMatrix(null);
		} 
		catch (NullPointerException ex)
		{
			assertEquals("Input Matrix is Null", ex.getMessage());
		}
	}
	/*
	 * method for testing multiplication condition
	 */
	@Test(expected=AssertionError.class)
	public void checkSparseMatrixMultiplication()
	{
		try {
			SparseMatrix matrix2 = new SparseMatrix(
					new int[][] { { 1, 2, 0, 2 }, { 0, -3, 0, 0 }, { 0, 2, 0, 1 }, { 0, 10, 0, 0 } });
			SparseMatrix.multiplySparseMatrix(sparseMatrix, matrix2);
		} 
		catch (Exception ex)
		{
			assertEquals("multiplication condition not matched",
					ex.getMessage());
		}
	}

}
