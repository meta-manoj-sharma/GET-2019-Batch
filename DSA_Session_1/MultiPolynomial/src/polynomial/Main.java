package polynomial;
import java.io.InputStream;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		List<Term> termList = new ArrayList<>();
		List<Variable> variable1 = new ArrayList<>();
		variable1.add(new Variable('x', 2));
		variable1.add(new Variable('y', 1));
		variable1.add(new Variable('z', 1));
		
		List<Variable> variable2 = new ArrayList<>();
		variable2.add(new Variable('x', 3));
		variable2.add(new Variable('y', 2));
		List<Variable> variable3 = new ArrayList<>();
		variable3.add(new Variable('x', -5));
		variable3.add(new Variable('y', -7));
		variable3.add(new Variable('z', -3));
		variable3.add(new Variable('u', 1));
		variable3.add(new Variable('v', 0));
		variable3.add(new Variable('w', 2));
		Term term1 = new Term(4, variable1);
		Term term2 = new Term(3, variable2);
		Term term3 = new Term(15, variable3);
		
		termList.add(term1);
		termList.add(term2);
		termList.add(term3);
		
		MultiVariablePolynomial object = new MultiVariablePolynomial(termList);
		String expresion = object.visualPolynomial();
		System.out.println("Multivariable Polynomial = " + expresion);
		System.out.println("Degree = " + object.polynomialDegree());
	}
	catch(Exception e){
		System.out.println("Invalid parameters program end ......");
	}	
	}

	private static void Scanner(InputStream in) {
		// TODO Auto-generated method stub
		
	}
	

	}


