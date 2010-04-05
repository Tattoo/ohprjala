package fi.hy.java.laskin;


public class View_Implementation extends javax.swing.JFrame  implements View {

	private Controller controller;
	private final  int BUTTONPRESSEDTIME = 50; // time in ms that a button keeps visually pressed down

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
	}
	
	@Override
	public void assignController(Controller controller) {
		this.controller = controller;				
	}

	@Override
	public void setVisible() {
		this.setVisible(true);
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
		textArea_output.setRows(10);
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
						.addComponent(jScrollPane_output, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
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
