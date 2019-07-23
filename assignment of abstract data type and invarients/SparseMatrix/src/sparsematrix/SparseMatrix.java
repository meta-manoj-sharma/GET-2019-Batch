package sparsematrix;

import java.util.Arrays;

/**
 * this class is used to perform various sparse matrix operations
 * @author Manoj 
 * Dated 19 july 2019
 */
interface Sparse {
	void display(int[][] sparseMatrix);

	int[][] transpose();

	boolean isSymmetricalMatrix();

	int[][] addSparseMatrix(SparseMatrix matrix1, SparseMatrix matrix2);

	int[][] multiplySparseMatrix(SparseMatrix matrix1, SparseMatrix matrix2);
}

public final class SparseMatrix {
	private final int sparseMatrix[][];
	private final int rows;
	private final int columns;

	/**
	 * this the constructor of sparse matrix
	 * @param inputMatrix matrix input by user
	 * @throws AssertionError
	 */
	 SparseMatrix(int inputMatrix[][]) throws AssertionError {
		int lengthOfElements = 0;
		int index = 0;
		if (inputMatrix == null) {
			throw new AssertionError("Null matrix");
		}
		if (inputMatrix.length == 0) {
			throw new AssertionError("Empty matrix");
		}
		rows = inputMatrix.length;
		columns = inputMatrix[0].length;
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix[0].length; j++) {
				if (inputMatrix[i][j] != 0) {
					lengthOfElements++;
				}
			}
		}
		sparseMatrix = new int[lengthOfElements][3];
		for (int row = 0; row < inputMatrix.length; row++) {
			for (int col = 0; col < inputMatrix[0].length; col++) { // converting matrix into sparse matrix
				if (inputMatrix[row][col] != 0) {
					sparseMatrix[index][0] = row;
					sparseMatrix[index][1] = col;
					sparseMatrix[index][2] = inputMatrix[row][col];
					index++;
				}
			}
		}
	}

	/**
	 * display resultant sparse matrix
	 * @param sparseMatrix get matrix
	 */
	public void display(int[][] sparseMatrix) {

		for (int i = 0; i < sparseMatrix.length; i++) {
			System.out.println("");
			for (int j = 0; j < sparseMatrix[0].length; j++) { // complexity O(n^2)
				System.out.print(sparseMatrix[i][j] + " ");
			}
		}
		System.out.println("");
	}

	/**
	 * @return transpose of matrix
	 */
	public int[][] transpose() { // complexity O(n)
		int transposeMatrix[][] = new int[columns][rows];
		transposeMatrix[0][0] = 0;
		for (int i = 0; i < sparseMatrix.length; i++) {
			transposeMatrix[sparseMatrix[i][1]][sparseMatrix[i][0]] = sparseMatrix[i][2];
		}
		return transposeMatrix;
	}

	/**
	 * @return true and false after checking symmetry of matrix
	 * @throws AssertionError
	 */
	public boolean isSymmetricalMatrix() throws AssertionError {

		if (rows != columns) {
			throw new AssertionError("Matrix row and should be equal");
		}
			if (Arrays.deepEquals(sparseMatrix, transpose())) {   // complexity O(n^2)
				return true;
			}
		return false;
	}

	/**
	 * @param matrix1 given by user to add
	 * @param matrix2 given by user to add
	 * @return resultant matrix of addition
	 * @throws AssertionError
	 */
	public int[][] addSparseMatrix(SparseMatrix matrix1,
			SparseMatrix matrix2) throws AssertionError {  // complexity O(n^2)
		if (matrix1.rows != matrix2.rows || matrix1.columns != matrix2.columns) {
			throw new AssertionError("Row and column not same");
		}
		int addMatrix[][] = new int[matrix1.rows][matrix1.columns];
		addMatrix[0][0] = 0;
		int indexOne = 0;
		int indexTwo = 0;
		for (; indexOne < matrix1.sparseMatrix.length
				&& indexTwo < matrix2.sparseMatrix.length;) {
			/*
			 * Comparing Row Index
			 */
			if (matrix1.sparseMatrix[indexOne][0] == matrix2.sparseMatrix[indexTwo][0]) {
				/*
				 * Comparing Column Index
				 */
				if (matrix1.sparseMatrix[indexOne][1] == matrix2.sparseMatrix[indexTwo][1]) {
					addMatrix[matrix1.sparseMatrix[indexOne][0]][matrix1.sparseMatrix[indexOne][1]] = matrix1.sparseMatrix[indexOne][2]
							+ matrix2.sparseMatrix[indexTwo][2];
					indexOne++;
					indexTwo++;
				} else if (matrix1.sparseMatrix[indexOne][1] > matrix2.sparseMatrix[indexTwo][1]) {
					addMatrix[matrix2.sparseMatrix[indexTwo][0]][matrix2.sparseMatrix[indexTwo][1]] = matrix2.sparseMatrix[indexTwo][2];
					indexTwo++;
				} else {
					addMatrix[matrix1.sparseMatrix[indexOne][0]][matrix1.sparseMatrix[indexOne][1]] = matrix1.sparseMatrix[indexOne][2];
					indexOne++;
				}
			} else if (matrix1.sparseMatrix[indexOne][0] > matrix2.sparseMatrix[indexTwo][0]) {
				addMatrix[matrix2.sparseMatrix[indexTwo][0]][matrix2.sparseMatrix[indexTwo][1]] = matrix2.sparseMatrix[indexTwo][2];
				indexTwo++;
			} else {
				addMatrix[matrix1.sparseMatrix[indexOne][0]][matrix1.sparseMatrix[indexOne][1]] = matrix1.sparseMatrix[indexOne][2];
				indexOne++;
			}
		}

		/*
		 * Adding Matrix1 remaining Elements
		 */
		while (indexOne < matrix1.sparseMatrix.length) {
			addMatrix[matrix1.sparseMatrix[indexOne][0]][matrix1.sparseMatrix[indexOne][1]] = matrix1.sparseMatrix[indexOne][2];
			indexOne++;
		}
		/*
		 * Adding Matrix2 remaining Elements
		 */
		while (indexTwo < matrix2.sparseMatrix.length) {
			addMatrix[matrix2.sparseMatrix[indexTwo][0]][matrix2.sparseMatrix[indexTwo][1]] = matrix2.sparseMatrix[indexTwo][2];
			indexTwo++;
		}
		return addMatrix;
	}

	/**
	 * @param matrix1 given by user
	 * @param matrix2 given by user
	 * @return multiplication of two matrix
	 * @throws AssertionError
	 */
	public int[][] multiplySparseMatrix(SparseMatrix matrix1,
			SparseMatrix matrix2) throws AssertionError {  // complexity O(n^2)
		if (matrix1.columns != matrix2.rows) { // comparing dimension of both matrix for multiplication
			throw new AssertionError("multiplication condition not matched");
		}
		int multiplyMatrix[][] = new int[matrix1.rows][matrix2.columns];
		multiplyMatrix[0][0] = 0;

		for (int i = 0; i < matrix1.sparseMatrix.length; i++) {
			for (int j = 0; j < matrix2.sparseMatrix.length; j++) {
				if (matrix1.sparseMatrix[i][1] == matrix2.sparseMatrix[j][0]) { // multiplication logic of two matrix
					multiplyMatrix[matrix1.sparseMatrix[i][0]][matrix2.sparseMatrix[j][1]] += matrix1.sparseMatrix[i][2]
							* matrix2.sparseMatrix[j][2];
				}
			}
		}
		return multiplyMatrix;
	}
}
