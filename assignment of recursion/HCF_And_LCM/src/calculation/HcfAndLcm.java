package calculation;

/**
 * program to calculate HCF and LCM of two numbers
 * @author Manoj 
 * dated 17 july 2019
 */
public class HcfAndLcm {
	int lcm, hcf;

	/**
	 * @param first number 1 which has to be operated
	 * @param second number 2 which has to be operated
	 * @return highest common factor of two numbers
	 */
	public int highestCommonFactor(int first, int second) {
		hcf = gcd(first, second);
		return hcf;
	}

	/**
	 * @param first number 1 which has to be operated
	 * @param second number 2 which has to be operated
	 * @return least common factor of two methods
	 * @throws AssertionError
	 */
	public int leastCommonMultiple(int first, int second) throws AssertionError {
		if (first == 0 || second == 0) {
			throw new AssertionError("Number can't be zero");
		}
		lcm = (first * second) / gcd(first, second);
		return lcm;
	}

	/**
	 * @param first number 1 which has to be operated
	 * @param second number 2 which has to be operated
	 * @return greatest common division
	 */
	public int gcd(int first, int second) {
		if (first == 0) {
			return second;
		} else
			return gcd(second % first, first); //recursion
	}

}
