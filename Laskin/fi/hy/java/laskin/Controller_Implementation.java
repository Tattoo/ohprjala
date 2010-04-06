package fi.hy.java.laskin;

import java.awt.event.ActionEvent;

public class Controller_Implementation implements Controller {

	private static final long	serialVersionUID	= 8393096071539802563L;
	private View view;
	private String outputContents;

	public Controller_Implementation() {
		this.outputContents = "";
	}
	
	@Override
	public void assignView(View view) {
		this.view = view;
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
		if (Const.DIGITS.contains(command)) {
			
		} 
		if (Const.OPERANDS.contains(command)) {
			
		}
//		public static final String	DECIMAL_SEPARATOR	= ",";
//		public static final String	EQUALS	= "=";
//		public static final String	CLEAR	= "clear";
//		public static final String	UNDO	= "undo";
//		public static final String	CHANGE_SIGN	= "+/-";
//		public static final String	BACKSPACE	= "backspace";
	}
	
}