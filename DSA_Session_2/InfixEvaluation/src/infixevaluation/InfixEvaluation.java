package infixevaluation;

import java.util.*;

/**
 * program to evaluate infix expression
 * @author Manoj sharma 
 * Dated 30 july 2019
 */
public class InfixEvaluation {
	/**
	 * This method evaluates the infix expression using stack thereby returning top of stack
	 * @param expression is the Infix expression in String form
	 * @return the complete evaluation containing the result
	 * @throws Exception
	 * @throws NumberFormatException
	 */
	public static int evaluateInfix(String expression) throws Exception {
		String[] tokens = expression.split(" ");
		StackImplementation values = new StackImplementation();
		Stack<String> operator = new Stack<String>(); // Stack for Operators
		for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].equals("("))
					operator.push(tokens[i]);
				else if (tokens[i].equals(")")) {
					while (!operator.peek().equals("(")){
						values.push(operation(operator.pop(), values.pop(),values.pop()));
					}
					operator.pop();
				}
			/*
			 * While top of 'operator' has same or greater precedence to current
			 * token, which is an operator. Apply operator on top of 'operator'
			 * to top two elements in values stack
			 */
				else if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")
		              || tokens[i].equals("<") || tokens[i].equals(">") || tokens[i].equals("&") || tokens[i].equals("|")
					  || tokens[i].equals("==") || tokens[i].equals("<=") || tokens[i].equals(">=") || tokens[i].equals("&&")
					  || tokens[i].equals("||") || tokens[i].equals("!=")|| tokens[i].equals("!") || tokens[i].equals("^")) {
					while (!operator.empty() && hasPrecedence(tokens[i], operator.peek())){
						values.push(operation(operator.pop(), values.pop(),values.pop()));
					}
					operator.push(tokens[i]);
				} else
					values.push(Integer.parseInt(tokens[i]));
		}

		// Entire expression has been parsed at this point, apply remaining operator
		while (!operator.empty()){
			values.push(operation(operator.pop(), values.pop(), values.pop()));
		}
		return values.pop();
	}

	/**
	 * This method checks which operator has a higher precedence
	 * @param operator1 is the first operator
	 * @param operator2 is the second operator
	 * @return true if operator1 has lesser precedence than operator second otherwise returns false
	 */
	public static boolean hasPrecedence(String operator1, String operator2) {
		if (operator2.equals("(") || operator2.equals(")")){
			return false;
		}
		if ((operator1.equals("*") || operator1.equals("/")) && (operator2.equals("+") || operator2.equals("-"))){
			return false;
		}
		if ((operator1.equals("*") || operator1.equals("/") || operator1.equals("+") || operator1.equals("-"))
		 && (operator2.equals("<") || operator2.equals(">") || operator2.equals("<=") || operator2.equals(">="))){
			return false;
		}	
		if ((operator1.equals("*") || operator1.equals("/") || operator1.equals("+") || operator1.equals("-")
		  || operator1.equals("<") || operator1.equals(">") || operator1.equals("<=") || operator1.equals(">="))
		  && (operator2.equals("==") || operator2.equals("!="))){
			return false;
		}
		if ((operator1.equals("*") || operator1.equals("/") || operator1.equals("+") || operator1.equals("-")
		  || operator1.equals("<") || operator1.equals(">") || operator1.equals("<=") || operator1.equals(">=")
		  || operator1.equals("==") || operator1.equals("!=")) && (operator2.equals("&"))){
			return false;
		}
		if ((operator1.equals("*") || operator1.equals("/") || operator1.equals("+") || operator1.equals("-")
	      || operator1.equals("<") || operator1.equals(">") || operator1.equals("<=") || operator1.equals(">=")
		  || operator1.equals("==") || operator1.equals("!=") || operator1.equals("&")) && (operator2.equals("^"))){
			return false;
		}
		if ((operator1.equals("*") || operator1.equals("/") || operator1.equals("+") || operator1.equals("-")
		  || operator1.equals("<") || operator1.equals(">") || operator1.equals("<=") || operator1.equals(">=")
		  || operator1.equals("==") || operator1.equals("!=")|| operator1.equals("&") || operator1.equals("^"))
		  && (operator2.equals("|"))){
			return false;
		}
		if ((operator1.equals("*") || operator1.equals("/") || operator1.equals("+") || operator1.equals("-")
		  || operator1.equals("<") || operator1.equals(">") || operator1.equals("<=") || operator1.equals(">=")
		  || operator1.equals("==") || operator1.equals("!=")|| operator1.equals("&") || operator1.equals("^") 
		  || operator1.equals("|")) && (operator2.equals("&&"))){
			return false;
		}
		if ((operator1.equals("*") || operator1.equals("/") || operator1.equals("+") || operator1.equals("-")
		  || operator1.equals("<") || operator1.equals(">") || operator1.equals("<=") || operator1.equals(">=")
		  || operator1.equals("==") || operator1.equals("!=") || operator1.equals("&") || operator1.equals("^")
		  || operator1.equals("|") || operator1.equals("&&")) && (operator2.equals("||"))){
			return false;
		}
		else{
			return true;
		}
	}

	/**
	 * This method applies the operation after taking operator , firstNumber and secondNumber 
	 * @param operator is the char containing operator
	 * @param secondNumber is the integer value of second number
	 * @param firstNumber is the integer value of first number
	 * @return the result after applying the operation appropriately
	 */
	public static int operation(String operator, int secondNumber,int firstNumber) {
		switch (operator) {
		case "+":
			return firstNumber + secondNumber;
		case "-":
			return firstNumber - secondNumber;

		case "<":
			if (secondNumber < firstNumber)
				return 0;
			else
				return 1;
		case ">":
			if (firstNumber > secondNumber)
				return 1;
			else
				return 0;
		case "==":
			if (firstNumber == secondNumber)
				return 1;
			else
				return 0;
		case "!=":
			if (firstNumber == secondNumber)
				return 1;
			else
				return 0;
		case ">=":
			if (firstNumber >= secondNumber)
				return 1;
			else
				return 0;
		case "<=":
			if (firstNumber <= secondNumber)
				return 1;
			else
				return 0;
		case "&&":
			if (firstNumber > 0 && secondNumber > 0)
				return 1;
			else
				return 0;
		case "||":
			if (firstNumber > 0 || secondNumber > 0)
				return 1;
			else
				return 0;
		case "&":
			return (firstNumber & secondNumber);
		case "|":
			return (firstNumber | secondNumber);
		case "^":
			return (firstNumber ^ secondNumber);
		case "*":
			return firstNumber * secondNumber;
		case "/":
			try {
				if (secondNumber == 0)
					throw new Exception("Cannot divide by zero");
			} catch (Exception e) {
				System.out.println("Cant divide by 0");
			}
			return firstNumber / secondNumber;
		}
		return 0;
	}
}
