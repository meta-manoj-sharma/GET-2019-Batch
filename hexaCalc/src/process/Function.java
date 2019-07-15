package process;

public class Function implements Methods {
/**
 * @param take base and length of hexadecimal no.
 * @return power of base no.
 */
	public int pow(int base, int length) {
		int power = 1;
		for (int i = 0; i < length; i++) {
			power = power * base;
		}
		return power;
	}
/**
 * @param two integer decimal no.
 * @return integer addition of number
 */
	public int add(int first, int second) {
		return (first + second);
	}
	/**
	 * @param two integer decimal no.
	 * @return integer subtract of number
	 */
	public int subtract(int first, int second) {
		if (first > second) {
			return (first - second);
		} else
			return second - first;
	}
	/**
	 * @param two integer decimal no.
	 * @return integer multiplication of number
	 */

	public int multiply(int first, int second) {
		return (first * second);
	}
	/**
	 * @param two integer decimal no.
	 * @return integer division of number
	 */
	public int divide(int first, int second) {

		return (first / second);
	}
	/**
	 * @param two strings of hexadeimal no.
	 * @return boolean result 
	 */
	public boolean equalsTo(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		// compare lengths
		if (s1.length() != s2.length())
			return false;

		// compare all characters
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				return false;
		}
		// if here, means both strings are equal
		return true;

	}
	/**
	 * @param two strings of hexadeimal no.
	 * @return boolean result 
	 */
	public boolean greaterThen(String first, String second) {
		int counter1 = 0;
		int counter2 = 0;

		if (first.length() == second.length()) {
			for (int i = 0; i < first.length(); i++) {
				if (first.charAt(i) > second.charAt(i)) {
					counter1++;
				}
			}

			if (counter1 > 0) {
				return true;
			} else {
				return false;

			}

		} else {
			/*
			 * This regular expression removes all the leading 0's from
			 * Hexadecimal number for unequal length comparision
			 */

			first = first.replaceAll("^(\\s*0\\s*0\\s*)+", "");
			second = second.replaceAll("^(\\s*0\\s*0\\s*)+", "");
			if (first.length() > second.length()) {
				counter2++;
			}

		}
		if (counter2 > 0) {
			return true;
		} else {
			return false;

		}

	}
	/**
	 * @param character array and length of the number string
	 * @return integer decimal number
	 */

	public int convertToDecimal(char[] num, int length) {
		final int base = 16;
		int deciNum = 0;
		for (int i = 0; i < length; i++) {
			if (num[i] == '0') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 0);  // get power of base number according to position 
			} else if (num[i] == '1') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 1);
			} else if (num[i] == '2') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 2);
			} else if (num[i] == '3') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 3);
			} else if (num[i] == '4') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 4);
			} else if (num[i] == '5') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 5);
			} else if (num[i] == '6') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 6);
			} else if (num[i] == '7') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 7);
			} else if (num[i] == '8') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 8);
			} else if (num[i] == '9') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 9);
			} else if (num[i] == 'A') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 10);
			} else if (num[i] == 'B') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 11);
			} else if (num[i] == 'C') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 12);
			} else if (num[i] == 'D') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 13);
			} else if (num[i] == 'E') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 14);
			} else if (num[i] == 'F') {
				deciNum = deciNum + (pow(base, length - 1 - i) * 15);
			} else {
				System.out.println("Wrong number......program exit..");
				System.exit(0);
			}
		}
		return deciNum;
	}
	/**
	 * @param integer number 
	 * @return hexadecimal number string
	 */
	public String convertFromDecimal(int number) {
		int remainder = 0;
		String hexadecimal = "";
		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };

		while (number > 0) {
			remainder = number % 16;
			hexadecimal = hex[remainder] + hexadecimal;
			number = number / 16;
		}
		return hexadecimal;
	}
	/**
	 * 
	 * @param hexadecimal number string
	 * @return decimal nuumber
	 */
	public int stringToNum(String hexa) {
		// Function object=new Function();
		char[] hexNum = new char[hexa.length()];
		for (int i = 0; i < hexa.length(); i++) {
			hexNum[i] = hexa.charAt(i);
		}
		int num = convertToDecimal(hexNum, hexa.length());   //to convert hexadecimal no. into decimal number
		return num;
	}
}
