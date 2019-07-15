package process;
import java.util.*;
public class Calculator {

	public static void main(String[] args) {
		try {
		Scanner scan=new Scanner(System.in);
		 int flag=1;
		 do {
		
		 System.out.println("Enter first hexadecimal no. ");
		String in1=scan.next();
		System.out.println("Enter second hexadecimal no. ");
		String in2=scan.next();
		String input1=in1.toUpperCase();
		String input2=in2.toUpperCase();
		String hexadecimal=new String();
		Function object=new Function();
			 int num1=object.stringToNum(input1);
			 int num2=object.stringToNum(input2);
			 System.out.println("press 1 add ");
			 System.out.println("press 2 subtract ");
			 System.out.println("perss 3 multiply");
			 System.out.println("press 4 divide ");
			 System.out.println("press 5 compare");
			 System.out.println("press 6 checking grater than and less than ");
			 System.out.println("press 7 Exit");
			 System.out.println("Enter your choice..... ");
			 int choice=scan.nextInt();
				
			 switch(choice) {
			 case 1:
				 
				 int result=object.add(num1, num2);
				 hexadecimal=object.convertFromDecimal(result);
				 System.out.println("additon is = "+hexadecimal);
				 break;
			 case 2:
				  result=object.subtract(num1, num2);
				 hexadecimal=object.convertFromDecimal(result);
				 System.out.println("subtraction is = "+hexadecimal);
				 break;
			 case 3:
				  result=object.multiply(num1, num2);
				 hexadecimal=object.convertFromDecimal(result);
				 System.out.println("multiplication is = "+hexadecimal);
				 break;
			 case 4:
				 result=object.divide(num1, num2);
				 if(num2==0) {
					 System.out.println("can't divide by 0");
					 break;
				 }
				 else {
				 hexadecimal=object.convertFromDecimal(result);
				 System.out.println("division is = "+hexadecimal);
				 break;
				 } 
				 case 5:
					  boolean res=object.equalsTo(input1,input2);
					  if(res==true) {
						  System.out.println("number1==number2");
							 break;
					  }
					  else {
	                     System.out.println("number1!=number2");
						 break;
						 }
			 case 7:
				 System.out.print("Thank you....");
				 System.exit(0);
			 }
			 }while(flag==1);
	
		}
		catch(Exception e) {
			System.out.print("Invalid entry....enter again");
			main(args);
		}
	}

}