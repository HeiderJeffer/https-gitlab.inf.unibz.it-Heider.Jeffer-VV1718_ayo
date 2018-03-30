package test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import main.Example1Checker;
import app.Account;

public class Test {
	ArrayList<String[]> accountCSV;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Load Account.csv file");
		accountCSV = new ArrayList<String[]>();
		
		String csvFile = "data/Account.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			int counter = 0;
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				if (counter++ == 0) continue;
				else accountCSV.add(line.split(cvsSplitBy));
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
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finish testing");
	}

	@org.junit.Test
	public void testAccount() {
		Example1Checker checker = new Example1Checker();
		
		for (int i=0;i<accountCSV.size();i++) {
			String[] row = accountCSV.get(i);
			Boolean isPartnerAllowed = Boolean.valueOf(row[3]);
			Account account = new Account(row[0],row[1],row[2],isPartnerAllowed);
			
			// Check prefix NDS_AF
			if (row[0].startsWith("NDS_AF")) {
				
				assertEquals(isPartnerAllowed,checker.isValid(account));
			}
		}
	}

}
