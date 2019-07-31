package polynomial;

import java.util.*;

/**
 * this program is to visualize the polynomial and find out the degree 
 * @author Manoj Sharma 
 * Dated 31 july 2019
 */
public class MultiVariablePolynomial {
	List<Term> MultiVariablePolynomial = new ArrayList<>();

	public MultiVariablePolynomial(List<Term> termList) {

		this.MultiVariablePolynomial = termList;
	}

	/**
	 * Method to calculate the degree of the multivariable polynomial
	 * @return int degree of the multivariable polynomial
	 */
	int polynomialDegree() {
		int variablePowerSum;
		int degreeOfPolynomial = 0;
		for (int i = 0; i < MultiVariablePolynomial.size(); i++) {
			variablePowerSum = 0;
			for (int j = 0; j < MultiVariablePolynomial.get(i).variableList.size(); j++) {
				variablePowerSum += MultiVariablePolynomial.get(i).variableList.get(j).getVariablePower();
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
		for (int i = 0; i < MultiVariablePolynomial.size(); i++) {
			polynomialString = polynomialString+ MultiVariablePolynomial.get(i).termCoefficient;
			for (int j = 0; j < MultiVariablePolynomial.get(i).variableList.size(); j++) {
				polynomialString = polynomialString+ "*"+ MultiVariablePolynomial.get(i).variableList.get(j).getVariableName()+ "^"+ MultiVariablePolynomial.get(i).variableList.get(j).getVariablePower();
			}
			if (MultiVariablePolynomial.get(i) != MultiVariablePolynomial
					.get(MultiVariablePolynomial.size() - 1))
				polynomialString = polynomialString + " + ";
		}
		return polynomialString;
	}
}
