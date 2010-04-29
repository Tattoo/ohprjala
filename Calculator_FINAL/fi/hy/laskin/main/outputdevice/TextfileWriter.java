package fi.hy.laskin.main.outputdevice;

import fi.hy.laskin.main.OutputDevice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TextfileWriter implements OutputDevice {

	public String print(List<String> results) {
		results = new ArrayList<String>(results);

		for (int i = 0; i < results.size(); i++) {
			results.set(i, results.get(i).replace(" ", "\t"));
			results.set(i, results.get(i).replace(".", ","));
			results.set(i, results.get(i).replace("+", "\"+\""));
			results.set(i, results.get(i).replace("-", "\"-\""));
		}

		Calendar cal = Calendar.getInstance();
		String fn = "" + cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE)
					+ "_" + cal.get(Calendar.HOUR) + "" + cal.get(Calendar.MINUTE) + "" + cal.get(Calendar.SECOND) + ".txt";

		File f = new File("output", fn);

		try {
			PrintWriter fw = new PrintWriter(f);
			for (int i = 0; i < results.size(); i++) {
				fw.println(results.get(i));
			}
			fw.close();
		} catch (IOException e) {
			return null;
		}

		return fn;
	}
}
