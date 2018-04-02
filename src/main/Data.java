package main;

import adapters.ICompany;
import adapters.IData;
import types.DataScenarioType;

public class Data implements IData {

	Company company;
	ProfitCenter profitCenter;
	CRComponent crComponent;
	boolean isExtern;
	DataScenarioType scenario;
	Account account;
	String partnerCode;
	String currencyCode;
	int year;
	double[] data;
	
	public Data(Company company, ProfitCenter profitCenter, CRComponent crComponent, boolean isExtern, DataScenarioType scenario, Account account, String partnerCode, String currencyCode, int year, double[] data) {
		this.company = company;
		this.profitCenter = profitCenter;
		this.crComponent = crComponent;
		this.isExtern = isExtern;
		this.scenario = scenario;
		this.account = account;
		this.partnerCode = partnerCode;
		this.currencyCode = currencyCode;
		this.year = year;
		this.data = data;
	}
	
	@Override
	public ICompany getCompany() {
		return this.company;
	}

	@Override
	public ProfitCenter getProfitCenter() {
		return this.profitCenter;
	}

	@Override
	public CRComponent getCRComponent() {
		return this.crComponent;
	}

	@Override
	public boolean isExtern() {
		return this.isExtern;
	}

	@Override
	public DataScenarioType getScenario() {
		return this.scenario;
	}

	@Override
	public Account getAccount() {
		return this.account;
	}

	@Override
	public String getPartnerCode() {
		return this.partnerCode;
	}

	@Override
	public String getCurrencyCode() {
		return this.currencyCode;
	}

	@Override
	public int getYear() {
		return this.year;
	}

	@Override
	public double[] getData() {
		return this.data;
	}
	
}
