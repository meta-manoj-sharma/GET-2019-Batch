package sparsematrix;

import java.util.*;

public class Main {
	private static int[][] getInput() throws Exception {
		Scanner input = new Scanner(System.in);
		int row = 0, column = 0, i, j;
		System.out.println("enter row and column values for sparse matrix");
		row = input.nextInt();
		column = input.nextInt();
		if (row == 0 || column == 0) {
			throw new Exception(); // for checking row and column null
		}
		int[][] array = new int[row][column];
		System.out.println("enter elements of array");
		for (i = 0; i < row; i++) {
			for (j = 0; j < column; j++) {
				array[i][j] = input.nextInt();  // taking input array
			}
		}
		return array;
	}

	public static void main(String[] args) {
		try {
			while (true) {
				int choice, member, i;
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
					SparseMatrix object = new SparseMatrix(getInput()); //getting transpose of matrix and displaying them
					object.display(object.transpose());
					break;
				case 2:
					SparseMatrix object1 = new SparseMatrix(getInput());
					if (object1.isSymmetricalMatrix()) {
						System.out.println("Matrix is symmetric");
					} else
						System.out.println("Matrix is not symmteric");
					break;

				case 3:
					System.out.println("enter data fo first matrix");
					SparseMatrix object2 = new SparseMatrix(getInput());
					System.out.println("enter data for second matrix");
					SparseMatrix object3 = new SparseMatrix(getInput());
					System.out.println("addition is.. ");
					object2.display(object2.addSparseMatrix(object2, object3));//adding two matrixes and displaying them
					break;
				case 4:
					System.out.println("enter data fo first matrix");
					SparseMatrix object4 = new SparseMatrix(getInput());
					System.out.println("enter data for second matrix");
					SparseMatrix object5 = new SparseMatrix(getInput());
					System.out.println("multiplication is.. ");
					object4.display(object4. multiplySparseMatrix(object4, object5));//multiplying two matrixes and displaying them
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
