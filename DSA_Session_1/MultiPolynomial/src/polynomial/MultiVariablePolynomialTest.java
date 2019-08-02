package polynomial;
import java.util.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MultiVariablePolynomialTest {

	List<Term> termList = new ArrayList<>();
	
	/**
	 * This method initializes the term list before any test is executed
	 */
	@Before
	public void initialize()
	{
		List<Variable> variable1 = new ArrayList<>();
		variable1.add(new Variable('x', 2));
		variable1.add(new Variable('y', 1));
		variable1.add(new Variable('z', 1));
		
		List<Variable> variable2 = new ArrayList<>();
		variable2.add(new Variable('x', 3));
		variable2.add(new Variable('y', 2));
		
		Term term1 = new Term(4, variable1);
		Term term2 = new Term(3, variable2);
		
		termList.add(term1);
		termList.add(term2);
	}
	
	//Test method to test visualizePolynomial method
	@Test
	public void testVisualizePolynomial()
	{
		MultiVariablePolynomial polynomialObject = new MultiVariablePolynomial(termList);
		String polynomialString = polynomialObject.visualPolynomial();
		String expectedPolynomial = "4*x^2*y^1*z^1 + 3*x^3*y^2";
		assertEquals(expectedPolynomial, polynomialString);
	}

	//Test method to test degreeOfPolynomial method
	@Test
	public void testDegreeOfPolynomial()
	{
		MultiVariablePolynomial polynomialObject = new MultiVariablePolynomial(termList);
		assertEquals(5, polynomialObject.polynomialDegree());
	}
}
