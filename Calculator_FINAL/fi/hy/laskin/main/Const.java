package fi.hy.laskin.main;

import java.util.Collection;
import java.util.LinkedHashSet;

public class Const {

	public static final String				SEVEN							= "7";
	public static final String				EIGHT							= "8";
	public static final String				NINE							= "9";
	public static final String				FOUR							= "4";
	public static final String				FIVE							= "5";
	public static final String				SIX								= "6";
	public static final String				ONE								= "1";
	public static final String				TWO								= "2";
	public static final String				THREE							= "3";
	public static final String				ZERO							= "0";
	public static final String				DECIMAL_SEPARATOR				= ",";
	public static final String				EQUALS							= "=";
	public static final String				MULTIPLY						= "*";
	public static final String				CLEAR							= "clear";
	public static final String				SQRT							= "sqrt";
	public static final String				RAISE_TO_POWER					= "x^y";
	public static final String				DIVIDE							= "/";
	public static final String				ADD								= "+";
	public static final String				UNDO							= "undo";
	public static final String				CHANGE_SIGN						= "+/-";
	public static final String				SUBSTRACT						= "-";
	public static final String				BACKSPACE						= "backspace";
	public static final String				ANS								= "Ans";
	public static final String				LOAD							= "Load";
	public static final String				STORE							= "Store";
	public static final String				EXPORT_TO_TEXTFILE				= "Export to textfile";
	public static final String				SOUND_EFFECT_THEME__NO_SOUNDS	= "sound_effect_theme_no_sounds";
	public static final String				SOUND_EFFECT_THEME__CLICKS		= "sound_effect_theme_clicks";
	public static final String				SOUND_EFFECT_THEME__BEEPS		= "sound_effect_theme_beeps";
	public static final String				PI								= "Pi";
	
	public static final Collection<String>	DIGITS							= createStringCollection(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO);
	public static final Collection<String>	OPERANDS						= createStringCollection(MULTIPLY, SUBSTRACT, ADD, DIVIDE, SQRT, RAISE_TO_POWER);
	public static final Collection<String>	OTHER_CALCULATOR_COMMANDS		= createStringCollection(DECIMAL_SEPARATOR, EQUALS, CLEAR, UNDO, CHANGE_SIGN, BACKSPACE, ANS, STORE, LOAD, PI);
	
	private static Collection<String> createStringCollection(String... strings) {
		Collection<String> collection = new LinkedHashSet<String>();
		for (String s : strings) {
			collection.add(s);
		}
		return collection;
	}

}
