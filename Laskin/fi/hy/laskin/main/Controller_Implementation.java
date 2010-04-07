package fi.hy.laskin.main;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Controller_Implementation implements Controller {

	private static final long	serialVersionUID	= 8393096071539802563L;
	private View view;
	private Calculator calculator;
	private List<String> outputContents;

	public Controller_Implementation() {
		this.outputContents = new ArrayList<String>();
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
		StringBuilder output = new StringBuilder();
		for (String s : outputContents) {
			output.append(s).append("\n");
		}
		removeLastLineBrake(output);
		view.setOutput(output.toString());
	}
	
	private void removeLastLineBrake(StringBuilder output) {
		if (output.length() > 0) output.deleteCharAt(output.length()-1);
	}
	
	private void callModel(String command) {
		// TODO calls to model
		if (isDigit(command)) {
			outputContents = calculator.addDigit(toDigit(command));
		} else if (command.equals(Const.DECIMAL_SEPARATOR)){
			outputContents = calculator.addDecimalPoint();
		} else if (command.equals(Const.EQUALS)){
			outputContents = calculator.calculate();
		} else if (command.equals(Const.CLEAR)){
			outputContents = calculator.clear();
		} else if (command.equals(Const.UNDO)){
			outputContents = calculator.undo();
		} else if (command.equals(Const.CHANGE_SIGN)){
			outputContents = calculator.changeSign();
		} else if (command.equals(Const.BACKSPACE)){
			outputContents = calculator.erase();
		} 
	}
	
	private Integer toDigit(String command) {
		return Integer.valueOf(command);
	}

//	private boolean isOperand(String command) {
//		return Const.OPERANDS.contains(command);
//	}

	private boolean isDigit(String command) {
		return Const.DIGITS.contains(command);
	}

	
	
}
