package process;
import java.util.*;
import java.lang.Math;
interface Methods{
	public int pow (int base,int length);
	int convertToDecimal(char []num,int length);
	String convertFromDecimal(int number);
	int add(int first,int  second);
	int  subtract(int first,int  second);
	int  multiply(int first,int  second);
	int  divide(int first,int  second);
	boolean equalsTo(String s1,String s2);
	boolean greaterThen();
	boolean lessThen();
	
}
public class Function implements Methods {
	
	public int pow (int base,int length) {
		int power=1;
		for(int i=0;i<length;i++) {
			power=power*base;
		}
		return power;
	}
	public int add(int first,int  second) {
		return (first+second);
	}
	public int subtract(int first,int  second) {
		if(first>second) {
			return (first-second);
		}
		else
		return second-first;
	}
	public int multiply(int first,int  second) {
		return (first*second);
	}
	public int divide(int first,int  second) {
		
			return(first/second);
	}
	public boolean equalsTo(String s1,String s2) {
		 if(s1==null || s2==null){
	            return false;
	        }
	        //compare lengths
	        if(s1.length()!=s2.length())
	            return false;

	        //compare all characters
	        for (int i = 0; i <s1.length() ; i++) {
	            if(s1.charAt(i)!=s2.charAt(i))
	                return false;
	        }
	        //if here, means both strings are equal
	        return true;
	
	}
	public boolean greaterThen() {
		return true;
	}
	public boolean lessThen() {
		return true;
	}
	public int convertToDecimal(char []num,int length){
		final int base=16;
		int deciNum=0;
		for(int i=0;i<length;i++) {
			if(num[i]=='0') {deciNum=deciNum+(pow(base,length-1-i)*0);}
			else if(num[i]=='1') {deciNum=deciNum+(pow(base,length-1-i)*1);}
			else if(num[i]=='2') {deciNum=deciNum+(pow(base,length-1-i)*2);}
			else if(num[i]=='3') {deciNum=deciNum+(pow(base,length-1-i)*3);}
			else if(num[i]=='4') {deciNum=deciNum+(pow(base,length-1-i)*4);}
			else if(num[i]=='5') {deciNum=deciNum+(pow(base,length-1-i)*5);}
			else if(num[i]=='6') {deciNum=deciNum+(pow(base,length-1-i)*6);}
			else if(num[i]=='7') {deciNum=deciNum+(pow(base,length-1-i)*7);}
			else if(num[i]=='8') {deciNum=deciNum+(pow(base,length-1-i)*8);}
			else if(num[i]=='9') {deciNum=deciNum+(pow(base,length-1-i)*9);}
			else if(num[i]=='a'||num[i]=='A') {deciNum=deciNum+(pow(base,length-1-i)*10);}
			else if(num[i]=='b'||num[i]=='B') {deciNum=deciNum+(pow(base,length-1-i)*11);}
			else if(num[i]=='c'||num[i]=='C') {deciNum=deciNum+(pow(base,length-1-i)*12);}
			else if(num[i]=='d'||num[i]=='D') {deciNum=deciNum+(pow(base,length-1-i)*13);}
			else if(num[i]=='e'||num[i]=='E') {deciNum=deciNum+(pow(base,length-1-i)*14);}
			else if(num[i]=='f'||num[i]=='F') {deciNum=deciNum+(pow(base,length-1-i)*15);}
			else {
				System.out.println("Wrong number......program exit..");
				System.exit(0);
			}
					}
		return deciNum;
	}
	public String convertFromDecimal(int number) {
		int remainder=0;
		String hexadecimal="";
		  char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		  
		     while(number>0)
		     {
		       remainder=number%16; 
		       hexadecimal=hex[remainder]+hexadecimal; 
		       number=number/16;
		     }
		return hexadecimal;
	}
	public int stringToNum (String hexa) {
		//Function object=new Function();
		char[] hexNum=new char[hexa.length()];
		 for (int i = 0; i < hexa.length(); i++) { 
	            hexNum[i] = hexa.charAt(i); 
	        } 
		 int num=convertToDecimal(hexNum, hexa.length());
		return num;
	}
	
}