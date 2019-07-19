package searchcalculation;

public class BinarySearch {
	int middleIndex;
/**
 * give the index of searching element
 * @param array elements array
 * @param lowerBound lower index of array
 * @param higherBound upper index of array
 * @param element to be search
 * @return position of element to be search
 */
	public int search(int array[], int lowerBound, int higherBound, int element) {
		middleIndex = lowerBound + (higherBound - lowerBound) / 2;  //to find middle index of sorted array
		if (lowerBound > higherBound) {
			return -1;
		} else if (lowerBound <= higherBound) {

			if (array[middleIndex] == element) {  // comparing for array element
				return middleIndex + 1;
			} else if (array[middleIndex] > element) {
				higherBound = middleIndex - 1;   //reseting upper index
				search(array, lowerBound, higherBound, element);
			} else if (array[middleIndex] < element) {
				lowerBound = middleIndex + 1;  //reseting lower index
				search(array, lowerBound, higherBound, element);
			}
		}
		return middleIndex + 1;
	}
}