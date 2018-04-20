package com.wuerth.phoenix.cis.university.example1.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.wuerth.phoenix.cis.university.example1.Example1Checker;
import com.wuerth.phoenix.cis.university.example1.adapters.IAccount;
import com.wuerth.phoenix.cis.university.example1.adapters.ICRComponent;
import com.wuerth.phoenix.cis.university.example1.adapters.ICompany;
import com.wuerth.phoenix.cis.university.example1.adapters.IProfitCenter;
import com.wuerth.phoenix.cis.university.example1.types.DataScenarioType;

@RunWith(Parameterized.class)
public class Test {
	private ICompany company;
	private IProfitCenter profitCenter;
	private ICRComponent crComponent;
	private boolean external;
	private DataScenarioType scenarioType;
	private IAccount account;
	private String partnerCode;
	private String currencyCode;
	
	public Test(ICompany company, IProfitCenter profitCenter, ICRComponent crComponent, boolean external, DataScenarioType scenarioType, IAccount account, String partnerCode, String currencyCode) {
		this.company = company;
		this.profitCenter = profitCenter;
		this.crComponent = crComponent;
		this.external = external;
		this.scenarioType = scenarioType;
		this.account = account;
		this.partnerCode = partnerCode;
		this.currencyCode = currencyCode;
	}

	@Parameterized.Parameters
	public static Collection combinations() throws IOException {
		// read combinations.csv and assign to combinations	
		String rootProjectPath = System.getProperty("user.dir");
		String path = rootProjectPath + "\\data\\combinations.csv";

		ArrayList<String[]> list = CSVReader.getAll(path, ",", 1);
		Object[][] combinations = new Object[list.size()][8];

		int counter = 0;
		for(int i=0;i<list.size();i++) {
			String[] row = list.get(i);

			IAccount account = new Account(
					row[0],
					row[1],
					row[2],
					Boolean.parseBoolean(row[3]));

			IProfitCenter profitCenter = new ProfitCenter(
					row[4],
					Boolean.parseBoolean(row[5]));

			ICRComponent crComponent = new CRComponent(
					row[6],
					Boolean.parseBoolean(row[7]),
					Boolean.parseBoolean(row[8]),
					Boolean.parseBoolean(row[9]));

			boolean external = Boolean.parseBoolean(row[10]);

			DataScenarioType scenarioType = null;
			DataScenarioType[] dt = DataScenarioType.values();
			for(DataScenarioType d: dt) {
				if(d.toString().equals(row[11]))
					scenarioType = d;
			}			

			ICompany company = new Company();

			String partnerCode = row[12].equals("null") ? null : row[12];
			String currencyCode = row[13].equals("null") ? null : row[13];

			combinations[counter++] = new Object[]{company, profitCenter, crComponent, external, scenarioType, account, partnerCode, currencyCode};
		}

		return Arrays.asList(combinations);
	}

	@org.junit.Test
	public void test() {
		Example1Checker checker = new Example1Checker();
		
		boolean result = checker.isValid(company, profitCenter, crComponent, external, scenarioType, account, partnerCode, currencyCode);

		assertTrue(result);
	}
}
