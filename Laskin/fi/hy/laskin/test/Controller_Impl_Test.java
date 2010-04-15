package fi.hy.laskin.test;

import fi.hy.laskin.main.Calculator;
import fi.hy.laskin.main.Const;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.View;
import fi.hy.laskin.main.control.Controller_Implementation;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Controller_Impl_Test {

	public static Test suite() {
		return new TestSuite(Controller_Impl_Test.class.getDeclaredClasses());
	}
	
	public static class WhenSendingEventsToController extends TestCase {

		private class MockView implements View {
			public void assignController(Controller controller) { }
			public void setOutput(String output) {
				viewOutput = output;
			}
			public void setVisible() {}
		}
		
		private class MockCalculator implements Calculator {
			private final List<String> fakeOutput;
			public MockCalculator() {
				fakeOutput = new ArrayList<String>();
				fakeOutput.add("1 + 1");
				fakeOutput.add("  2");
				fakeOutput.add("Ans+5");
				fakeOutput.add("  7");
			}
			
			public List<String> add() {
				calculatorCommands += Const.ADD;
				return fakeOutput;
			}
			public List<String> addDecimalPoint() {
				calculatorCommands += Const.DECIMAL_SEPARATOR;
				return fakeOutput;
			}
			public List<String> addDigit(int digit) {
				calculatorCommands += digit;
				return fakeOutput;
			}
			public List<String> calculate() {
				calculatorCommands += Const.EQUALS;
				return fakeOutput;
			}
			public List<String> changeSign() {
				calculatorCommands += Const.CHANGE_SIGN;
				return fakeOutput;
			}
			public List<String> clear() {
				calculatorCommands += Const.CLEAR;
				return fakeOutput;
			}
			public List<String> divide() {
				calculatorCommands += Const.DIVIDE;
				return fakeOutput;
			}
			public List<String> erase() {
				calculatorCommands += Const.BACKSPACE;
				return fakeOutput;
			}
			public List<String> getSquareRoot() {
				calculatorCommands += Const.SQRT;
				return fakeOutput;
			}
			public List<String> multiply() {
				calculatorCommands += Const.MULTIPLY;
				return fakeOutput;
			}
			public List<String> raiseToPower() {
				calculatorCommands += Const.RAISE_TO_POWER;
				return fakeOutput;
			}
			public List<String> undo() {
				calculatorCommands += Const.UNDO;
				return fakeOutput;
			}
			public List<String> substract() {
				calculatorCommands += Const.SUBSTRACT;
				return fakeOutput;
			}

			public ArrayList<String> ans() {
				// TODO Auto-generated method stub
				return null;
			}
		}
		
		private Controller controller;
		private Calculator mockCalculator;
		private View mockView;
		private String viewOutput;
		private String calculatorCommands;
		
		protected void setUp() {
			controller = new Controller_Implementation();
			mockCalculator = new MockCalculator();
			mockView = new MockView();
			controller.assignModel(mockCalculator);
			controller.assignView(mockView);
			viewOutput = "";
			calculatorCommands = "";
		} 

		public void test__it_calls_models_add_digit_method_after_digit_is_typed() {
			triggerEvent("1");
			assertEquals("1", calculatorCommands);
		}
		
		private void triggerEvent(String command) {
			ActionEvent e = new ActionEvent(new JButton(), 0, command);
			controller.process(e);
		}    
		
		public void test__it_calls_models_add_digit_method() {
			triggerEvent("1");
			triggerEvent("2");
			triggerEvent("3");
			triggerEvent("4");
			triggerEvent("5");
			triggerEvent("6");
			triggerEvent("7");
			triggerEvent("8");
			triggerEvent("9");
			triggerEvent("0");
			assertEquals("1234567890", calculatorCommands);
		}
		
		public void test__it_calls_models_operad_methods() {
			triggerEvent(Const.ADD);
			triggerEvent(Const.SUBSTRACT);
			triggerEvent(Const.MULTIPLY);
			triggerEvent(Const.DIVIDE);
			triggerEvent(Const.RAISE_TO_POWER);
			triggerEvent(Const.SQRT);
			String expected = 
				Const.ADD +
				Const.SUBSTRACT +
				Const.MULTIPLY + 
				Const.DIVIDE + 
				Const.RAISE_TO_POWER + 
				Const.SQRT;
			assertEquals(expected, calculatorCommands);
		}
		
		public void test__it_calls_models_other_methods() {
			triggerEvent(Const.DECIMAL_SEPARATOR);
			triggerEvent(Const.EQUALS);
			triggerEvent(Const.CLEAR);
			triggerEvent(Const.UNDO);
			triggerEvent(Const.CHANGE_SIGN);
			triggerEvent(Const.BACKSPACE);
			String expected = 
				Const.DECIMAL_SEPARATOR +
				Const.EQUALS +
				Const.CLEAR + 
				Const.UNDO + 
				Const.CHANGE_SIGN + 
				Const.BACKSPACE;
			assertEquals(expected, calculatorCommands);
		}
		
		public void test__output_is_initially_empty() {
			assertEquals("", viewOutput);
		}
		
		public void test__it_updates_output_to_view_after_processing_events() {
			triggerEvent(Const.EQUALS);
			String expected = "" +
			"1 + 1\n" + 
			"  2\n" + 
			"Ans+5\n" +
			"  7";
			assertEquals(expected, viewOutput);
		}
		

	}





}
