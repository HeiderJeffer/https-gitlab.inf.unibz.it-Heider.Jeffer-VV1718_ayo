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
	ArrayList<String[]> accountCombinationsCSV;

	Example1Checker checker = new Example1Checker();

	Company company = new Company(); // dummy object
	ProfitCenter profitCenter = new ProfitCenter(); // dummy object
	CRComponent crComponent = new CRComponent(); // dummy object
	boolean external = true; // dummy value
	DataScenarioType scenarioType = new DataScenarioType(""); // dummy value
	String currencyCode = "$"; // dummy value

	@Before
	public void setUp() throws Exception {
		System.out.println("Load Account.csv and AccountCombinations.csv");

		String accountCSVLoc = "data/Account.csv";
		accountCSV = CSVReader.reader(accountCSVLoc, ",", 1);

		String accountCombinationsCSVLoc = "data/AccountCombinations.csv";
		accountCombinationsCSV = CSVReader.reader(accountCombinationsCSVLoc, ",", 1);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finish testing");
	}

	@org.junit.Test
	public void test() {
		for(int i=0;i<accountCombinationsCSV.size();i++) {
			String[] row = accountCombinationsCSV.get(i);

			if(row[0].contains("-")) continue;
			else {
				for(int j=0;j<accountCSV.size();j++) {
					String[] row2 = accountCSV.get(j);

					if(row2[0].startsWith(row[0])) {
						Boolean isPartnerAllowed = Boolean.valueOf(row2[3]);
						Account account = new Account(row2[0],row2[1],row2[2],isPartnerAllowed);

						System.out.println((j+1) + ". " + row2[0] + " " + row2[1] + " " + row2[2] + " " + row2[3]);
						assertEquals(isPartnerAllowed,checker.isValid(company, profitCenter, crComponent, isPartnerAllowed, scenarioType, account, currencyCode, currencyCode));
						System.out.println("Testing complete for line " + (j+1));
						System.out.println();
					}
				}
			}
		}
	}

}
