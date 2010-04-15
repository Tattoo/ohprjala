package fi.hy.laskin.main.view;

import fi.hy.laskin.main.Const;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class View_Implementation extends javax.swing.JFrame  implements View {

	private static final int	OUTPUT_ROWS	= 10;
	private static final int	OUTPUT_COLS	= 20;
	
	private static final long	serialVersionUID	= -2212730761656490235L;
	
	/**
	 * Causes a button on the UI to be pressed if a key that matches that button is typed 
	 */
	private class KeyListener_Impl implements KeyListener {
		private final static int KEEP_BUTTON_PRESSED_TIME = 50; // ms
		private final Map<Character, javax.swing.JButton> charToButtonMapping;
		public KeyListener_Impl() {
			this.charToButtonMapping = new HashMap<Character, javax.swing.JButton>();
			charToButtonMapping.put('0', button_0);
			charToButtonMapping.put('1', button_1);
			charToButtonMapping.put('2', button_2);
			charToButtonMapping.put('3', button_3);
			charToButtonMapping.put('4', button_4);
			charToButtonMapping.put('5', button_5);
			charToButtonMapping.put('6', button_6);
			charToButtonMapping.put('7', button_7);
			charToButtonMapping.put('8', button_8);
			charToButtonMapping.put('9', button_9);
			charToButtonMapping.put('+', button_add);
			charToButtonMapping.put('-', button_substraction);
			charToButtonMapping.put('*', button_multiply);
			charToButtonMapping.put('/', button_divide);
			charToButtonMapping.put('^', button_power);
			charToButtonMapping.put(',', button_decimalPoint);
			charToButtonMapping.put('.', button_decimalPoint);
			charToButtonMapping.put('=', button_equals);
			charToButtonMapping.put('\r', button_equals);
			charToButtonMapping.put('\n', button_equals);
			charToButtonMapping.put('\b', button_backspace);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {}
		
		@Override
		public void keyReleased(KeyEvent e) {}
		
		@Override
		public void keyTyped(KeyEvent e) {
			Character key = e.getKeyChar();
			charToButtonMapping.get(key).doClick(KEEP_BUTTON_PRESSED_TIME);
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
	private javax.swing.JButton button_ans;
	
	public View_Implementation() {
		super("Calculator");
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
		button_ans.addActionListener(actionListener);
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
		button_ans = new javax.swing.JButton();
		button_ans.setText(Const.ANS.toUpperCase()); 

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		//setMaximizedBounds(new java.awt.Rectangle(400, 200, 400, 200 ));

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
		button_substraction.setText(Const.SUBSTRACT);
		button_backspace.setText(Const.BACKSPACE);
		button_ans.setText(Const.ANS);
		
		textArea_output.setColumns(OUTPUT_COLS);
		textArea_output.setEditable(false);
		textArea_output.setRows(OUTPUT_ROWS);
		jScrollPane_output.setViewportView(textArea_output);
		
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setVerticalGroup(layout.createSequentialGroup()
			.addComponent(jScrollPane_output, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(button_undo, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_backspace, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_7, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_8, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_9, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(layout.createParallelGroup()
			    .addGroup(layout.createSequentialGroup()
			        .addGap(0, 0, Short.MAX_VALUE)
			        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            .addComponent(button_power, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_divide, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_multiply, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_4, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_5, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_6, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, GroupLayout.PREFERRED_SIZE)
			        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			            .addComponent(button_squareRoot, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_substraction, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_add, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_1, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_2, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			            .addComponent(button_3, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
			    .addComponent(button_clear, GroupLayout.Alignment.LEADING, 0, 47, Short.MAX_VALUE))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			    .addComponent(button_equals, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_0, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_decimalPoint, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_signChange, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
			    .addComponent(button_ans, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
			.addContainerGap());
		layout.setHorizontalGroup(layout.createParallelGroup()
			.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
			    .addComponent(jScrollPane_output, 0, 1070, Short.MAX_VALUE)
			    .addContainerGap())
			.addGroup(layout.createSequentialGroup()
			    .addPreferredGap(jScrollPane_output, button_0, LayoutStyle.ComponentPlacement.INDENT)
			    .addGroup(layout.createParallelGroup()
			        .addComponent(button_0, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_4, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_7, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(layout.createParallelGroup()
			        .addComponent(button_decimalPoint, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_5, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_8, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
			    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			    .addGroup(layout.createParallelGroup()
			        .addComponent(button_signChange, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
			        .addComponent(button_9, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
			    .addGap(25)
			    .addGroup(layout.createParallelGroup()
			        .addGroup(layout.createSequentialGroup()
			            .addGroup(layout.createParallelGroup()
			                .addComponent(button_equals, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
			                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
			                    .addComponent(button_backspace, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
			                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
			            .addGroup(layout.createParallelGroup()
			                .addGroup(layout.createSequentialGroup()
			                    .addComponent(button_undo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
			                    .addGap(0, 0, Short.MAX_VALUE))
			                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
			                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			                    .addComponent(button_ans, 0, 102, Short.MAX_VALUE))))
			        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
			            .addGroup(layout.createParallelGroup()
			                .addComponent(button_add, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
			                .addComponent(button_multiply, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
			            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			            .addGroup(layout.createParallelGroup()
			                .addComponent(button_substraction, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
			                .addComponent(button_divide, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
			            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			            .addGroup(layout.createParallelGroup()
			                .addComponent(button_squareRoot, GroupLayout.Alignment.LEADING, 0, 66, Short.MAX_VALUE)
			                .addGroup(layout.createSequentialGroup()
			                    .addComponent(button_power, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
			                    .addGap(0, 0, Short.MAX_VALUE)))
			            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			            .addComponent(button_clear, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
			    .addContainerGap(637, 637)));
		pack();
	}
}
