package queen;
/**
 * this program set queens to safest places where no other queen can attack other queen
 * @author Manoj
 * Dated 17 july 2019
 */
public class NQueen {
	/**
	 * this function print resultant array where each queen places one place and attack by no other queen
	 * @param array position of queens
	 * @param noOfQueen number of queen
	 */
	private static void printSolution(int array[][], int noOfQueen) {
		try {
			if (array.length == 0 || array == null) {
				throw new Exception("Empty Array");
			}
		} catch (Exception e) {
			System.out.println("Empty Array passed");
		}
		for (int i = 0; i < noOfQueen; i++) {
			for (int j = 0; j < noOfQueen; j++)
				System.out.print(array[i][j] + " ");  //printing solution array
			System.out.println();
		}
		System.out.println("");
	}
/**
 * @param array in which queens are to be placed
 * @param row at which we have to check positions
 * @param column at which we have to check positions
 * @param noOfQueen number of queen
 * @return safest palace in board where queens can be move
 */
	private boolean isCheck(int[][] array, int row, int column, int noOfQueen) {
		for (int i = 0; i < column; i++) 
			if (array[row][i] == 1) //starting with left side and checking row
				return false;
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--)  //checking lower diagonal places
			if (array[i][j] == 1)
				return false;
		for (int i = row, j = column; j >= 0 && i < noOfQueen; i++, j--)// checking upper diagonal places
			if (array[i][j] == 1)
				return false;
		return true;
	}
/**
 * @param array in which queens are to be placed
 * @param row at which we have to check positions
 * @param noOfQueen number of queen
 * @return places where queen is placed
 */
	public boolean findPlaces(int array[][], int row, int noOfQueen) {
		if (row == noOfQueen) {
			printSolution(array, noOfQueen);
			return true;
		}
		boolean isSolve = false;

		for (int i = 0; i < noOfQueen; i++) {

			if (isCheck(array, i, row, noOfQueen)) {  //to check safe palace for queen
				array[i][row] = 1;
				isSolve = findPlaces(array, row + 1, noOfQueen); //recursion to move next step in queen placing
				array[i][row] = 0;
				if (isSolve == true) {
					return true;
				}
			}
		}
		return isSolve;
	}
}