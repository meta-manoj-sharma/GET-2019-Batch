package infixevaluation;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixEvaluationTest {

	@Test
	public void testEvaluateInfix1() throws Exception {
		int actual = InfixEvaluation.evaluateInfix("( 5 + ( 8 > 6 ) )");
		int expected = 6;
		assertEquals(expected, actual);
	}

	@Test
	public void testEvaluateInfix2() throws Exception {
		int actual = InfixEvaluation.evaluateInfix("100 * 2 + 12");
		int expected = 212;
		assertEquals(expected, actual);
	}

	@Test
	public void testEvaluateInfix3() throws Exception {
		int actual = InfixEvaluation.evaluateInfix("( 100 * ( 2 + 12 ) / 14 )");
		int expected = 100;
		assertEquals(expected, actual);
	}
	// negative test case
	@Test(expected = Exception.class)
	public void testEvaluateInfix4() throws Exception {
		 InfixEvaluation.evaluateInfix("( 100 * 2( 2 + 12 ) / 14 )");
	}
}
