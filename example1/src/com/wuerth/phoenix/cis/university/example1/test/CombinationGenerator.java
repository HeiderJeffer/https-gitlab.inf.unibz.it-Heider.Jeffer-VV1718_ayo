package com.wuerth.phoenix.cis.university.example1.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.wuerth.phoenix.cis.university.example1.Example1Checker;
import com.wuerth.phoenix.cis.university.example1.adapters.IAccount;
import com.wuerth.phoenix.cis.university.example1.adapters.ICRComponent;
import com.wuerth.phoenix.cis.university.example1.adapters.ICompany;
import com.wuerth.phoenix.cis.university.example1.adapters.IProfitCenter;
import com.wuerth.phoenix.cis.university.example1.types.DataScenarioType;

public class CombinationGenerator {
	public static void main(String[] args) throws IOException {
		String rootProjectPath = System.getProperty("user.dir");

		String accountFilePath = rootProjectPath + "\\data\\Account.csv";
		String crFilePath = rootProjectPath + "\\data\\CRComponent.csv";
		String pcFilePath = rootProjectPath + "\\data\\ProfitCenter.csv";

		ArrayList<String[]> accountList = CSVReader.getAll(accountFilePath, ",", 1, 1);
		ArrayList<String[]> crList = CSVReader.getAll(crFilePath, ",", 1, 1);
		ArrayList<String[]> pcList = CSVReader.getAll(pcFilePath, ",", 1, 1);

		accountList = removeDuplicate(accountList);
		crList = removeDuplicate(crList);
		pcList = removeDuplicate(pcList);

		ArrayList<String[]> combinations = combine(accountList, combine(pcList, crList));

		combinations = complementCombinationsParam(combinations);
		combinations = filterValidCombinations(combinations);
		
		String path = rootProjectPath + "\\data\\combinations.csv";
		write(path, combinations);
	}

	public static ArrayList<String[]> filterValidCombinations(ArrayList<String[]> list) {
		ArrayList<String[]> combinations = new ArrayList<String[]>();

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

			String partnerCode = row[12];
			String currencyCode = row[13];

			Example1Checker checker = new Example1Checker();
			boolean valid = false;
			try {
				valid = checker.isValid(company, profitCenter, crComponent, external, scenarioType, account, partnerCode, currencyCode);
			}
			catch (Exception e) {
			}

			if(valid)
				combinations.add(row);
		}

		return combinations;
	}

	public static ArrayList<String[]> complementCombinationsParam(ArrayList<String[]> list) {
		String pcName = "ProfitCenter";
		String crName = "CRComponent";
		String external = "TRUE";
		String dataScenarioType = "Actual";
		String accountCode = "Code";
		String partnerCode = null;
		String currencyCode = null;

		ArrayList<String[]> combinations = new ArrayList<String[]>();
		for(int i=0;i<list.size();i++) {
			String[] combination = list.get(i);			
			String[] row = new String[14];

			row[0] = accountCode;
			row[1] = combination[0];
			row[2] = combination[1];
			row[3] = combination[2];

			row[4] = pcName;
			row[5] = combination[3];

			row[6] = crName;
			row[7] = combination[4];
			row[8] = combination[5];
			row[9] = combination[6];

			row[10] = external;
			row[11] = dataScenarioType;
			row[12] = partnerCode;
			row[13] = currencyCode;

			combinations.add(row);
		}

		return combinations;
	}

	public static ArrayList<String[]> removeDuplicate(ArrayList<String[]> list) {
		ArrayList<String[]> newList = new ArrayList<String[]>();

		for(int i=0;i<list.size();i++) {
			String[] rowList = list.get(i);

			boolean found = false;
			for(int j=0;j<newList.size() && !found;j++) {
				String[] rowNewList = newList.get(j);

				if(Arrays.equals(rowList, rowNewList))
					found = true;
			}
			if(!found)
				newList.add(rowList);
		}

		return newList;
	}

	public static ArrayList<String[]> combine(ArrayList<String[]> firstList, ArrayList<String[]> secondList) {
		ArrayList<String[]> newList = new ArrayList<String[]>();

		for(int i=0;i<firstList.size();i++) {
			String[] firstListRow = firstList.get(i);
			for(int j=0;j<secondList.size();j++) {
				String[] secondListRow = secondList.get(j);

				String[] newListRow = concatenate(firstListRow, secondListRow);
				newList.add(newListRow);
			}
		}

		return newList;
	}

	public static void print(ArrayList<String[]> list) {
		for(int i=0;i<list.size();i++) {
			String[] row = list.get(i);

			for(int j=0;j<row.length;j++) {
				System.out.print(row[j] + " ");
			}
			System.out.println();
		}
	}

	public static void write(String path, ArrayList<String[]> list) throws IOException {
		BufferedWriter br = new BufferedWriter(new FileWriter(path));

		br.write("accountCode,accountClass,accountType,isPartnerAllowed,pcName,isNotAllocated,crName,isNotAllocated,isVKAllowed,isSEANAllowed,external,dataScenarioType,partnerCode,currencyCode" + "\n");
		for(int i=0;i<list.size();i++) {
			String[] row = list.get(i);

			StringBuilder sb = new StringBuilder();
			for(int j=0;j<row.length;j++) {
				sb.append(row[j]);

				if(j!=row.length-1)
					sb.append(",");
			}
			br.write(sb.toString() + "\n");
		}
		br.close();
	}

	public static <T> T[] concatenate(T[] a, T[] b) {
		int aLen = a.length;
		int bLen = b.length;

		@SuppressWarnings("unchecked")
		T[] c = (T[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);

		return c;
	}
}
