package fi.hy.java.laskin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View_Implementation extends javax.swing.JFrame  implements View {

	private static final int	OUTPUT_AREA_HEIGHT	= 250;
	private static final int	OUTPUT_AREA_WIDTH	= 328;
	
	private static final long	serialVersionUID	= -2212730761656490235L;
	
	/**
	 * Causes a button on the UI to be pressed if a key that matches with that button is typed 
	 */
	private class KeyListener_Impl implements KeyListener {
		private final static int KEEP_BUTTON_PRESSED_TIME = 50; // ms
		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {
			switch (e.getKeyChar()) {
			case '0':  { pressButton(button_0); break; }
			case '1':  { pressButton(button_1); break; }
			case '2':  { pressButton(button_2); break; }
			case '3':  { pressButton(button_3); break; }
			case '4':  { pressButton(button_4); break; }
			case '5':  { pressButton(button_5); break; }
			case '6':  { pressButton(button_6); break; }
			case '7':  { pressButton(button_7); break; }
			case '8':  { pressButton(button_8); break; }
			case '9':  { pressButton(button_9); break; }
			case '+':  { pressButton(button_add); break; }
			case '-':  { pressButton(button_substraction); break; }
			case '*':  { pressButton(button_multiply); break; }
			case '/':  { pressButton(button_divide); break; }
			case '^':  { pressButton(button_power); break; }
			case ',':  { pressButton(button_decimalPoint); break; }
			case '.':  { pressButton(button_decimalPoint); break; }
			case '=':  { pressButton(button_equals); break; }
			case '\r': { pressButton(button_equals); break; }
			case '\n': { pressButton(button_equals); break; }
			case '\b': { pressButton(button_backspace); break; }
			}
		}
		private void pressButton(javax.swing.JButton button) {
			button.doClick(KEEP_BUTTON_PRESSED_TIME);
		}
	}
	
	/**
	 * Sends events to be processed by the controller
	 */
	private class ActionListener_Impl implements ActionListener {
		private final javax.swing.JFrame frame;
		public ActionListener_Impl(javax.swing.JFrame frame) {
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent e) {
			controller.process(e);
			frame.requestFocus();
		} 
	}
	
	private Controller controller;
	
	private javax.swing.JButton button_0;
	private javax.swing.JButton button_1;
	private javax.swing.JButton button_2;
	private javax.swing.JButton button_3;
	private javax.swing.JButton button_4;
	private javax.swing.JButton button_5;
	private javax.swing.JButton button_6;
	private javax.swing.JButton button_7;
	private javax.swing.JButton button_8;
	private javax.swing.JButton button_9;
	private javax.swing.JButton button_add;
	private javax.swing.JButton button_backspace;
	private javax.swing.JButton button_clear;
	private javax.swing.JButton button_decimalPoint;
	private javax.swing.JButton button_divide;
	private javax.swing.JButton button_equals;
	private javax.swing.JButton button_multiply;
	private javax.swing.JButton button_power;
	private javax.swing.JButton button_signChange;
	private javax.swing.JButton button_squareRoot;
	private javax.swing.JButton button_substraction;
	private javax.swing.JButton button_undo;
	private javax.swing.JScrollPane jScrollPane_output;
	private javax.swing.JTextArea textArea_output;
	
	public View_Implementation() {
		initComponents();
		this.addKeyListener(new KeyListener_Impl());
		ActionListener actionListener = new ActionListener_Impl(this);
		addActionListenerToAllButtons(actionListener);
		this.setFocusable(true);
		this.requestFocus();
	}
	
	private void addActionListenerToAllButtons(ActionListener actionListener) {
		button_7.addActionListener(actionListener);
		button_8.addActionListener(actionListener);
		button_9.addActionListener(actionListener);
		button_4.addActionListener(actionListener);
		button_5.addActionListener(actionListener);
		button_6.addActionListener(actionListener);
		button_1.addActionListener(actionListener);
		button_2.addActionListener(actionListener);
		button_3.addActionListener(actionListener);
		button_0.addActionListener(actionListener);
		button_decimalPoint.addActionListener(actionListener);
		button_equals.addActionListener(actionListener);
		button_multiply.addActionListener(actionListener);
		button_clear.addActionListener(actionListener);
		button_squareRoot.addActionListener(actionListener);
		button_power.addActionListener(actionListener);
		button_divide.addActionListener(actionListener);
		button_add.addActionListener(actionListener);
		button_undo.addActionListener(actionListener);
		button_signChange.addActionListener(actionListener);
		button_substraction.addActionListener(actionListener);
		button_backspace.addActionListener(actionListener);
	}
	
	@Override
	public void assignController(Controller controller) {
		this.controller = controller;				
	}

	@Override
	public void setVisible() {
		this.setVisible(true);
	}
	
	@Override
	public void setOutput(String output) {
		textArea_output.setText(output);
	}
	
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
		setMaximizedBounds(new java.awt.Rectangle(400, 200, 400, 200 ));

		button_1.setText(Const.ONE);
		button_2.setText(Const.TWO);
		button_3.setText(Const.THREE);
		button_4.setText(Const.FOUR);
		button_5.setText(Const.FIVE);
		button_6.setText(Const.SIX);
		button_7.setText(Const.SEVEN);
		button_8.setText(Const.EIGHT);
		button_9.setText(Const.NINE);
		button_0.setText(Const.ZERO);
		button_decimalPoint.setText(Const.DECIMAL_SEPARATOR);
		button_equals.setText(Const.EQUALS);
		button_multiply.setText(Const.MULTIPLY);
		button_clear.setText(Const.CLEAR);
		button_squareRoot.setText(Const.SQRT);
		button_power.setText(Const.RAISE_TO_POWER);
		button_divide.setText(Const.DIVIDE);
		button_add.setText(Const.ADD);
		button_undo.setText(Const.UNDO);
		button_signChange.setText(Const.CHANGE_SIGN);
		button_substraction.setText(Const.MINUS);
		button_backspace.setText(Const.BACKSPACE);
		
		textArea_output.setColumns(20);
		textArea_output.setEditable(false);
		textArea_output.setRows(10);
		jScrollPane_output.setViewportView(textArea_output);
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane_output, javax.swing.GroupLayout.DEFAULT_SIZE, OUTPUT_AREA_WIDTH, Short.MAX_VALUE)
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
						.addComponent(jScrollPane_output, javax.swing.GroupLayout.PREFERRED_SIZE, OUTPUT_AREA_HEIGHT, javax.swing.GroupLayout.PREFERRED_SIZE)
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
}
