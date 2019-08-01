package infixevaluation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixEvaluation infixObject = new InfixEvaluation();
		try {
			System.out.println("value" +  infixObject.evaluateInfix("( 5 + ( 8 < 6 ) )"));
		} catch (Exception e) {
			System.out.println("Invalid expression");
		}
	}
}
