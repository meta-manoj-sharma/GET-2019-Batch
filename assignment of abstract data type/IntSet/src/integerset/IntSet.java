package integerset;

import java.util.*;
/**
 * this class perform various integer set operation
 * @author Manoj 
 * Dated 18 july 2019
 */
interface Set {
	int size();

	boolean isMember(int element);

	boolean isSubSet(IntSet s);

	int[] union(IntSet object1, IntSet object2);

	int[] getComplement();
}

public final class IntSet implements Set {
	private final int set[];

	// parameterized constructor to initialize the data member
	IntSet(int input[]) {
		// set = new int[input.length];
		set = input;
	}

	// private helper method to return the private data member
	public int[] getSet() {
		return this.set;
	}

	// returns the length of current set
	public int size() {
		return set.length;
	}

	/**
	 * @param element is to be search
	 * @return true and false according availability
	 */
	public boolean isMember(int element) {
		for (int i = 0; i < set.length; i++) {
			if (set[i] == element)
				return true;
		}
		return false;
	}

	/**
	 * @param s is subset to be check
	 * @return true and false according availability
	 */
	public boolean isSubSet(IntSet s) {
		int subset[] = s.getSet();
		int index1 = 0;
		int index2 = 0;
		for (index1 = 0; index1 < s.size(); index1++) {
			for (index2 = 0; index2 < set.length; index2++) {
				if (subset[index1] == set[index2]) // comparing element one by one
					break;
			}
			if (index2 == set.length)
				return false;
		}
		return true;
	}

	/**
	 * union method to compute the union set between two set
	 * @param reqiures two object of class IntSet
	 * @return the array of integer as the union set of two give set
	 */

	public int[] union(IntSet object1, IntSet object2) {
		int index1, index2, index3;
		boolean flag = false;
		int sum[] = new int[object1.size() + object2.size()];
		index3 = object1.size();
		int set2[] = object2.getSet();
		int set1[] = object1.getSet();
		for (index1 = 0; index1 < object1.size(); index1++) {
			sum[index1] = set1[index1];
		}
		for (index1 = 0; index1 < object2.size(); index1++) {
			flag = false;
			for (index2 = 0; index2 < object1.size(); index2++) {
				if (set2[index1] == sum[index2]) { // Storing common elements between two sets into a array list
					flag = true;
				}
			}
			if (flag == false) {
				sum[index3] = set2[index1];
				index3++;
			}
		}
		int[] union = new int[index3];
		for (index1 = 0; index1 < index3; index1++) {
			union[index1] = sum[index1];
		}
		return union;
	}

	/**
	 * getComplement method to find the complement of set assumes the universal
	 * set consist of integer values from 0 to 1000
	 * @return the complement set
	 */
	public int[] getComplement() {
		int length = size();
		int complement[] = new int[1000 - length];
		int index1, index2, index = 0;
		boolean found = false;

		for (index1 = 1; index1 <= 1000; index1++) {
			found = false;
			for (index2 = 0; index2 < length; index2++) { // comparing set with universal set to get complement of the set
				if (set[index2] == index1) {
					found = true;
					break;
				}
			}
			if (found == false) {
				complement[index++] = index1; // adding complement in new array name as complement
			}
		}
		return complement;
	}
}
