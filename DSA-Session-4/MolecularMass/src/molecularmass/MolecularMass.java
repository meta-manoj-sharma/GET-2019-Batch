package molecularmass;

import java.util.*;

/**
 * program to get molecular mass of a organic compound
 * @author Manoj Sharma
 * Dated 1 august 2019
 */
public class MolecularMass {
	private Map<Character, Integer> element;
	private Stack<Integer> operation;
	private Stack<Integer> subCompoundOperate;

	/**
	 * constructor to elements in list
	 */
	public MolecularMass() {
		element = new HashMap<Character, Integer>();
		element.put('C', 12);
		element.put('O', 16);
		element.put('H', 1);

		operation = new Stack<Integer>();
		subCompoundOperate = new Stack<Integer>();
	}

	/**
	 * @param compound is organic compound in string form
	 * @return molecular mass of organic compound
	 * @throws Exception
	 */
	public int calculateMass(String compound) throws Exception {
		int sumOfMass = 0;
		int sumOfBrace = 0;
		int totalElements = 0;
		int position = 0;
		for (int i = 0; i < compound.length(); i++) {
			sumOfBrace = 0;
			if (compound.charAt(i) == '(') {
				position = i;
				operation.push(-1);
			} else if (compound.charAt(i) == 'C' || compound.charAt(i) == 'H' || compound.charAt(i) == 'O') {
				operation.push(element.get(compound.charAt(i)));
			} else if (compound.charAt(i) >= '1' && compound.charAt(i) <= '9') { // to get multiple digit number
				StringBuffer digit = new StringBuffer();
				while (i < compound.length() && compound.charAt(i) >= '0' && compound.charAt(i) <= '9') {
					digit.append(compound.charAt(i++));
				}
				subCompoundOperate.push(Integer.parseInt(digit.toString())); //push elements multiplication number
				int topElementOfSubCompound = subCompoundOperate.pop();
				int topElement = operation.pop();
				operation.push(topElementOfSubCompound * topElement); //push calculated value of a sub compound 
					if (i >= compound.length()) {
						break;
					}
				i--;
			} else if (compound.charAt(i) == ')') {
				while (operation.peek() != -1) {
					sumOfBrace += operation.pop();
				}
				operation.pop();
				operation.push(sumOfBrace);
			} else {
				throw new Exception("Element not exists");
			}
		}

		totalElements = operation.size();
		for (int i = 0; i < totalElements; i++) {
			sumOfMass += (operation.pop());
		}
		return sumOfMass;
	}
}
