package fi.hy.laskin.test;

import fi.hy.laskin.main.Calculator;
import fi.hy.laskin.main.calculator.Calculator_Imple;

import java.util.List;

import junit.framework.TestCase;

public class Calculator_Imple_Test extends TestCase {

	private Calculator calc;
	
	protected void setUp() throws Exception {
		super.setUp();
		calc = new Calculator_Imple();		
	}
	
	private String listToString(List<String> list) {
		if(list == null) 
			return null;
		String ret = "";
		for(int i = 0; i < list.size(); i++) {
			if(i > 0)
				ret = ret + "\n";
			ret = ret + list.get(i);
		}
		return ret;
	}

	public void test_insert_number() {
		calc.addDigit(1);
		calc.addDigit(2);
		calc.addDigit(3);
		calc.addDigit(4);
		String output = listToString(calc.addDigit(5));
		String expected = "12345";
		assertEquals(expected, output);
	}
	
	public void test_decimal_point() {
		calc.addDigit(1);
		calc.addDigit(2);
		calc.addDigit(3);
		calc.addDigit(4);
		calc.addDecimalPoint();
		calc.addDigit(8);
		String output = listToString(calc.addDigit(5));
		String expected = "1234.85";
		assertEquals(expected, output);
	}

	public void test_add() {
		calc.addDigit(1);
		calc.addDigit(2);
		calc.add();
		calc.addDigit(3);
		calc.addDigit(4);
		String output = listToString(calc.calculate());
		String expected = "12.0 + 34 = 46.0";
		assertEquals(expected, output);
	}	
	
	public void test_erase() {
		calc.addDigit(1);
		calc.addDigit(2);
		calc.addDigit(3);
		calc.addDigit(4);
		String output = listToString(calc.erase());
		String expected = "123";
		assertEquals(expected, output);
		
		calc.add();
		calc.addDigit(9);
		output = listToString(calc.calculate());
		expected = "123.0 + 9 = 132.0";
		assertEquals(expected, output);
	}
	
	public void test_change_sign() {
		calc.addDigit(1);
		calc.addDigit(2);
		String output = listToString(calc.changeSign());
		String expected = "-12";
		assertEquals(expected, output);
		
		output = listToString(calc.changeSign());
		expected = "12";
		assertEquals(expected, output);
	}	
	
	public void test_clear() {
		calc.addDigit(1);
		calc.add();
		calc.addDigit(122);
		calc.calculate();
		calc.add();
		calc.addDigit(155);
		String output = listToString(calc.clear());
		String expected = "";
		assertEquals(expected, output);
		
		output = listToString(calc.calculate());
		expected = "0.0";
		assertEquals(expected, output);
		
	}

	public void test_undo() {
		calc.addDigit(1);
		calc.add();
		calc.addDigit(122);
		calc.calculate();
		calc.add();
		calc.addDigit(155);
		calc.calculate();
		String output = listToString(calc.undo());
		String expected = "1.0 + 122 = 123.0";
		assertEquals(expected, output);		
	}	
	
	
	public void test_basic_sum() {
		calc.addDigit(5);
		calc.add();
		calc.addDigit(6);
		String output = listToString(calc.calculate());
		String expected = "5.0 + 6 = 11.0";
		assertEquals(expected, output);
	}
	
	public void test_substract() {
		calc.addDigit(1);
		calc.addDigit(2);
		calc.substract();
		calc.addDigit(3);
		calc.addDigit(4);
		String output = listToString(calc.calculate());
		String expected = "12.0 - 34 = -22.0";
		assertEquals(expected, output);
	}
	
	public void test_multiply() {
		calc.addDigit(2);
		calc.multiply();
		calc.addDigit(1);
		calc.addDigit(4);
		String output = listToString(calc.calculate());
		String expected = "2.0 * 14 = 28.0";
		assertEquals(expected, output);
	}

	public void test_divide() {
		calc.addDigit(20);
		calc.divide();
		calc.addDigit(5);
		String output = listToString(calc.calculate());
		String expected = "20.0 / 5 = 4.0";
		assertEquals(expected, output);
	}
	
	public void test_raiseToPower() {
		calc.addDigit(2);
		calc.raiseToPower();
		calc.addDigit(5);
		String output = listToString(calc.calculate());
		String expected = "2.0 ^ 5 = 32.0";
		assertEquals(expected, output);
	}

	public void test_getSquareRoot() {
		calc.addDigit(16);
		String output = listToString(calc.getSquareRoot());
		String expected = "sqrt(16) = 4.0";
		assertEquals(expected, output);
	}
	
	public void test_ans() {
		calc.addDigit(8);
		calc.add();
		calc.addDigit(5);
		calc.calculate();
		calc.ans();
		calc.add();
		calc.ans();
		String output = listToString(calc.calculate());
		String expected = "8.0 + 5 = 13.0\n" +
						  "13.0 + 13.0 = 26.0";
		assertEquals(expected, output);
	}
	
	public void test_store_and_load() {
		calc.addDigit(8);
		String output = listToString(calc.store());
		String expected = "8  GIVE MEMSLOT[1-9]";	
		assertEquals(expected, output);
		calc.addDigit(1); //stored to memspace 1
		calc.add();
		calc.load();
		calc.addDigit(1);
		output = listToString(calc.calculate());
		expected = "8.0 + 8.0 = 16.0";
		assertEquals(expected, output);
	}

}
