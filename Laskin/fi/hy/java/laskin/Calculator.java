package fi.hy.java.laskin;

import java.util.ArrayList;

public interface Calculator {
	
	/**
	 * Insert one digit
	 * @param digit
	 * @return
	 */
	public ArrayList<String> addDigit(int digit);
	
	/**
	 * Add decimal point after previous digit
	 * @return
	 */
	public ArrayList<String> addDecimalPoint();
	
	/**
	 * change sign of the number
	 * @return
	 */
	public ArrayList<String> changeSign();

	/**
	 * Reset the calculator and histories
	 * @return
	 */
	public ArrayList<String> clear();
	
	/**
	 * Return one calculation step
	 * @return
	 */
	public ArrayList<String> undo();
	
	/**
	 * Backspace, erase last inserted digit/operator
	 * @return
	 */
	public ArrayList<String> erase();
	
	/**
	 * Make an add calculation
	 * @return
	 */
	public ArrayList<String> add();
	
	/**
	 * Make a multiply calculation
	 * @return
	 */
	public ArrayList<String> multiply();
	
	/**
	 * Make a divide calculation
	 * @return
	 */
	public ArrayList<String> divide();
	
	/**
	 * Make a power calculation
	 * @return
	 */
	public ArrayList<String> raiseToPower();
	
	/**
	 * Get square root of last inserted number
	 * @return
	 */
	public ArrayList<String> getSquareRoot();
	
	/**
	 * Make the given calculation and save histories
	 * @return
	 */
	public ArrayList<String> calculate();
}
