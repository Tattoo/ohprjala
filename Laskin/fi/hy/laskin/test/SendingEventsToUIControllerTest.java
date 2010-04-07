package fi.hy.laskin.test;

import fi.hy.laskin.main.Calculator;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.Controller_Implementation;
import fi.hy.laskin.main.View;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class SendingEventsToUIControllerTest {

	public static Test suite() {
		return new TestSuite(SendingEventsToUIControllerTest.class.getDeclaredClasses());
	}

	public static class X extends TestCase {

		private class MockView implements View {
			public void assignController(Controller controller) {
				// TODO Auto-generated method stub
				
			}
			public void setOutput(String output) {
				// TODO Auto-generated method stub
				
			}
			public void setVisible() {
				// TODO Auto-generated method stub
				
			}
		}
		
		private class MockCalculator implements Calculator {
			public List<String> add() {
				return null;
			}
			public List<String> addDecimalPoint() {
				return null;
			}
			public List<String> addDigit(int digit) {
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
		
		protected void setUp() {
			controller = new Controller_Implementation();
			mockCalculator = new MockCalculator();
			mockView = new MockView();
			mockView.assignController(controller);
			controller.assignModel(mockCalculator);
			controller.assignView(mockView);
		} 

		public void test_() {
			
		}     

	}





}
