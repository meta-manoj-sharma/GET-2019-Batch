package polynomial;

import java.util.*;

/**
 * this program is to visualize the polynomial and find out the degree 
 * @author Manoj Sharma 
 * Dated 31 july 2019
 */
public class MultiVariablePolynomial {
	List<Term> termList = new ArrayList<>();

	public MultiVariablePolynomial(List<Term> termList) {

		this.termList = termList;
	}

	/**
	 * Method to calculate the degree of the multivariable polynomial
	 * @return int degree of the multivariable polynomial
	 */
	int polynomialDegree() {
		int variablePowerSum;
		int degreeOfPolynomial = 0;
		for (int i = 0; i < termList.size(); i++) {
			variablePowerSum = 0;
			for (int j = 0; j < termList.get(i).variableList.size(); j++) {
				variablePowerSum += termList.get(i).variableList.get(j).getVariablePower();
			}
			if (degreeOfPolynomial < variablePowerSum)
				degreeOfPolynomial = variablePowerSum;
		}
		return degreeOfPolynomial;
	}

	/**
	 * This method visualize the Multivariable polynomial into string
	 * @return String Multivariable Polynomial
	 */
	String visualPolynomial() {
		String polynomialString = "";
		for (int i = 0; i < termList.size(); i++) {
			if(termList.get(i).termCoefficient != 0){
				polynomialString = polynomialString+ termList.get(i).termCoefficient;
			for (int j = 0; j < termList.get(i).variableList.size(); j++) {
				polynomialString = polynomialString+ "*"+termList.get(i).variableList.get(j).getVariableName()+ "^"+ termList.get(i).variableList.get(j).getVariablePower();
			}
			if (termList.get(i) != termList
					.get(termList.size() - 1))
				polynomialString = polynomialString + " + ";
			}
		}
		return polynomialString;
	}
}
