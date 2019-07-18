/*
 * array operation program which has different methods of different functionality
 * each method is received positive integer
 * satisfied by positive and negative test cases
 */
package operation;
import java.util.*;
public class ArrayOperation {
	/**
	 * @param inputArray which is given by test cases
	 * @throws AssertionError throw when array is empty
	 */
	public static void checkNull(int inputArray[]) throws AssertionError {
		if (inputArray == null || inputArray.length == 0) {
			throw new AssertionError("Array is empty");
		}
	}

	/**
	 * @param inputArray is array of input integers
	 * @return size of largest mirror section
	 */
	public static int largestMirrorSection(int[] inputArray) {
		checkNull(inputArray); // to check that input array is null or not
		int[] reverseArray = new int[inputArray.length];
		int[][] resultArray = new int[inputArray.length + 1][inputArray.length + 1];
		int findingCounter = 0;
		for (int row = 0; row < inputArray.length; row++) {
			reverseArray[row] = inputArray[inputArray.length - 1 - row]; // reversing the input array which is give by user or test cases
		}
		for (int row = 1; row <= inputArray.length; row++) {
			for (int column = 1; column <= inputArray.length; column++) {
				if (reverseArray[row - 1] == inputArray[column - 1]) { // comparing the input array and reverse array one by one
					resultArray[row][column] = resultArray[row - 1][column - 1] + 1; // if elements are equal then adding the most before diagonal value
					findingCounter = (int) Math.max(findingCounter,
							resultArray[row][column]); // getting maximum number from the result array
				}
			}
		}
		return findingCounter; // returning maximum value from result array
	}

	/**
	 * @param inputArray is array of input integers which is given by test cases
	 * @return number of clumps occur in inputArray
	 */

	public static int numberOfClumps(int[] inputArray) {
		checkNull(inputArray);
		int countClumps = 0;
		int currentElement = -1; // initialize the current element -1 for comparing array element
		for (int row = 0; row < inputArray.length - 1; row++) {
			if (inputArray[row] == inputArray[row + 1]
					&& inputArray[row] != currentElement) { // comparing input array element with next element and before most element
				currentElement = inputArray[row]; // if condition true then assign current element with input array element
				countClumps++; // increase value of clumps
			} else if (inputArray[row] != inputArray[row + 1]
					&& inputArray[row] != currentElement) {
				currentElement = inputArray[row];
			}
		}
		return countClumps;
	}

	/**
	 * @param inputArray is array of inputs
	 * @param x number which respect to position of y is adjusted
	 * @param y number to be adjust
	 * @return fixed array after changes
	 * @throws AssertionError
	 */
	public static int[] fixXY(int[] inputArray, int x, int y) throws AssertionError {
		checkNull(inputArray);
		int[] indexOfX = new int[inputArray.length];
		int[] indexOfY = new int[inputArray.length];
		int counterOfX = 0;
		int counterOfY = 0;
		int temp = -1;
		for (int row = 0; row < inputArray.length; row++) {
			if (inputArray[row] == x) { // comparing x with input array elements and store their index in new array
				indexOfX[counterOfX] = row;
				counterOfX++;
			} else if (inputArray[row] == y) { // comparing y with input array elements and store their index in new array
				indexOfY[counterOfY] = row;
				counterOfY++;
			}
		}

		if (counterOfX != counterOfY) { // comparing number of x with number of y
			throw new AssertionError("No. of X and Y are not equal");
		} else if (indexOfX[counterOfX] == inputArray.length - 1) { // checking that the x is not the last element of array
			throw new AssertionError(
					"can't insert Y because X is last element of array ");
		}
		for (int row = 0; row < inputArray.length - 1; row++) { // checking for two adjacent x
			if (indexOfX[row + 1] == indexOfX[row] + 1) {
				throw new AssertionError(
						"can't insert Y because two X are adjacent");
			}
		}
		for (int row = 0; row < counterOfX; row++) {
			temp = inputArray[indexOfX[row] + 1];
			inputArray[indexOfX[row] + 1] = inputArray[indexOfY[row]]; // shuffling the y according position of x or next position of x
			inputArray[indexOfY[row]] = temp;
		}
		return inputArray;
	}

	/**
	 * @param inputArray array of input integers
	 * @return index at which the array can be split into two parts
	 * @throws AssertionError
	 */

	public static int splitArray(int[] inputArray) throws AssertionError {
		checkNull(inputArray);
		int sum = 0;
		int flag = 0;
		for (int row = 0; row < inputArray.length; row++) { // calculate the total sum of input array
			sum += inputArray[row];
		}
		for (int row = 0; row < inputArray.length; row++) { // checking the left values sum is equal with right value sum of array
			flag += inputArray[row];
			sum -= inputArray[row];
			if (sum == flag) {
				return row + 1; // returning the index where left sum is equal to right sum
			}
		}
		return -1;
	}
}
