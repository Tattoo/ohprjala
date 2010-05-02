package fi.hy.laskin.main.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Generates a string presentation from a map of values that are stored to memory. 
 * For example:
 * 
 * 1: 5.0     6:
 * 2: 2,22222 7:
 * 3:         8: 1,345678
 * 4:         9:
 * 5:         0:
 * 
 */
public class MemoryTextGenerator {
	
	private final int[] slots;
	private final int maxLength;
	private final int maxRows;
	private Map<Integer, Double> values;
	private final String emptyValue;
	
	/**
	 * @param slots the order of slots, for example 1, 2, 3, 4, 5
	 * @param maxLenght the maximium length of value shown, for example if maxlenght is 5, then 1,555555556 is show as 1,555
	 * @param maxRows the maximum number of rows. If the number of slots exeeds maxrows, the rest of the slots are printed to a second column
	 */
	public MemoryTextGenerator(int[] slots, int maxLenght, int maxRows) {
		this.slots = slots;
		this.maxLength = maxLenght;
		if (maxRows > slots.length) this.maxRows = slots.length;
		else this.maxRows = maxRows;
		String emptyValue = "";
		for (int i = 0; i<maxLength; i++) {
			emptyValue += " ";
		}
		this.emptyValue = emptyValue;
	}
	
	public String generateText(Map<Integer, Double> values) {
		this.values = values;
		
		List<String> firstColumn = firstColumn();
		List<String> secondColumn = secondColumn();	
		
		StringBuilder text = new StringBuilder();
		for (int i = 0; i<maxRows; i++) {
			text.append(get(i, firstColumn)).append(" ").append(get(i, secondColumn)).append("\n");
		}
		
		return text.toString();
	}
	
	private List<String> secondColumn() {
		List<String> secondColumn = new ArrayList<String>();
		int i = 0;
		for (int slot : slots) {
			if (++i <= maxRows) continue;
			secondColumn.add(textFor(slot));
		}
		return secondColumn;
	}

	private List<String> firstColumn() {
		List<String> firstColumn = new ArrayList<String>();
		int i = 0;
		for (int slot : slots) {
			if (++i > maxRows) break;
			firstColumn.add(textFor(slot));
		}
		return firstColumn;
	}

	private String get(int i, List<String> column) {
		if (column.size() <= i) return "";
		return column.get(i);
	}
	
	private String textFor(int slot) {
		StringBuilder text = new StringBuilder();
		text.append(slot).append(": ").append(value(slot));
		return text.toString();
	}
	
	private String value(Integer key) {
		if (values == null) return emptyValue;
		if (!values.containsKey(key)) return emptyValue;
		String value = Double.toString(values.get(key));
		value = trimValuetoMaxLength(value);
		return value;
	}
	
	private String trimValuetoMaxLength(String value) {
		value += emptyValue;
		value = value.substring(0, maxLength);
		return value;
	}
	
}
