package fi.hy.laskin.main;

import java.awt.event.ActionEvent;

public class Controller_Implementation implements Controller {

	private static final long	serialVersionUID	= 8393096071539802563L;
	private View view;
	private Calculator calculator;
	private String outputContents;

	public Controller_Implementation() {
		this.outputContents = "";
	}
	
	@Override
	public void assignView(View view) {
		this.view = view;
	}
	
	public void assignModel(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void process(ActionEvent e) {
		callModel(e.getActionCommand());
		updateView();
	}
	
	private void updateView() {
		outputContents = ""; // TODO get contents
		view.setOutput(outputContents);
	}
	
	private void callModel(String command) {
		// TODO calls to model
		if (isDigit(command)) {
			
		} 
		if (isOperand(command)) {
			
		}
//		public static final String	DECIMAL_SEPARATOR	= ",";
//		public static final String	EQUALS	= "=";
//		public static final String	CLEAR	= "clear";
//		public static final String	UNDO	= "undo";
//		public static final String	CHANGE_SIGN	= "+/-";
//		public static final String	BACKSPACE	= "backspace";
	}

	private boolean isOperand(String command) {
		return Const.OPERANDS.contains(command);
	}

	private boolean isDigit(String command) {
		return Const.DIGITS.contains(command);
	}

	
	
}
