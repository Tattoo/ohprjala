package fi.hy.laskin.main.calculator;

import java.util.ArrayList;
import java.util.Vector;

import fi.hy.laskin.main.Calculator;

public class Calculator_Imple implements Calculator {
	private final char NOP = 'z';   // no operation at the moment (no currentDigits)
	private final char FIRST = 'x'; // no operations yet performed (no currentValue)

	private double currentValue;        // holds the current value
	private String currentDigits;       // holds the value (as String) that math operation is going to use to currentValue
	private boolean currentDigitsIsEven; // true if no decimal point, false if decimal point already used
	private boolean currentDigitsIsPositive; // true if positive, false if negative
	private char currentOperator;       // stores the operator (+,-,*,/,^,FIRST,NOP). (Square root is a special operation that doesn't take a second value)
	private Vector<Double> pastValues;  // history of previous currentvalues for undo button
	private ArrayList<String> calcHistory;
 
	public Calculator_Imple() {
		currentValue = 0;
		currentDigits = "";
		currentDigitsIsEven = true;
		currentDigitsIsPositive = true;
		currentOperator = FIRST;
		pastValues = new Vector<Double>(10);
		calcHistory = new ArrayList<String>(200);
	}

	/**
	 * Add a digit to the end of currentDigits (to right). 
	 * If the user is giving new digits, but no operator was selected (operator == NOP) 
	 * (and the user isn't typing the very first digits == FIRST), the user wants to start a new 
	 * calculation, so we clear the previous calculation and start a new one with the 
	 * new digit as a first currentDigit.
	 */
	public ArrayList<String> addDigit(int digit) {
		if (currentOperator == NOP) { // No operation but adding digits: clear values and start with "<digit>"
			this.clear();
			currentDigits = "" + digit;
		}
		else
			currentDigits = currentDigits + digit;
		return getCalcHistory();
	}

	/**
	 * Remove the last (rightmost) digit if there are digits. Or if there aren't but there is an 
	 * operation, erase the operator by setting it to NOP. If we erase a decimal point or a minus 
	 * sign, we have to update the corresponding boolean values too.
	 */
	public ArrayList<String> erase() { 
		if ( currentDigits.equals("") ) // no digits -> set operator = NOP (but no change for FIRST)
			if (currentOperator == FIRST)
				return getCalcHistory();
			else {
				currentOperator = NOP;
				return getCalcHistory();
			}
		// else -- there are digits:

		char lastDigit = currentDigits.charAt(currentDigits.length()-1);

		if (lastDigit == '.')
			currentDigitsIsEven = true;
		else if (lastDigit == '-')
			currentDigitsIsPositive = true;

		currentDigits = currentDigits.substring( 0, currentDigits.length()-1 ); // remove last (rightmost) char of String
		return getCalcHistory();
	}

	/**
	 * Adds decimal point to currentDigits (when possible) as last (rightmost) digit
	 */
	public ArrayList<String> addDecimalPoint()
	{
		if (currentOperator == NOP) // No operation but adding digits: clear values and start with "0."
		{
			this.clear();
			currentDigits = "0.";
			return getCalcHistory();
		}

		if (currentDigitsIsEven)    // decimal point not yet used
		{
			if (currentDigits.equals(""))
				currentDigits = "0."; 
			else if (currentDigits.equals("-"))
				currentDigits = "-0.";
			else
				currentDigits = currentDigits + ".";

			currentDigitsIsEven = false;
		}
		// if decimal point already was used, do nothing
		return getCalcHistory();
	}


	/**
	 * Changes the sign of currentDigits, or changes sign of currentValue if there are no digits
	 */
	public ArrayList<String> changeSign()
	{
		if (currentOperator == NOP) // No operation -> no digits: change the sign of the currentValue
		{
			if (currentValue <= 0)
				currentValue = Math.abs(currentValue);
			else
				currentValue = currentValue-2*currentValue;
			return getCalcHistory();
		} 
		// else there are digits
		if (currentDigitsIsPositive)           // and they were positive
		{
			currentDigits = "-" + currentDigits;
			currentDigitsIsPositive = false;
		}
		else                                   // or they were negative
		{
			currentDigits = currentDigits.substring(1); // remove first (leftmost) char of the String
			currentDigitsIsPositive = true;
		}
		return getCalcHistory();
	}

	/**
	 * Resets the calculator (except for pastValues)
	 */
	public ArrayList<String> clear() {
		pastValues = new Vector<Double>(10);
		calcHistory = new ArrayList<String>(200);
		currentValue = 0;
		currentDigits = "";
		currentDigitsIsEven = true;
		currentDigitsIsPositive = true;
		currentOperator = FIRST;
		return getCalcHistory();
	}

	/**
	 * Resets the calculator, but starts with currentValue being the last stored currentValue (from pastValues)
	 */
	public ArrayList<String> undo() {
		if (pastValues.size() == 0) // nothing to undo
			return getCalcHistory();

		if (pastValues.size() > 0)
			currentValue = pastValues.remove( pastValues.size()-1 ).doubleValue(); 
		if (calcHistory.size() > 0) 
			calcHistory.remove(calcHistory.size()-1);
		
		resetInput();
		return getCalcHistory();
	}

