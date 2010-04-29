package fi.hy.laskin.main.control;

import fi.hy.laskin.main.Calculator;
import fi.hy.laskin.main.Const;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.OutputDevice;
import fi.hy.laskin.main.SoundEffectsPlayer;
import fi.hy.laskin.main.View;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Controller_Implementation implements Controller {

	private static final long	serialVersionUID	= 8393096071539802563L;
	private View view;
	private Calculator calculator;
	private List<String> outputContents;
	private final Map<String, OutputDevice> outputDevices;
	private final Map<String, SoundEffectsPlayer> soundEffectPlayers;
	private SoundEffectsPlayer currentSoundEffectsPlayer;
	private String previousLine = "";
	
	public Controller_Implementation() {
		this.outputContents = new ArrayList<String>();
		this.outputDevices = new HashMap<String, OutputDevice>();
		this.soundEffectPlayers = new HashMap<String, SoundEffectsPlayer>();
	}
	 
	@Override
	public void assignView(View view) {
		this.view = view;
	}
	
	public void assignModel(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void assignResultOutputDevice(String name, OutputDevice outputDevice) {
		this.outputDevices.put(name, outputDevice);
	}
	
	@Override
	public void assignSoundEfectsPlayer(String name, SoundEffectsPlayer player) {
		this.soundEffectPlayers.put(name, player);
		if (currentSoundEffectsPlayer == null) {
			currentSoundEffectsPlayer = player;
		}
	}
	
	public void process(ActionEvent e) {
		//System.out.println(e);
		String command = e.getActionCommand();
		callModel(command);
		updateView();
		if (isCalculatorCommand(command)) {
			playSoundEffects();
		}
	}
	
	private boolean isCalculatorCommand(String command) {
		return isDigit(command) || isOperand(command) || isOtherCalculatorCommand(command);
	}
	
	private void updateView() {
		StringBuilder output = new StringBuilder();
		for (String s : outputContents) {
			output.append(s).append("\n");
		}
		removeLastLineBrake(output);
		view.setOutput(output.toString());
	}
	
	private void playSoundEffects() {
		if (currentSoundEffectsPlayer == null) return;
		String lastLine = lastLine(); 
		if (!lastLine.equals(previousLine)) {
			currentSoundEffectsPlayer.keyPressed();
		} else {
			currentSoundEffectsPlayer.error();
		}
		previousLine = lastLine;
	}

	private String lastLine() {
		if (outputContents.isEmpty()) return "";
		return outputContents.get(outputContents.size()-1);
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
		} else if (command.equals(Const.ANS)) {
			outputContents = calculator.ans();
		} 
//		else if (command.equals(Const.STORE)) {
//			outputContents = calculator.store();
//		} else if (command.equals(Const.LOAD)) {
//			outputContents = calculator.load();
//		} 
		else {
			trytoUseOutputDevice(command);
			tryToChangeSoundEffectsPlayer(command);
		}
	}

	private void tryToChangeSoundEffectsPlayer(String command) {
		SoundEffectsPlayer soundEffectsPlayer = soundEffectPlayers.get(command);
		if (soundEffectsPlayer == null) return;
		currentSoundEffectsPlayer = soundEffectsPlayer;
	}
	
	private void trytoUseOutputDevice(String command) {
		OutputDevice outputDevice = outputDevices.get(command);
		if (outputDevice == null) return;
		String filename = outputDevice.print(outputContents);
		view.fileCreated(filename);
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
	
	private boolean isOperand(String command) {
		return Const.OPERANDS.contains(command);
	}
	
	private boolean isOtherCalculatorCommand(String command) {
		return Const.OTHER_CALCULATOR_COMMANDS.contains(command);
	}
	
	
}
