package fi.hy.laskin.test;

import fi.hy.laskin.main.Calculator;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.Controller_Implementation;
import fi.hy.laskin.main.View;

import java.awt.event.ActionEvent;
import java.util.List;

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
			public List<String> add() {
				return null;
			}
			public List<String> addDecimalPoint() {
				return null;
			}
			public List<String> addDigit(int digit) {
				calculatorCommands += digit;
				return null;
			}
			public List<String> calculate() {
				return null;
			}
			public List<String> changeSign() {
				return null;
			}
			public List<String> clear() {
				return null;
			}
			public List<String> divide() {
				return null;
			}
			public List<String> erase() {
				return null;
			}
			public List<String> getSquareRoot() {
				return null;
			}
			public List<String> multiply() {
				return null;
			}
			public List<String> raiseToPower() {
				return null;
			}
			public List<String> undo() {
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
			mockView.assignController(controller);
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
			ActionEvent e = new ActionEvent(null, 0, command);
			controller.process(e);
		}     

	}





}
