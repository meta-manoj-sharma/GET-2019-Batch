package polynomial;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Polynomial class store the coefficients of polynomial equation It requires
 * the array of integer in constructor which contains the coefficients with
 * index as their degree
 * @author Manoj 
 * Dated 18 july 2019
 */
interface Poly {
	void display(int[] polynomial);

	public int degree();

	float evaluate(float value);

	int[] addPoly(Polynomial p1, Polynomial p2);

	int[] mulPoly(Polynomial p1, Polynomial p2);
}

public final class Polynomial {

	private final int poly[][];

	// parameterized constructor which store non zero coefficients
	Polynomial(int inputPoly[]) {
		int index, count = 0, row = 0, column = 0;
		// loop to count number of zeroes in the polynomial
		for (index = 0; index < inputPoly.length; index++) {
			if (inputPoly[index] == 0) {
				count++;
			}
		}
		int length = inputPoly.length - count;
		poly = new int[length][column + 2];
		// the value to the matrix with corresponding degrees
		for (index = 0; index < inputPoly.length; index++)
			if (inputPoly[index] != 0 && row < length) {
				poly[row][column] = inputPoly[index];
				poly[row++][column + 1] = index;
			}
	}

	/**
	 * this is display the polynomial 
	 * @param polynomial
	 */
	public void display(int[] polynomial) {
		int i = 0;
		for (i = 0; i < polynomial.length; i++) {
			System.out.print(polynomial[i] + " ");
		}
	}

	/**
	 * @return the maximum degree of the polynomial
	 */
	public int degree() {
		int row;
		int column = 1;
		int length = poly.length;
		int maxDegree = 0;
		for (row = 0; row < length; row++) {
			if (maxDegree < poly[row][column]) {
				maxDegree = poly[row][column];
			}
		}
		return maxDegree;
	}

	/**
	 * evaluate the polynomial with the given input value
	 * @return the calculated result
	 */
	public float evaluate(float value) {
		float result = 0.0f;
		int column = 0, index;
		// evaluates the polynomial function for given value
		for (index = 0; index < poly.length; index++) {
			result = result + (float) Math.pow(value, poly[index][column + 1])
					* poly[index][column];
		}
		return result;
	}
	/**
	 * @param poly polynomial array
	 * @param coefficient array list of coefficient
	 * @param degree array list of degree
	 * @return array of polynomial
	 */

	private static int[] convertArray(int[] poly, ArrayList<Integer> coefficient, ArrayList<Integer> degree) {
		for (int index = 0; index < poly.length; index++) {
			if (degree.contains(index)) {
				int pos = degree.indexOf(index);
				poly[index] = coefficient.get(pos);
			} else {
				poly[index] = 0;
			}
		}
		return poly;
	}

	/**
	 * addPoly method to add two polynomial 
	 * @param P1 and P2 to store polynomial
	 * @return an integer array which contain result of addition polynomial
	 */
	public int[] addPoly(Polynomial p1, Polynomial p2) {
		ArrayList<Integer> coefficient = new ArrayList<Integer>();
		ArrayList<Integer> degree = new ArrayList<Integer>();
		int index, column = 0;
		// checks for same degree coefficients and store in arraylist
		// coefficients
		for (index = 0; index < p1.poly.length; index++) {
			for (int j = 0; j < p2.poly.length; j++) {
				if (p1.poly[index][column + 1] == p2.poly[j][column + 1]) {
					coefficient
							.add(p1.poly[index][column] + p2.poly[j][column]);
					degree.add(p1.poly[index][column + 1]);
					break;
				}
			}
		}

		// checks for remaining elements in polynomial 1 which are not added in
		// coefficients array list
		for (index = 0; index < p1.poly.length; index++) {
			if (!degree.contains(p1.poly[index][column + 1])) {
				coefficient.add(p1.poly[index][column]);
				degree.add(p1.poly[index][column + 1]);
			}
		}

		// checks for remaining elements in polynomial 2 which are not added in
		// coefficients arraylist
		for (index = 0; index < p2.poly.length; index++) {
			if (!degree.contains(p2.poly[index][column + 1])) {
				coefficient.add(p2.poly[index][column]);
				degree.add(p2.poly[index][column + 1]);
			}
		}
		// converting it back to the array in 1D
		int[] addPoly = new int[Collections.max(degree) + 1];
		addPoly = convertArray(addPoly, coefficient, degree);
		return addPoly;
	}

	/**
	 * multiply the two polynomial
	 * 
	 * @param requires the two object of polynomial class which contains the polynomial coefficients
	 * @return the integer array which contains the coefficients if multiplied polynomial
	 */
	public int[] mulPoly(Polynomial p1, Polynomial p2) {

		ArrayList<Integer> coefficient = new ArrayList<Integer>();
		ArrayList<Integer> degree = new ArrayList<Integer>();
		int sum, index, column = 0;

		// multiplies every term of first polynomial to each term of second
		// polynomial
		for (index = 0; index < p1.poly.length; index++) {
			for (int j = 0; j < p2.poly.length; j++) {
				coefficient.add(p1.poly[index][column] * p2.poly[j][column]);
				degree.add(p1.poly[index][column + 1] + p2.poly[j][column + 1]);
			}
		}

		// two array list to calculated coefficients and degree
		ArrayList<Integer> finalCofficient = new ArrayList<Integer>();
		ArrayList<Integer> finalDegree = new ArrayList<Integer>();

		// for adding the term of same degree
		for (index = 0; index < degree.size(); index++) {
			sum = 0;
			if (!finalDegree.contains(degree.get(index))) {
				for (int j = index; j < degree.size(); j++) {
					if (degree.get(index) == degree.get(j)) {
						sum = sum + coefficient.get(j);
					}
				}
				finalCofficient.add(sum);
				finalDegree.add(degree.get(index));
			}
		}
		int[] mulPoly = new int[Collections.max(finalDegree) + 1];
		mulPoly = convertArray(mulPoly, finalCofficient, finalDegree);
		return mulPoly;
	}
}
