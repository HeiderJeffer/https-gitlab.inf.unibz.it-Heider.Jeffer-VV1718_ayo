package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	public static ArrayList<String[]> reader(String location, String delimiter, int startRow) {
		ArrayList<String[]> list = new ArrayList<String[]>();

		BufferedReader br = null;
		String line = "";

		try {
			int counter = 0;
			br = new BufferedReader(new FileReader(location));
			while ((line = br.readLine()) != null) {
				if (counter++ < startRow) continue;
				
				list.add(line.split(delimiter));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
}
