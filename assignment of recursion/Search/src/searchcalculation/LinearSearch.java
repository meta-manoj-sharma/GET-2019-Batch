package searchcalculation;

public class LinearSearch {
	/**
	 * giving searching element index
	 * @param array input elements array
	 * @param element to be search
	 * @param index position of element to be search
	 * @return position of searching element
	 */
public static int search(int array[], int element, int index){
	if(index == array.length){
		return -1;
	}
	else if(array[index] == element){  // checking for element 
		return index + 1;
	}
	else
		return search( array, element, index + 1); //linear search method using recursion
}
}
