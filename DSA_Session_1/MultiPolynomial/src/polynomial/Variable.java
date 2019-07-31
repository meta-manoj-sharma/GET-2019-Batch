package polynomial;
import java.util.*;
public class Variable {
	private char variableName;
	private int variablePower;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param variableName is the variable name x or y or z or etc.
	 * @param variablePower is the variable power
	 */
	Variable(char variableName, int variablePower)
	{
		this.variablePower  = variablePower;
		this.variableName = variableName;
	}

	/**
	 * This method returns the name of the variable
	 * @return String name of the variable
	 */
	public char getVariableName() {
		return variableName;
	}
	/**
	 * This method returns the power of the variable
	 * @return int power of the variable
	 */
	public int getVariablePower() {
		return variablePower;
	}
}
