package searchcalculation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		while(true){
		Scanner input = new Scanner(System.in);
		int num;
		int index;
		int lowerIndex,element,ch;
		System.out.println("enter length of array");
		num = input.nextInt();
		int array[] = new int [num];
		System.out.println("enter elements of array in asscending order in case of binary search");
		for(int i = 0; i < num; i++){
			array[i] = input.nextInt();
		}
		System.out.println("enter element to be seach");
		element = input.nextInt();
		BinarySearch b = new BinarySearch();
		LinearSearch a = new LinearSearch();
		index = 0;
		lowerIndex = 0;
		System.out.println("Press 1 for Binary search");
		System.out.println("Press 2 for linear search");
		System.out.println("Press 3 for exit");
		ch = input.nextInt();
		switch(ch){
		case 1:
		System.out.println("Index " + b.search(array, lowerIndex,num,element));
		break;
		case 2:
		System.out.println("Index " + a.search(array,element,index));
		break;
		case 3:
		System.exit(0);
		}
	}
		}
	catch (Exception e){
		System.out.println("Invalid input");
		main(args);
	}
	}
}