	/**
	 * Executes any calculations the user has typed, and then starts to take digits to be added to that new currentValue
	 */
	public ArrayList<String> add() {
		this.calculate();
		currentOperator = '+';
		return getCalcHistory();
	}


	/**
	 * Executes any calculations the user has typed, and then starts to take digits to be substracted of that new currentValue
	 */
	public ArrayList<String> substract() {
		this.calculate();
		currentOperator = '-';
		return getCalcHistory();
	}


	/**
	 * Executes any calculations the user has typed, and then starts to take digits to multiply that new currentValue with
	 */
	public ArrayList<String> multiply() {
		this.calculate();
		currentOperator = '*';
		return getCalcHistory();
	}

	/**
	 * Executes any calculations the user has typed, and then starts to take digits to divide that new currentValue with
	 */
	public ArrayList<String> divide() {
		this.calculate();
		currentOperator = '/';
		return getCalcHistory();
	}


	/**
	 * Executes any calculations the user has typed, and then starts to take digits by which to raise to power that new currentValue
	 */
	public ArrayList<String> raiseToPower() {
		this.calculate();
		currentOperator = '^';
		return getCalcHistory();
	}

	/**
	 * Perform whatever calculation the user has currently entered
	 */
	public ArrayList<String> calculate() { 
		double digits;  // currentDigits (String) as a double
		String calculation = giveOutput() + " = "; // saves the calculation in string format
		
		if (currentOperator == NOP)  // nothing to do
			return getCalcHistory();;

		// if there is an operator, but no currentDigits to use for that operation, we do nothing 
		if (currentOperator != FIRST && ( currentDigits.equals("") || currentDigits.equals("-") ) )
			return getCalcHistory();;

		switch(currentOperator)
		{

		case FIRST:  // No operation yet, but either the user has pressed equal sign, or 
		{            // for example pressed the add-button (operations calls calculate() first).
			// In either case we make the currentDigits the currentValue.

			if (currentDigits.equals("") || currentDigits.equals("-"))   // if no value, set to zero
				currentValue = 0;
			else
				currentValue = Double.parseDouble(currentDigits);
			resetInput();
			break;
		}

		case '+':
		{
			addPastValue();
			digits = Double.parseDouble(currentDigits);  // String -> double
			currentValue = currentValue + digits;        // the math
			calcHistory.add(calculation + currentValue);
			resetInput();
			break;
		}

		case '-':
		{
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = currentValue - digits;
			calcHistory.add(calculation + currentValue);
			resetInput();
			break;
		}

		case '*':
		{
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = currentValue * digits;
			calcHistory.add(calculation + currentValue);
			resetInput();
			break;
		}

		case '/':
		{
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = currentValue / digits;
			calcHistory.add(calculation + currentValue);
			resetInput();
			break;
		}

		case '^':
		{
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = Math.pow(currentValue, digits);
			calcHistory.add(calculation + currentValue);
			resetInput();
			break;
		}

		}
		return getCalcHistory();
	}
		
	/**
	 * Square root is different from other operations, as it takes no second value.
	 * We perform any calculations the user has typed, and then take a square root
	 * of the result.
	 */
	public ArrayList<String> getSquareRoot() {
		String calculation = giveOutput();
		this.calculate();  
		this.addPastValue();
		currentValue = Math.sqrt(currentValue);
		calcHistory.add(calculation + currentValue);
		return getCalcHistory();
	}
	
	/**
	 * Resets calculator variables to default
	*/
	private void resetInput() {
		currentDigits = "";                          // reset currentDigits
		currentDigitsIsEven = true;                  // "
		currentDigitsIsPositive = true;              // "
		currentOperator = NOP;                       // reset operator
	} 
	
	/**
	 * Adds new value to value history
	 */
	private void addPastValue() {
		pastValues.add( new Double(currentValue) );
	}

	/**
	 * Returns a text corresponding the current state of the Equation
	 */
	private String giveOutput() {
		if (currentOperator == FIRST)
			return "    " + currentDigits;
		if (currentOperator == NOP)
			return "" + currentValue + "    ";
		return "" + currentValue + "    " + currentOperator + " " + currentDigits; 
	}	
		
	private ArrayList<String> getCalcHistory() {
		ArrayList<String> history = new ArrayList<String>(calcHistory);
		if(giveOutput() != "") 
			history.add(giveOutput());
		
		return history;
	}
	
	private void printHistory() {
		for(int i = 0; i < this.calcHistory.size(); i++)
			System.out.println(this.calcHistory.get(i));		
	}
	
	public static void main(String[] args) {
		Calculator_Imple laskin = new Calculator_Imple();
		laskin.addDigit(9);
		laskin.add();
		laskin.addDigit(10);
		laskin.calculate();
		laskin.multiply();
		laskin.addDigit(10);
		laskin.calculate();
		laskin.undo();
		laskin.multiply();
		laskin.addDigit(8);
		laskin.calculate();
		
		//laskin.addDigit(10);
		//laskin.getSquareRoot();
		laskin.printHistory();
	}
	
}