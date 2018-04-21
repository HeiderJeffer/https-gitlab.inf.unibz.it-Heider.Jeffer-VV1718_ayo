package com.wuerth.phoenix.cis.university.example1.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	public static ArrayList<String[]> getAll(String path, String delimiter, int startRow) {
		ArrayList<String[]> list = new ArrayList<String[]>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int counter = 0;
		String currentLine;
		try {
			while((currentLine = br.readLine()) != null){
				if(counter++<startRow) continue;
				else list.add(currentLine.split(delimiter));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static ArrayList<String[]> getAll(String path, String delimiter, int startRow, int startColumn) {
		ArrayList<String[]> list = new ArrayList<String[]>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int counter = 0;
		String currentLine;
		try {
			while((currentLine = br.readLine()) != null){
				if(counter++<startRow) continue;
				else {
					String[] temp = currentLine.split(delimiter);
					String[] row = new String[temp.length-startColumn];
					for(int i=0;i<row.length;i++) {
						row[i] = temp[i+startColumn];
					}
					list.add(row);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
