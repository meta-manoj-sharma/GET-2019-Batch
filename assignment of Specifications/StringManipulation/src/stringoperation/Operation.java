package stringoperation;

public class Operation {
	/**
	 * This method is used to compare two Strings
	 * @param first is the first String to be compared
	 * @param second is the second String to be compared
	 * @return 1 if the two Strings are equals and 0 if the Strings are not equal
	 */
		
	public int stringCompare(String first, String second) {
			int count = 0;
			if (first == null || second == null) {
				return 0;
			} else if (first.length() != second.length()) {
				return 0;
			} else {
				for (int i = 0; i < first.length(); i++) {
					if (first.charAt(i) == second.charAt(i)) {
						count++;
					}
				}
				if (count == first.length())  //checking 
					return 1;
				else
					return 0;
			}
		}
	/**
	 * This method is used to calculate the reverse of any String 
	 * @param value is the String to be reversed
	 * @return the reversed String of the given String
	 */
	public String reverseOfString(String value) {
			String reversedValue = "";
			for (int j = 0; j < value.length(); j++) {
				reversedValue = value.charAt(j) + reversedValue;
			}
			return reversedValue;
		}
	/**
	 * This method is used to change lowercase into uppercase and vice-versa
	 * @param value is the String whose case is to be changed
	 * @return the String with its case changed
	 */
		public String changeCase(String value) {
			String result = "";
			for (int i = 0; i < value.length(); i++) {
				if (value.charAt(i) >= 'A' && value.charAt(i) <= 'Z') {
					result += (char) ((int) value.charAt(i) + 32); // getting lower case ASCII value of lower case and typecast it
				} else if (value.charAt(i) >= 'a' && value.charAt(i) <= 'z') {
					result += (char) ((int) value.charAt(i) - 32);
				} else {
					result += " ";
				}
			}

			return result;
		}
	/**
	 * This method calculates the largest word in the given String	
	 * @param value is the String containing the complete sentence
	 * @return is the String containing the largest word
	 */
		public String largestString(String value) {
			value = value + " ";
			String word = "";
			String maximumString = "";

			for (int k = 0; k < value.length(); k++) {
				word = word + value.charAt(k);
				// System.out.println("MAXX "+word);
				if (value.charAt(k) == ' ') {
					if (word.length() >= maximumString.length()) {
						maximumString = word;
					}
					word = "";
				}
			}
			return maximumString;
		}
}
