package fi.hy.laskin.test;

import fi.hy.laskin.main.view.MemoryTextGenerator;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MemoryTextGeneratorTest {

	public static Test suite() {
		return new TestSuite(MemoryTextGeneratorTest.class.getDeclaredClasses());
	}

	public static class GeneratingMemoryTexts extends TestCase {

		private MemoryTextGenerator generator;
		
		@Override
		protected void setUp() throws Exception {
		}
		
		public void test__one_slot_no_values() throws Exception {
			generator = new MemoryTextGenerator(new int [] {1}, 5, 1);
			assertEquals("1:       \n", generator.generateText(null));
		}

		public void test__more_slots_no_values() throws Exception {
			generator = new MemoryTextGenerator(new int [] {1,2,3,4,5}, 5, 10);
			String expected = 
				"1:       \n" +
				"2:       \n" +
				"3:       \n" +
				"4:       \n" +
				"5:       \n";
			assertEquals(expected, generator.generateText(null));
		}
		
		public void test__more_slots_no_values___longer_maxLength() throws Exception {
			generator = new MemoryTextGenerator(new int [] {1,2,3,4,5}, 10, 10);
			String expected = 
				"1:            \n" +
				"2:            \n" +
				"3:            \n" +
				"4:            \n" +
				"5:            \n";
			assertEquals(expected, generator.generateText(null));
		}
		
		public void test__two_columns() throws Exception {
			generator = new MemoryTextGenerator(new int [] {1,2,3,4,5}, 5, 3);
			String expected = 
				"1:       4:      \n" +
				"2:       5:      \n" +
				"3:       \n";
			assertEquals(expected, generator.generateText(null));
		}
		
		public void test__two_columns__with_values() throws Exception {
			generator = new MemoryTextGenerator(new int [] {1,2,3,4,5}, 5, 3);
			 
			Map<Integer, Double> values = new HashMap<Integer, Double>();
			values.put(1, 1.0D);
			values.put(3, 5.55D);
			values.put(5, Math.PI);
			
			String expected = 
				"1: 1.0   4:      \n" +
				"2:       5: 3.141\n" +
				"3: 5.55  \n";
			assertEquals(expected, generator.generateText(values));
		}
		
		
	}


}
