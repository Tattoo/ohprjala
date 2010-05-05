package legacy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class Laskin extends javax.swing.JFrame implements ActionListener, KeyListener {

	private static final long		serialVersionUID	= 1L;
	private final int				BUTTONPRESSEDTIME	= 50;	// time in ms
	// that a button
	// keeps
	// visually
	// pressed down
	// when using keyboard keys
	private final Equation			equation;

	private javax.swing.JButton		button_0;
	private javax.swing.JButton		button_1;
	private javax.swing.JButton		button_2;
	private javax.swing.JButton		button_3;
	private javax.swing.JButton		button_4;
	private javax.swing.JButton		button_5;
	private javax.swing.JButton		button_6;
	private javax.swing.JButton		button_7;
	private javax.swing.JButton		button_8;
	private javax.swing.JButton		button_9;
	private javax.swing.JButton		button_add;
	private javax.swing.JButton		button_backspace;
	private javax.swing.JButton		button_clear;
	private javax.swing.JButton		button_decimalPoint;
	private javax.swing.JButton		button_divide;
	private javax.swing.JButton		button_equals;
	private javax.swing.JButton		button_multiply;
	private javax.swing.JButton		button_power;
	private javax.swing.JButton		button_signChange;
	private javax.swing.JButton		button_squareRoot;
	private javax.swing.JButton		button_substraction;
	private javax.swing.JButton		button_undo;
	private javax.swing.JScrollPane	jScrollPane_output;
	private javax.swing.JTextArea	textArea_output;

	/**
	 * *********************************************** Main method. Starts the
	 * calculator.
	 * 
	 * @param args
	 *            Doesn't take arguments
	 *************************************************/
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(
				new Runnable() {
					public void run() {
						new Laskin().setVisible(true);
					}
				}
				);
	}

	/**
	 * ************************************************ Sole constructor.
	 * Creates a calculator.
	 ***************************************************/
	public Laskin() {
		super("Calculator");

		initComponents();

		button_7.addActionListener(this);
		button_8.addActionListener(this);
		button_9.addActionListener(this);
		button_4.addActionListener(this);
		button_5.addActionListener(this);
		button_6.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_0.addActionListener(this);
		button_decimalPoint.addActionListener(this);
		button_equals.addActionListener(this);
		button_multiply.addActionListener(this);
		button_clear.addActionListener(this);
		button_squareRoot.addActionListener(this);
		button_power.addActionListener(this);
		button_divide.addActionListener(this);
		button_add.addActionListener(this);
		button_undo.addActionListener(this);
		button_signChange.addActionListener(this);
		button_substraction.addActionListener(this);
		button_backspace.addActionListener(this);

		equation = new Equation();
		textArea_output.setText(equation.giveOutput());

		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
	}

	/**
	 * Implementation of ActionListener.
	 * 
	 * @param e
	 *            ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == button_0) {
			equation.addDigit(0);
			button_0.setSelected(false);
		} else if (source == button_1) {
			equation.addDigit(1);
			button_1.setSelected(false);
		} else if (source == button_2) {
			equation.addDigit(2);
			button_2.setSelected(false);
		} else if (source == button_3) {
			equation.addDigit(3);
			button_3.setSelected(false);
		} else if (source == button_4) {
			equation.addDigit(4);
			button_4.setSelected(false);
		} else if (source == button_5) {
			equation.addDigit(5);
			button_5.setSelected(false);
		} else if (source == button_6) {
			equation.addDigit(6);
			button_6.setSelected(false);
		} else if (source == button_7) {
			equation.addDigit(7);
			button_7.setSelected(false);
		} else if (source == button_8) {
			equation.addDigit(8);
			button_8.setSelected(false);
		} else if (source == button_9) {
			equation.addDigit(9);
			button_9.setSelected(false);
		}

		else if (source == button_decimalPoint) {
			equation.addDecimalPoint();
			button_decimalPoint.setSelected(false);
		} else if (source == button_signChange) {
			equation.changeSign();
			button_signChange.setSelected(false);
		} else if (source == button_equals) {
			equation.calculate();
			button_equals.setSelected(false);
		} else if (source == button_clear) {
			equation.clear();
			button_clear.setSelected(false);
		} else if (source == button_undo) {
			equation.undo();
			button_undo.setSelected(false);
		} else if (source == button_backspace) {
			equation.erase();
			button_backspace.setSelected(false);
		} else if (source == button_add) {
			equation.add();
			button_add.setSelected(false);
		} else if (source == button_substraction) {
			equation.substract();
			button_substraction.setSelected(false);
		} else if (source == button_multiply) {
			equation.multiply();
			button_multiply.setSelected(false);
		} else if (source == button_divide) {
			equation.divide();
			button_divide.setSelected(false);
		} else if (source == button_power) {
			equation.raiseToPower();
			button_power.setSelected(false);
		} else if (source == button_squareRoot) {
			equation.getSquareRoot();
			button_squareRoot.setSelected(false);
		}

		// Update textArea text
		textArea_output.setText(equation.giveOutput());

		this.requestFocus();

	}

	/**
	 * ********************************************************* Implementation
	 * of KeyListener.
	 * 
	 * @param e
	 *            KeyEvent
	 ************************************************************/
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();

		// Cause UI button corresponding the key typed to be activated, if
		// applicable
		switch (key) {
		case '0': {
			button_0.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '1': {
			button_1.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '2': {
			button_2.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '3': {
			button_3.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '4': {
			button_4.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '5': {
			button_5.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '6': {
			button_6.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '7': {
			button_7.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '8': {
			button_8.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '9': {
			button_9.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '+': {
			button_add.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '-': {
			button_substraction.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '*': {
			button_multiply.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '/': {
			button_divide.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '^': {
			button_power.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case ',': {
			button_decimalPoint.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '.': {
			button_decimalPoint.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '=': {
			button_equals.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '\r': {
			button_equals.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '\n': {
			button_equals.doClick(BUTTONPRESSEDTIME);
			break;
		}
		case '\b': {
			button_backspace.doClick(BUTTONPRESSEDTIME);
			break;
		}
		}
	}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	/**
	 * Swing components and layout generated with NetBeans IDE 5.5.
	 */
	private void initComponents() {

		button_7 = new javax.swing.JButton();
		button_8 = new javax.swing.JButton();
		button_9 = new javax.swing.JButton();
		button_4 = new javax.swing.JButton();
		button_5 = new javax.swing.JButton();
		button_6 = new javax.swing.JButton();
		button_1 = new javax.swing.JButton();
		button_2 = new javax.swing.JButton();
		button_3 = new javax.swing.JButton();
		button_0 = new javax.swing.JButton();
		button_decimalPoint = new javax.swing.JButton();
		button_equals = new javax.swing.JButton();
		button_multiply = new javax.swing.JButton();
		button_clear = new javax.swing.JButton();
		button_squareRoot = new javax.swing.JButton();
		button_power = new javax.swing.JButton();
		button_divide = new javax.swing.JButton();
		button_add = new javax.swing.JButton();
		button_undo = new javax.swing.JButton();
		button_signChange = new javax.swing.JButton();
		button_substraction = new javax.swing.JButton();
		jScrollPane_output = new javax.swing.JScrollPane();
		textArea_output = new javax.swing.JTextArea();
		button_backspace = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMaximizedBounds(new java.awt.Rectangle(400, 200, 400, 200));

		button_7.setText("7");

		button_8.setText("8");

		button_9.setText("9");

		button_4.setText("4");

		button_5.setText("5");

		button_6.setText("6");

		button_1.setText("1");

		button_2.setText("2");

		button_3.setText("3");

		button_0.setText("0");

		button_decimalPoint.setText(",");

		button_equals.setText("=");

		button_multiply.setText("*");

		button_clear.setText("clear");

		button_squareRoot.setText("sqrt");

		button_power.setText("x^y");

		button_divide.setText("/");

		button_add.setText("+");

		button_undo.setText("undo");

		button_signChange.setText("+/-");

		button_substraction.setText("-");

		textArea_output.setColumns(20);
		textArea_output.setEditable(false);
		textArea_output.setRows(1);
		jScrollPane_output.setViewportView(textArea_output);

		button_backspace.setText("backspace");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jScrollPane_output, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
														.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																.addComponent(button_7)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(button_8)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(button_9))
														.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																.addComponent(button_4)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(button_5)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(button_6))
																.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																		.addComponent(button_0)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(button_decimalPoint)
																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(button_signChange, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																		.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																				.addComponent(button_1)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(button_2)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(button_3)))
																				.addGap(20, 20, 20)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																						.addComponent(button_backspace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
																								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																										.addComponent(button_add, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addComponent(button_multiply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																										.addGap(8, 8, 8)
																										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																												.addComponent(button_substraction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																												.addComponent(button_divide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																												.addComponent(button_equals, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
																												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
																														.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																																.addComponent(button_squareRoot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																																.addComponent(button_power, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																																.addComponent(button_clear, javax.swing.GroupLayout.Alignment.LEADING)
																																.addComponent(button_undo, javax.swing.GroupLayout.Alignment.LEADING))
																																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																																.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane_output, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button_7)
										.addComponent(button_8)
										.addComponent(button_9)
										.addComponent(button_backspace)
										.addComponent(button_clear))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(button_4)
										.addComponent(button_5)
										.addComponent(button_6)
										.addComponent(button_divide)
										.addComponent(button_multiply)
										.addComponent(button_power))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(button_1)
												.addComponent(button_2)
												.addComponent(button_3)
												.addComponent(button_add)
												.addComponent(button_substraction)
												.addComponent(button_squareRoot))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(button_0)
														.addComponent(button_decimalPoint)
														.addComponent(button_signChange)
														.addComponent(button_equals)
														.addComponent(button_undo))
														.addContainerGap())
				);
		pack();
	}

	/**
	 * Equation Holds the values for visual text output and does the actual
	 * math.
	 */
	private class Equation {

		private final char				NOP		= 'z';				// no
		// operation
		// at the
		// moment
		// (no
		// currentDigits)
		private final char				FIRST	= 'x';				// no
		// operations
		// yet
		// performed
		// (no
		// currentValue)

		private double					currentValue;				// holds the
		// current
		// value
		private String					currentDigits;				// holds the
		// value (as
		// String)
		// that math
		// operation
		// is going
		// to use to
		// currentValue
		private boolean					currentDigitsIsEven;		// true if
		// no
		// decimal
		// point,
		// false if
		// decimal
		// point
		// already
		// used
		private boolean					currentDigitsIsPositive;	// true if
		// positive,
		// false if
		// negative
		private char					currentOperator;			// stores
		// the
		// operator
		// (+,-,*,/,^,FIRST,NOP).
		// (Square
		// root is a
		// special
		// operation
		// that
		// doesn't
		// take a
		// second
		// value)
		private final Vector<Double>	pastValues;				// history

		// of
		// previous
		// currentvalues
		// for undo
		// button

		public Equation() {
			currentValue = 0;
			currentDigits = "";
			currentDigitsIsEven = true;
			currentDigitsIsPositive = true;
			currentOperator = FIRST;
			pastValues = new Vector<Double>(10);
		}

		/**
		 * Returns a text corresponding the current state of the Equation
		 */
		public String giveOutput() {
			if (currentOperator == FIRST)
				return "    " + currentDigits;
			if (currentOperator == NOP)
				return "" + currentValue + "    ";
			return "" + currentValue + "    " + currentOperator + " " + currentDigits;
		}

		/**
		 * Add a digit to the end of currentDigits (to right). If the user is
		 * giving new digits, but no operator was selected (operator == NOP)
		 * (and the user isn't typing the very first digits == FIRST), the user
		 * wants to start a new calculation, so we clear the previous
		 * calculation and start a new one with the new digit as a first
		 * currentDigit.
		 */
		public void addDigit(int digit) {
			if (currentOperator == NOP) { // No operation but adding digits:
				// clear values and start with
				// "<digit>"
				this.clear();
				currentDigits = "" + digit;
			} else
				currentDigits = currentDigits + digit;
		}

		/**
		 * Remove the last (rightmost) digit if there are digits. Or if there
		 * aren't but there is an operation, erase the operator by setting it to
		 * NOP. If we erase a decimal point or a minus sign, we have to update
		 * the corresponding boolean values too.
		 */
		public void erase() {
			if (currentDigits.equals("")) // no digits -> set operator = NOP
				// (but no change for FIRST)
				if (currentOperator == FIRST)
					return;
				else {
					currentOperator = NOP;
					return;
				}
			// else -- there are digits:

			char lastDigit = currentDigits.charAt(currentDigits.length() - 1);

			if (lastDigit == '.')
				currentDigitsIsEven = true;
			else if (lastDigit == '-')
				currentDigitsIsPositive = true;

			currentDigits = currentDigits.substring(0, currentDigits.length() - 1); // remove
			// last
			// (rightmost)
			// char
			// of
			// String
		}

		/**
		 * Adds decimal point to currentDigits (when possible) as last
		 * (rightmost) digit
		 */
		public void addDecimalPoint() {
			if (currentOperator == NOP) // No operation but adding digits: clear
			// values and start with "0."
			{
				this.clear();
				currentDigits = "0.";
				return;
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
		}

		/**
		 * Changes the sign of currentDigits, or changes sign of currentValue if
		 * there are no digits
		 */
		public void changeSign() {
			if (currentOperator == NOP) // No operation -> no digits: change the
			// sign of the currentValue
			{
				if (currentValue <= 0)
					currentValue = Math.abs(currentValue);
				else
					currentValue = currentValue - 2 * currentValue;
				return;
			}
			// else there are digits
			if (currentDigitsIsPositive) // and they were positive
			{
				currentDigits = "-" + currentDigits;
				currentDigitsIsPositive = false;
			} else // or they were negative
			{
				currentDigits = currentDigits.substring(1); // remove first
				// (leftmost) char
				// of the String
				currentDigitsIsPositive = true;
			}
		}

		/**
		 * Resets the calculator (except for pastValues)
		 */
		public void clear() {
			pastValues.add(new Double(currentValue)); // store currentValue to
			// pastValues
			currentValue = 0;
			currentDigits = "";
			currentDigitsIsEven = true;
			currentDigitsIsPositive = true;
			currentOperator = FIRST;
		}

		/**
		 * Resets the calculator, but starts with currentValue being the last
		 * stored currentValue (from pastValues)
		 */
		public void undo() {
			if (pastValues.size() == 0) // nothing to undo
				return;

			try {
				currentValue = pastValues.remove(pastValues.size() - 1).doubleValue();
			} catch (Exception e) {
				System.out.println("Programming error: " + e);
			} // remove() throws if nothing to remove

			currentDigits = "";
			currentDigitsIsEven = true;
			currentDigitsIsPositive = true;
			currentOperator = NOP;
		}

		/**
		 * Executes any calculations the user has typed, and then starts to take
		 * digits to be added to that new currentValue
		 */
		public void add() {
			this.calculate();
			currentOperator = '+';
		}

		/**
		 * Executes any calculations the user has typed, and then starts to take
		 * digits to be substracted of that new currentValue
		 */
		public void substract() {
			this.calculate();
			currentOperator = '-';
		}

		/**
		 * Executes any calculations the user has typed, and then starts to take
		 * digits to multiply that new currentValue with
		 */
		public void multiply() {
			this.calculate();
			currentOperator = '*';
		}

		/**
		 * Executes any calculations the user has typed, and then starts to take
		 * digits to divide that new currentValue with
		 */
		public void divide() {
			this.calculate();
			currentOperator = '/';
		}

		/**
		 * Executes any calculations the user has typed, and then starts to take
		 * digits by which to raise to power that new currentValue
		 */
		public void raiseToPower() {
			this.calculate();
			currentOperator = '^';
		}

		/**
		 * Perform whatever calculation the user has currently entered
		 */
		public void calculate() {
			double digits; // currentDigits (String) as a double

			if (currentOperator == NOP) // nothing to do
				return;

			// if there is an operator, but no currentDigits to use for that
			// operation, we do nothing
			if (currentOperator != FIRST && (currentDigits.equals("") || currentDigits.equals("-")))
				return;

			switch (currentOperator) {

			case FIRST: // No operation yet, but either the user has pressed
				// equal sign, or
			{ // for example pressed the add-button (operations calls
				// calculate() first).
				// In either case we make the currentDigits the currentValue.

				if (currentDigits.equals("") || currentDigits.equals("-")) // if
					// no
					// value,
					// set
					// to
					// zero
					currentValue = 0;
				else
					currentValue = Double.parseDouble(currentDigits);

				currentDigits = "";
				currentDigitsIsEven = true;
				currentDigitsIsPositive = true;
				currentOperator = NOP;
				break;
			}

			case '+': {
				pastValues.add(new Double(currentValue)); // store the
				// currentValue to
				// pastValues
				digits = Double.parseDouble(currentDigits); // String -> double
				currentValue = currentValue + digits; // the math
				currentDigits = ""; // reset currentDigits
				currentDigitsIsEven = true; // "
				currentDigitsIsPositive = true; // "
				currentOperator = NOP; // reset operator
				break;
			}

			case '-': {
				pastValues.add(new Double(currentValue));
				digits = Double.parseDouble(currentDigits);
				currentValue = currentValue - digits;
				currentDigits = "";
				currentDigitsIsEven = true;
				currentDigitsIsPositive = true;
				currentOperator = NOP;
				break;
			}

			case '*': {
				pastValues.add(new Double(currentValue));
				digits = Double.parseDouble(currentDigits);
				currentValue = currentValue * digits;
				currentDigits = "";
				currentDigitsIsEven = true;
				currentDigitsIsPositive = true;
				currentOperator = NOP;
				break;
			}

			case '/': {
				pastValues.add(new Double(currentValue));
				digits = Double.parseDouble(currentDigits);
				currentValue = currentValue / digits;
				currentDigits = "";
				currentDigitsIsEven = true;
				currentDigitsIsPositive = true;
				currentOperator = NOP;
				break;
			}

			case '^': {
				pastValues.add(new Double(currentValue));
				digits = Double.parseDouble(currentDigits);
				currentValue = Math.pow(currentValue, digits);
				currentDigits = "";
				currentDigitsIsEven = true;
				currentDigitsIsPositive = true;
				currentOperator = NOP;
				break;
			}

			}
		}

		/**
		 * Square root is different from other operations, as it takes no second
		 * value. We perform any calculations the user has typed, and then take
		 * a square root of the result.
		 */
		public void getSquareRoot() {
			this.calculate();
			pastValues.add(new Double(currentValue));
			currentValue = Math.sqrt(currentValue);
		}

	}

}
