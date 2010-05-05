package fi.hy.laskin.test;

import fi.hy.laskin.main.Calculator;
import fi.hy.laskin.main.Const;
import fi.hy.laskin.main.Controller;
import fi.hy.laskin.main.OutputDevice;
import fi.hy.laskin.main.SoundEffectsPlayer;
import fi.hy.laskin.main.View;
import fi.hy.laskin.main.calculator.Calculator_Imple;
import fi.hy.laskin.main.control.Controller_Implementation;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Controller_Impl_Test {

	public static Test suite() {
		return new TestSuite(Controller_Impl_Test.class.getDeclaredClasses());
	}

	public static class WhenSendingEventsToController extends TestCase {

		private static final String	FILENAME_THAT_THE_OUTPUT_DEVICE_GIVES	= "FILENAME_THAT_THE_OUTPUT_DEVICE_GIVES";

		private class MockView implements View {
			public boolean				openFileCreatedDialogCalled	= false;
			public String				filename					= "";
			public Map<Integer, Double>	memory;

			public void assignController(Controller controller) {}

			public void setOutput(String output) {
				viewOutput = output;
			}

			public void setVisible() {}

			public void fileCreated(String filename) {
				openFileCreatedDialogCalled = true;
				this.filename = filename;
			}

			public void setMemory(Map<Integer, Double> memory) {
				this.memory = memory;
			}
		}

		private class MockCalculator implements Calculator {
			private final List<String>	fakeOutput;

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

			public List<String> ans() {
				calculatorCommands += Const.ANS;
				return fakeOutput;
			}

			public List<String> store() {
				calculatorCommands += Const.STORE;
				return fakeOutput;
			}

			public List<String> load() {
				calculatorCommands += Const.LOAD;
				return fakeOutput;
			}

			public Map<Integer, Double> getMemory() {
				Map<Integer, Double> memory = new HashMap<Integer, Double>();
				memory.put(1, 5.0D);
				memory.put(2, Math.PI);
				return memory;
			}

			public ArrayList<String> pi() {return null;}
		}

		private class MockOutputDevice implements OutputDevice {
			public Boolean	called	= false;

			public String print(List<String> results) {
				called = true;
				return FILENAME_THAT_THE_OUTPUT_DEVICE_GIVES;
			}
		}

		private Controller			controller;
		private Calculator			mockCalculator;
		private MockView			mockView;
		private String				viewOutput;
		private String				calculatorCommands;
		private MockOutputDevice	mockOutputDevice;

		@Override
		protected void setUp() {
			controller = new Controller_Implementation();
			mockCalculator = new MockCalculator();
			mockView = new MockView();
			mockOutputDevice = new MockOutputDevice();
			controller.assignModel(mockCalculator);
			controller.assignView(mockView);
			controller.assignResultOutputDevice(Const.EXPORT_TO_TEXTFILE, mockOutputDevice);
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
			triggerEvent(Const.ANS);
			String expected =
					Const.DECIMAL_SEPARATOR +
							Const.EQUALS +
							Const.CLEAR +
							Const.UNDO +
							Const.CHANGE_SIGN +
							Const.BACKSPACE +
							Const.ANS;
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

		public void test___it_uses_textfile_exporter() {
			triggerEvent(Const.EXPORT_TO_TEXTFILE);
			assertTrue("Outputdevice should be called", mockOutputDevice.called);
			assertTrue("Should call view's file created dialog", mockView.openFileCreatedDialogCalled);
			assertEquals(FILENAME_THAT_THE_OUTPUT_DEVICE_GIVES, mockView.filename);
		}

		public void test__it_updates_memory_to_view() {
			triggerEvent(Const.ONE);
			assertEquals(mockCalculator.getMemory(), mockView.memory);
		}
	}

	public static class WhenPlayingSounds extends TestCase {

		private static final String	OTHER_MOCK_PLAYER	= "otherMockPlayer";
		private static final String	MOCKPLAYER			= "mockplayer";

		private class MockSoundEffectsPlayer implements SoundEffectsPlayer {
			public int	keyPressedSoundPlayedCount	= 0;
			public int	errorSoundPlayedCount		= 0;

			@Override
			public void error() {
				errorSoundPlayedCount++;
			}

			@Override
			public void keyPressed() {
				keyPressedSoundPlayedCount++;
			}
		}

		private Controller				controller;
		private Calculator				calculator;
		private MockSoundEffectsPlayer	mockSoundEffectsPlayer;
		private MockSoundEffectsPlayer	otherMockSoundEffectsPlayer;
		private View					mockView;

		@Override
		protected void setUp() {
			mockView = new View() {
				@Override
				public void setVisible() {}

				@Override
				public void setOutput(String output) {}

				@Override
				public void fileCreated(String filename) {}

				@Override
				public void assignController(Controller controller) {}

				public void setMemory(Map<Integer, Double> memory) {}
			};
			controller = new Controller_Implementation();
			calculator = new Calculator_Imple();
			mockSoundEffectsPlayer = new MockSoundEffectsPlayer();
			otherMockSoundEffectsPlayer = new MockSoundEffectsPlayer();
			controller.assignModel(calculator);
			controller.assignView(mockView);
			controller.assignSoundEfectsPlayer(MOCKPLAYER, mockSoundEffectsPlayer);
			controller.assignSoundEfectsPlayer(OTHER_MOCK_PLAYER, otherMockSoundEffectsPlayer);
		}

		private void triggerEvent(String command) {
			ActionEvent e = new ActionEvent(new JButton(), 0, command);
			controller.process(e);
		}

		public void test___it_uses_soundefectplayer_after_key_pressed() {
			triggerEvent(Const.ONE);
			assertEquals(1, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			triggerEvent(Const.ADD);
			assertEquals(2, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			triggerEvent(Const.ONE);
			assertEquals(3, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			triggerEvent(Const.EQUALS);
			assertEquals(4, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(0, mockSoundEffectsPlayer.errorSoundPlayedCount);
		}

		public void test___it_uses_soundefectplayer_to_play_error_sound___if_key_press_does_nothing() {
			triggerEvent(Const.ONE);
			assertEquals(1, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			triggerEvent(Const.ADD);
			assertEquals(2, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			triggerEvent(Const.EQUALS);
			assertEquals(2, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(1, mockSoundEffectsPlayer.errorSoundPlayedCount);
		}

		public void test___it_doesnt_play_sounds_for__non_calculator_related_events() {
			triggerEvent(Const.EXPORT_TO_TEXTFILE);
			assertEquals(0, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(0, mockSoundEffectsPlayer.errorSoundPlayedCount);
		}

		public void test___it_changes_audio_player() {
			triggerEvent(Const.ONE);
			assertEquals(1, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			triggerEvent(OTHER_MOCK_PLAYER);
			assertEquals(1, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(0, otherMockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			triggerEvent(Const.ONE);
			assertEquals(1, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(1, otherMockSoundEffectsPlayer.keyPressedSoundPlayedCount);
		}

		public void test___plays_clicks__when_storing_to_memory() {
			triggerEvent(Const.ONE);
			triggerEvent(Const.ONE);
			assertEquals(2, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(0, mockSoundEffectsPlayer.errorSoundPlayedCount);
			triggerEvent(Const.STORE);
			assertEquals(3, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(0, mockSoundEffectsPlayer.errorSoundPlayedCount);
			triggerEvent(Const.ONE);
			assertEquals(4, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
			assertEquals(0, mockSoundEffectsPlayer.errorSoundPlayedCount);
		}

		// public void test___plays_error_if_incorretly_sotring_to_memory() {
		// triggerEvent(Const.ONE);
		// triggerEvent(Const.ONE);
		// assertEquals(2, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
		// assertEquals(0, mockSoundEffectsPlayer.errorSoundPlayedCount);
		// triggerEvent(Const.STORE);
		// assertEquals(3, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
		// assertEquals(0, mockSoundEffectsPlayer.errorSoundPlayedCount);
		// triggerEvent(Const.ANS);
		// assertEquals(3, mockSoundEffectsPlayer.keyPressedSoundPlayedCount);
		// assertEquals(1, mockSoundEffectsPlayer.errorSoundPlayedCount);
		// }

	}

}
