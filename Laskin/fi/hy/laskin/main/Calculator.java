package fi.hy.laskin.main;

import java.util.List;

public interface Calculator {
	
	/**
	 * Insert one digit
	 * @param digit
	 * @return
	 */
	public List<String> addDigit(int digit);
	
	/**
	 * Add decimal point after previous digit
	 * @return
	 */
	public List<String> addDecimalPoint();
	
	/**
	 * change sign of the number
	 * @return
	 */
	public List<String> changeSign();

	/**
	 * Reset the calculator and histories
	 * @return
	 */
	public List<String> clear();
	
	/**
	 * Return one calculation step
	 * @return
	 */
	public List<String> undo();
	
	/**
	 * Backspace, erase last inserted digit/operator
	 * @return
	 */
	public List<String> erase();
	
	/**
	 * Make an add calculation
	 * @return
	 */
	public List<String> add();
	
	/**
	 * Make a substraction
	 * @return
	 */
	public List<String> substract();
	
	/**
	 * Make a multiply calculation
	 * @return
	 */
	public List<String> multiply();
	
	/**
	 * Make a divide calculation
	 * @return
	 */
	public List<String> divide();
	
	/**
	 * Make a power calculation
	 * @return
	 */
	public List<String> raiseToPower();
	
	/**
	 * Get square root of last inserted number
	 * @return
	 */
	public List<String> getSquareRoot();
	
	/**
	 * Make the given calculation and save histories
	 * @return
	 */
	public List<String> calculate();
	
	/**
	 * Inserts previous answer as digits, if applicable
	 * @return
	 */
	public List<String> ans();

	/**
	 * Stores current value to memory, next digit is memslot 1-9
	 * @return
	 */
	public List<String> store();
	
	/**
	 * Loads stored value, next given digit is memslot 1-9
	 * @return
	 */
	public List<String> load();
}
