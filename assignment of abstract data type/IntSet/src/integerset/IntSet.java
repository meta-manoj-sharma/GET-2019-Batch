package integerset;

import java.util.*;
/**
 * this class perform various integer set operation
 * @author Manoj
 * Dated 18 july 2019
 */
public class IntSet {
	private int set[];

	// parameterized constructor to initialize the data member
	IntSet(int input[]) {
		set = new int[input.length];
		set = input;
	}

	// private helper method to return the private data member
	private int[] getSet() {
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
				if (subset[index1] == set[index2]) // comparing element one by
													// one
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

	public static int[] union(IntSet object1, IntSet object2) {
		int index1, index2, length1, length2, maxLength;
		int set1[] = object1.getSet();
		int set2[] = object2.getSet();
		length1 = object1.size();
		length2 = object2.size();

		List<Integer> newList = new ArrayList<Integer>(); // for storing union

		for (index1 = 0; index1 < length1; index1++) {
			for (index2 = 0; index2 < length2; index2++) {
				if (set1[index1] == set2[index2]) // Storing common elements between two sets into a array list
					newList.add(set1[index1]);
			}
		}
		int[] unionSet = new int[(length1 + length2) - newList.size()];
		int indexUnion = 0;
		for (int index = 0; index < length1; index++) {
			if (!newList.contains(set1[index])) {
				unionSet[indexUnion++] = set1[index]; // storing rest elements of set 1 in union array
			}
		}
		for (int index = 0; index < length2; index++) {
			if (!newList.contains(set2[index])) {
				unionSet[indexUnion++] = set2[index]; // storing rest elements of set 1 in union array
			}
		}
		for (int index = 0; index < newList.size(); index++)
			unionSet[indexUnion++] = newList.get(index); // storing common elements to the array
		return unionSet;
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
