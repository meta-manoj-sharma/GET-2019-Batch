package sparsematrix;

import java.util.*;

public class Main {
	private static int[][] getInput() throws Exception {
		Scanner input = new Scanner(System.in);
		int row = 0, column = 0, i, j;
		System.out.println("enter number of row for sparse matrix");
		row = input.nextInt();
		System.out.println("enter number of column for sparse matrix");
		column = input.nextInt();
		if (row == 0 || column == 0) {
			throw new Exception(); // for checking row and column null
		}
		int[][] array = new int[row][column];
		System.out.println("enter elements sparse matrix");
		for (i = 0; i < row; i++) {
			for (j = 0; j < column; j++) {
				array[i][j] = input.nextInt();  // taking input array
			}
		}
		return array;
	}

	public static void main(String[] args) {
		try {
			SparseMatrix object = new SparseMatrix(getInput()); //getting transpose of matrix 
			while (true) {
				int choice;
				Scanner input = new Scanner(System.in);
				System.out.println("press 1 To get the transpose of matrix");
				System.out.println("press 2 To check symmetrical array");
				System.out.println("press 3 To add two matrix");
				System.out.println("press 4 To multiply two matrix");
				System.out.println("press 5 Exit");
				choice = input.nextInt();
				if (choice <= 0) {
					System.out.println("choose valid value..");
				}
				switch (choice) {
				case 1:
					object.display(object.transpose());
					break;
				case 2:
					if (object.isSymmetricalMatrix()) {
						System.out.println("Matrix is symmetric");
					} else
						System.out.println("Matrix is not symmteric");
					break;

				case 3:
					System.out.println("enter data for second  sparse matrix");
					SparseMatrix object2 = new SparseMatrix(getInput());
					System.out.println("addition is.. ");
					object.display(object.addSparseMatrix(object, object2));//adding two matrixes and displaying them
					break;
				case 4:
					System.out.println("enter data for second sparse matrix");
					SparseMatrix object3 = new SparseMatrix(getInput());
					System.out.println("multiplication is.. ");
					object.display(object3. multiplySparseMatrix(object, object3));//multiplying two matrixes and displaying them
					break;
				case 5:
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
			main(args);
		}
	}
}
