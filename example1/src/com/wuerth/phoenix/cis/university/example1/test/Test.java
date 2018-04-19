package com.wuerth.phoenix.cis.university.example1.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
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
	
	private boolean oracle;

	public Test(ICompany company, IProfitCenter profitCenter, ICRComponent crComponent, boolean external, DataScenarioType scenarioType, IAccount account, String partnerCode, String currencyCode, boolean oracle) {
		this.company = company;
		this.profitCenter = profitCenter;
		this.crComponent = crComponent;
		this.external = external;
		this.scenarioType = scenarioType;
		this.account = account;
		this.partnerCode = partnerCode;
		this.currencyCode = currencyCode;
		
		this.oracle = oracle;
	}

	@Parameterized.Parameters
	public static Collection combinations() throws IOException {
		// read combinations.csv and assign to combinations	
		String rootProjectPath = System.getProperty("user.dir");
		String path = rootProjectPath + "\\data\\combinations.csv";

		Scanner scanner = new Scanner(new File(path));
		scanner.nextLine(); // skip the header

		Object[][] combinations = new Object[84][8];

		int counter = 0;
		while(scanner.hasNext()){
			String temp = scanner.next(); System.out.println(temp);
			String[] line = temp.split(",");

			ICompany company = new Company();
			IProfitCenter profitCenter = new ProfitCenter(
					line[0],
					Boolean.parseBoolean(line[1]));

			ICRComponent crComponent = new CRComponent(
					line[2],
					Boolean.parseBoolean(line[3]),
					Boolean.parseBoolean(line[4]),
					Boolean.parseBoolean(line[5]));

			boolean external = Boolean.parseBoolean(line[6]);

			DataScenarioType scenarioType = null;
			DataScenarioType[] dt = DataScenarioType.values();
			for(DataScenarioType d: dt) {
				if(d.toString().equals(line[7]))
					scenarioType = d;
			}

			IAccount account = new Account(
					line[8],
					line[9],
					line[10],
					Boolean.parseBoolean(line[11]));
			String partnerCode = line.length>12 ? line[12] : null;
			String currencyCode = line.length>13 ? line[13] : null;

			combinations[counter++] = new Object[]{company, profitCenter, crComponent, external, scenarioType, account, partnerCode, currencyCode, true};
		}
		scanner.close();

		return Arrays.asList(combinations);
	}

	@org.junit.Test
	public void test() {
		Example1Checker checker = new Example1Checker();
		
		boolean result = checker.isValid(company, profitCenter, crComponent, external, scenarioType, account, partnerCode, currencyCode);

		assertEquals(oracle, result);
	}
}
