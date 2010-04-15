package fi.hy.laskin.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import fi.hy.laskin.main.calculator.Calculator_Imple;
import fi.hy.laskin.main.filewriter.TextfileWriter;
import junit.framework.TestCase;

public class TextfileWriter_Test extends TestCase {
	private Calculator_Imple calc;
	private TextfileWriter writer;
	
	protected void setUp() throws Exception {
		super.setUp();
		writer = new TextfileWriter();
		calc = new Calculator_Imple();
		calc.addDigit(15);
		calc.add();
		calc.addDigit(15);
	}

	public void test_write_file() throws FileNotFoundException {
		String fn = writer.print(calc.calculate());
		File f = new File("output", fn);
		String expected = "15.0 + 15 = 30.0\n30.0\n";
		String output = "";
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine())
			output = output + sc.nextLine() + "\n"; 
		sc.close();	
		assertEquals(expected, output);
		
		f.delete();
		
	}
	
}
