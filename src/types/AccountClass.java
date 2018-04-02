package types;

public class AccountClass {

	String[] accountClasses = {
			"SalesReporting",
			"PLStatement",
			"AllocationFormula",
			"BalanceSheet",
			"Logistics"
	};
	
	public String accountClass;

	public AccountClass (String accountClass) {
		this.accountClass = accountClass;
	}
}
