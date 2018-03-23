package adapters;

import types.DataScenarioType;

public interface IData {

	public ICompany getCompany();
	public IProfitCenter getProfitCenter();
	public ICRComponent getCRComponent();
	public boolean isExtern();
	
	public DataScenarioType getScenario();
	
	public IAccount getAccount();
	public String getParternCode();
	public String getCurrencyCode();
	
	public int getYear();
	public double[] getData();
}
