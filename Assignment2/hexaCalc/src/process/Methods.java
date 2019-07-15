package process;

import java.util.*;
import java.lang.Math;
/**
 * 
 * @author Admin interface for future use for different base number
 *
 */
interface Methods {
	public int pow(int base, int length);

	int convertToDecimal(String hexNumber, int base);

	String convertFromDecimal(int number);

	int add(int first, int second);

	int subtract(int first, int second);

	int multiply(int first, int second);

	int divide(int first, int second);

	boolean equalsTo(String s1, String s2);

	boolean greaterThen(String first, String second);

}
