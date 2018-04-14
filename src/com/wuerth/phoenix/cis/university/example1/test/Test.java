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

		Scanner scanner = new Scanner(new File(path));
		scanner.nextLine(); // skip the header
		
		Object[][] combinations = new Object[3][8];
		
		int counter = 0;
		while(scanner.hasNext()){
			String[] line = scanner.next().split(",");
			combinations[counter++] = new Object[]{null,null,null,Boolean.parseBoolean(line[3]),null,null,null,null};
		}
		scanner.close();
		  
		return Arrays.asList(combinations);
	}

	@org.junit.Test
	public void test() {
		Example1Checker checker = new Example1Checker();

		boolean oracle = false;
		boolean result = checker.isValid(company, profitCenter, crComponent, external, scenarioType, account, partnerCode, currencyCode);

		assertEquals(oracle, result);
	}
}
