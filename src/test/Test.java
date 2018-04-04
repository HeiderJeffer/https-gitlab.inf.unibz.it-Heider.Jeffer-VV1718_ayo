package test;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import main.Account;
import main.CRComponent;
import main.CSVReader;
import main.Company;
import main.Example1Checker;
import main.ProfitCenter;
import types.DataScenarioType;

public class Test {	
	ArrayList<String[]> accountCSV;

	Example1Checker checker = new Example1Checker();

	Company company = new Company(); // dummy object
	ProfitCenter profitCenter = new ProfitCenter(); // dummy object
	CRComponent crComponent = new CRComponent(); // dummy object
	boolean external = true; // dummy value
	DataScenarioType scenarioType = new DataScenarioType(""); // dummy value
	String currencyCode = "$"; // dummy value

	@Before
	public void setUp() throws Exception {
		System.out.println("Load Account.csv file");
		
		String accountCSVLoc = "data/Account.csv";
		accountCSV = CSVReader.reader(accountCSVLoc, ",", 1);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finish testing");
	}

	@org.junit.Test
	public void test1() {
		for (int i=0;i<accountCSV.size();i++) {		
			String[] row = accountCSV.get(i);

			Boolean isPartnerAllowed = Boolean.valueOf(row[3]);
			Account account = new Account(row[0],row[1],row[2],isPartnerAllowed);

			// Check prefix NDS_AF
			if (row[0].startsWith("NDS_AF")) {
				System.out.println(i + ". " + row[0] + " " + row[1] + " " + row[2] + " " + row[3]);
				assertEquals(isPartnerAllowed,checker.isValid(company, profitCenter, crComponent, isPartnerAllowed, scenarioType, account, currencyCode, currencyCode));
				System.out.println("Testing complete for line " + i);
				System.out.println();
			}
		}
	}

}
