package fi.hy.laskin.main.control;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import fi.hy.laskin.main.Calculator;
import fi.hy.laskin.main.Const;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.View;


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
	
	private void callModel(String command) {
		if (isDigit(command)) {
			outputContents = calculator.addDigit(toDigit(command));
		} else if (command.equals(Const.DECIMAL_SEPARATOR)){
			outputContents = calculator.addDecimalPoint();
		} else if (command.equals(Const.EQUALS)){
			outputContents = calculator.calculate();
		}  else if (command.equals(Const.ADD)){
			outputContents = calculator.add();
		}  else if (command.equals(Const.SUBSTRACT)){
			outputContents = calculator.substract();
		}  else if (command.equals(Const.DIVIDE)){
			outputContents = calculator.divide();
		}  else if (command.equals(Const.MULTIPLY)){
			outputContents = calculator.multiply();
		}  else if (command.equals(Const.RAISE_TO_POWER)){
			outputContents = calculator.raiseToPower();
		}  else if (command.equals(Const.SQRT)){
			outputContents = calculator.getSquareRoot();
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
