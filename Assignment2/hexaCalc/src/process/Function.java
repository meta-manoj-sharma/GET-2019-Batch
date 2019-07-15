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
	 * 
	 * @param first string number
	 * @return non zero contain num in front
	 */
	public String removeZeros(String first) {
		first = first.replaceAll("^(\\s*0\\s*0\\s*)+", "");
		return first;
	}

	/**
	 * 
	 * @param value character get
	 * @return integer equivalent of char or string
	 */
	public int integerEquivalent(char value) {
		if (value >= '0' && value <= '9')
			return (int) (value) - '0';
		else
			return (int) (value) - 'A' + 10;

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
		} else {
			System.out
					.println("number 1 cant be less than number 2.....program exit");
			return 0;
		}
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
		if (first > second) {
			return (first / second);
		} else {
			System.out
					.println("number 1 cant be less than number 2.....program exit");
			return 0;
		}

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

	public int convertToDecimal(String hexNumber, int base) {
		int decimal = 0;
		for (int i = hexNumber.length() - 1; i >= 0; i--) {
			decimal += (int) (integerEquivalent(hexNumber.charAt(i)) * pow(
					base, hexNumber.length() - 1 - i));
		}
		return decimal;
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

}
