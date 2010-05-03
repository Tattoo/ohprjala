package fi.hy.laskin.main.calculator;

import fi.hy.laskin.main.Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Calculator_Imple implements Calculator {
	private final char						NOP		= 'z';				
	private final char						FIRST	= 'x';				
	private final char						STORE	= 'y';				
	private final char						LOAD	= 'o';		
	private final String					PI		= "3.14159265";
	
	private double							currentValue;				
	private String							currentDigits;				
	private boolean							currentDigitsIsEven;		
	private boolean							currentDigitsIsPositive;	
	private char							currentOperator;			
	private char							nextDigitIsMemory;			
	private final Vector<Double>			pastValues;				
	private final ArrayList<String>			calcHistory;
	private final HashMap<Integer, Double>	memory;					

	public Calculator_Imple() {
		currentValue = 0;
		currentDigits = "";
		currentDigitsIsEven = true;
		currentDigitsIsPositive = true;
		currentOperator = FIRST;
		pastValues = new Vector<Double>(10);
		memory = new HashMap<Integer, Double>();
		calcHistory = new ArrayList<String>(200);
		nextDigitIsMemory = NOP;
	}

	/**
	 * Add a digit to the end of currentDigits (to right). If the user is giving
	 * new digits, but no operator was selected (operator == NOP) (and the user
	 * isn't typing the very first digits == FIRST), the user wants to start a
	 * new calculation, so we clear the previous calculation and start a new one
	 * with the new digit as a first currentDigit.
	 */
	public ArrayList<String> addDigit(int digit) {
		if (nextDigitIsMemory != NOP) { // store or load
			if (digit < 1 || digit > 9) // check if valid memspace
				return getCalcHistory();

			if (nextDigitIsMemory == STORE) {
				Double dbl = Double.parseDouble(currentDigits);
				memory.put(digit, dbl);
				nextDigitIsMemory = NOP;
				return getCalcHistory();
			} else { // LOAD
				if (memory.get(digit) == null) {
					nextDigitIsMemory = NOP;
					return getCalcHistory();
				}
				String s = memory.get(digit).toString();
				nextDigitIsMemory = NOP;
				addStrToDigits(s);
				return getCalcHistory();
			}
		}

		if (currentOperator == NOP) { // No operation but adding digits: clear values and start with "<digit>"
			this.resetInput();
			currentOperator = FIRST;
			currentDigits = "" + digit;
		} else
			currentDigits = currentDigits + digit;

		return getCalcHistory();
	}

	/**
	 * When store function is called, model waits for a next digit between 1-9
	 * and stores the last currentDigits to memory.
	 * 
	 * @return
	 */
	public ArrayList<String> store() {
		if (currentDigits == "" || currentOperator != FIRST)
			return getCalcHistory();

		nextDigitIsMemory = STORE;

		ArrayList<String> newlist = new ArrayList<String>(getCalcHistory());
		String str = newlist.remove(newlist.size() - 1);
		str = str + "  GIVE MEMSLOT[1-9]";
		newlist.add(str);
		return newlist;
	}

	/**
	 * When load function is called, model waits for a next digit between 1-9
	 * and loads digits from memory
	 * 
	 * @return
	 */
	public ArrayList<String> load() {
		if(currentDigits != "")
			return getCalcHistory();
		String str = "";
		nextDigitIsMemory = LOAD;
		ArrayList<String> newlist = new ArrayList<String>(getCalcHistory());
		if(newlist.size() > 0)
			str = newlist.remove(newlist.size() - 1);
		str = str + "  GIVE MEMSLOT[1-9]";
		newlist.add(str);
		return newlist;
	}

	/**
	 * Remove the last (rightmost) digit if there are digits. Or if there aren't
	 * but there is an operation, erase the operator by setting it to NOP. If we
	 * erase a decimal point or a minus sign, we have to update the
	 * corresponding boolean values too.
	 */
	public ArrayList<String> erase() {
		if(nextDigitIsMemory != NOP) { //cancel memory usage
			nextDigitIsMemory = NOP;
			return getCalcHistory();
		}
		
		if (currentDigits.equals("")) // no digits -> set operator = NOP (but no  change for FIRST)
			if (currentOperator == FIRST)
				return getCalcHistory();
			else {
				currentOperator = NOP;
				return getCalcHistory();
			}
		// else -- there are digits:

		char lastDigit = currentDigits.charAt(currentDigits.length() - 1);

		if (lastDigit == '.')
			currentDigitsIsEven = true;
		else if (lastDigit == '-')
			currentDigitsIsPositive = true;

		currentDigits = currentDigits.substring(0, currentDigits.length() - 1); // remove last (rightmost) char of String
		return getCalcHistory();
	}

	/**
	 * Adds decimal point to currentDigits (when possible) as last (rightmost)
	 * digit
	 */
	public ArrayList<String> addDecimalPoint() {
		if (currentOperator == NOP) // No operation but adding digits: clear values and start with "0."
		{
			this.clear();
			currentDigits = "0.";
			return getCalcHistory();
		}

		if (currentDigitsIsEven) // decimal point not yet used
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
	 * Changes the sign of currentDigits, or changes sign of currentValue if
	 * there are no digits
	 */
	public ArrayList<String> changeSign() {
		if (currentOperator == NOP) // No operation -> no digits: change the sign of the currentValue
		{
			if (currentValue <= 0)
				currentValue = Math.abs(currentValue);
			else
				currentValue = currentValue - 2 * currentValue;
			return getCalcHistory();
		}
		// else there are digits
		if (currentDigitsIsPositive) // and they were positive
		{
			currentDigits = "-" + currentDigits;
			currentDigitsIsPositive = false;
		} else // or they were negative
		{
			currentDigits = currentDigits.substring(1); // remove first (leftmost) char of the String
			currentDigitsIsPositive = true;
		}
		return getCalcHistory();
	}

	/**
	 * Resets the calculator
	 */
	public ArrayList<String> clear() {
		pastValues.clear();
		calcHistory.clear();
		//memory.clear();
		currentValue = 0;
		currentDigits = "";
		currentDigitsIsEven = true;
		currentDigitsIsPositive = true;
		currentOperator = FIRST;
		return getCalcHistory();
	}

	/**
	 * Resets the calculator, but starts with currentValue being the last stored
	 * currentValue (from pastValues)
	 */
	public ArrayList<String> undo() {
		if(nextDigitIsMemory != NOP) {
			return erase(); //clears memory using state
		}
		
		if (pastValues.size() == 0) // nothing to undo
			return getCalcHistory();

		if (pastValues.size() > 0) {
			currentValue = pastValues.remove(pastValues.size() - 1).doubleValue();
			memory.put(0, currentValue);
		}
		if (calcHistory.size() > 0)
			calcHistory.remove(calcHistory.size() - 1);

		resetInput();
		return getCalcHistory();
	}

	/**
	 * Executes any calculations the user has typed, and then starts to take
	 * digits to be added to that new currentValue
	 */
	public ArrayList<String> add() {
		this.checkFirstNumber();
		this.calculate();
		if (this.checkFirstNumber())
			this.calculate();
		currentOperator = '+';
		return getCalcHistory();
	}

	/**
	 * Executes any calculations the user has typed, and then starts to take
	 * digits to be substracted of that new currentValue
	 */
	public ArrayList<String> substract() {
		this.checkFirstNumber();
		this.calculate();
		if (this.checkFirstNumber())
			this.calculate();
		currentOperator = '-';
		return getCalcHistory();
	}

	/**
	 * Executes any calculations the user has typed, and then starts to take
	 * digits to multiply that new currentValue with
	 */
	public ArrayList<String> multiply() {
		this.checkFirstNumber();
		this.calculate();
		if (this.checkFirstNumber())
			this.calculate();
		currentOperator = '*';
		return getCalcHistory();
	}

	/**
	 * Executes any calculations the user has typed, and then starts to take
	 * digits to divide that new currentValue with
	 */
	public ArrayList<String> divide() {
		this.checkFirstNumber();
		this.calculate();
		if (this.checkFirstNumber())
			this.calculate();
		currentOperator = '/';
		return getCalcHistory();
	}

	/**
	 * Executes any calculations the user has typed, and then starts to take
	 * digits by which to raise to power that new currentValue
	 */
	public ArrayList<String> raiseToPower() {
		this.checkFirstNumber();
		this.calculate();
		if (this.checkFirstNumber())
			this.calculate();
		currentOperator = '^';
		return getCalcHistory();
	}

	public ArrayList<String> ans() {
		if (memory.get(0) != null && (currentDigits == "" || currentDigits == "-")) {
			String ans = memory.get(0).toString();
			if (ans.charAt(0) == 'I') // covers case "Infinity"
				return getCalcHistory();

			addStrToDigits(ans);
		}
		return getCalcHistory();
	}

	/**
	 * Perform whatever calculation the user has currently entered
	 */
	public ArrayList<String> calculate() {
		double digits; // currentDigits (String) as a double
		String calculation = giveOutput() + " = "; // saves the calculation in
													// string format

		if (currentOperator == NOP) // nothing to do
			return getCalcHistory();

		// if there is an operator, but no currentDigits to use for that
		// operation, we do nothing
		if (currentOperator != FIRST && (currentDigits.equals("") || currentDigits.equals("-")))
			return getCalcHistory();

		switch (currentOperator) {

		case FIRST: {
			// No operation yet, but either the user has pressed equal sign, or for example pressed the add-button 
			// (operations calls calculate() first). In either case we make the currentDigits the currentValue.

			if (currentDigits.equals("") || currentDigits.equals("-")) // if no value, set to zero
				currentValue = 0;
			else
				currentValue = Double.parseDouble(currentDigits);

			currentDigits = ""; // reset currentDigits
			currentDigitsIsEven = true; // "
			currentDigitsIsPositive = true; // "
			currentOperator = NOP; // reset operator
			break;
		}

		case '+': {
			addPastValue();
			digits = Double.parseDouble(currentDigits); // String -> double
			currentValue = currentValue + digits; // the math
			calcHistory.add(calculation + currentValue);
			memory.put(0, currentValue);
			resetInput();
			break;
		}

		case '-': {
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = currentValue - digits;
			calcHistory.add(calculation + currentValue);
			memory.put(0, currentValue);
			resetInput();
			break;
		}

		case '*': {
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = currentValue * digits;
			calcHistory.add(calculation + currentValue);
			memory.put(0, currentValue);
			resetInput();
			break;
		}

		case '/': {
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = currentValue / digits;
			calcHistory.add(calculation + currentValue);
			memory.put(0, currentValue);
			resetInput();
			break;
		}

		case '^': {
			addPastValue();
			digits = Double.parseDouble(currentDigits);
			currentValue = Math.pow(currentValue, digits);
			calcHistory.add(calculation + currentValue);
			memory.put(0, currentValue);
			resetInput();
			break;
		}

		}
		return getCalcHistory();
	}

	/**
	 * Square root is different from other operations, as it takes no second
	 * value. We perform any calculations the user has typed, and then take a
	 * square root of the result.
	 */
	public ArrayList<String> getSquareRoot() {
		if (currentOperator != FIRST || currentDigits == "")
			return getCalcHistory();
		;
		String calculation = giveOutput();
		this.calculate();
		this.addPastValue();
		currentValue = Math.sqrt(currentValue);
		calcHistory.add("sqrt(" + calculation + ") = " + currentValue);
		memory.put(0, currentValue);
		resetInput();
		return getCalcHistory();
	}
	public ArrayList<String> pi() {
		if(nextDigitIsMemory != NOP || currentDigits != "") {
			nextDigitIsMemory = NOP;
			return getCalcHistory();
		}		
		addStrToDigits(PI);
		return getCalcHistory();
	}
	
	private void addStrToDigits(String str) {
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.')
				addDecimalPoint();
			else if (str.charAt(i) == '-')
				changeSign();
			else if (str.charAt(i) == 'E') {
				addCharEToDigits();
			}
			else
				addDigit(Integer.parseInt("" + str.charAt(i)));			
		}
	}
	
	/** 
	 * called if digits contain E char, e.g. 2.3289E12 
	 */
	private void addCharEToDigits() {
		currentDigits = currentDigits + 'E';
	}
	
	private boolean checkFirstNumber() {
		if (currentDigits == "" && currentOperator == FIRST) {
			ans();
			return true;
		}
		return false;
	}

	/**
	 * Resets calculator variables to default
	 */
	private void resetInput() {
		currentDigits = ""; // reset currentDigits
		currentDigitsIsEven = true; // "
		currentDigitsIsPositive = true; // "
		currentOperator = FIRST; // reset operator
		currentValue = 0;
	}

	/**
	 * Adds new value to value history
	 */
	private void addPastValue() {
		pastValues.add(new Double(currentValue));
	}

	/**
	 * Returns a text corresponding the current state of the Equation
	 */
	private String giveOutput() {
		if (currentOperator == FIRST)
			return currentDigits;
		if (currentOperator == NOP)
			return "" + currentValue;
		return "" + currentValue + " " + currentOperator + " " + currentDigits;
	}

	private ArrayList<String> getCalcHistory() {
		ArrayList<String> history = new ArrayList<String>(calcHistory);
		if (giveOutput() != "")
			history.add(giveOutput());

		return history;
	}
	
	public Map<Integer, Double>getMemory() {
		return memory;
	}
}
