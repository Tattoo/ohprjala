package fi.hy.laskin.main.outputdevice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;


import fi.hy.laskin.main.OutputDevice;

public class TextfileWriter implements OutputDevice {
		
	public String print(List<String> results) {
		Calendar cal = Calendar.getInstance();
		String fn = "" + cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE)
				  + "_" + cal.get(Calendar.HOUR) + "" + cal.get(Calendar.MINUTE) + "" + cal.get(Calendar.SECOND) + ".txt";
		
		File f = new File("output", fn);
		
		try {
			PrintWriter fw = new PrintWriter(f);
			for(int i = 0; i < results.size(); i++) {
				fw.println(results.get(i));
			}
			fw.close();
		} catch (IOException e) {
			return null;
		}
		
		return fn;
	}	
}
