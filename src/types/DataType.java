package types;

public class DataType {

	String[] dataTypes = {
			"SalesReporting",
			"PLStatement",
			"AllocationFormula",
			"BalanceSheet",
			"Logistics",
			"Acquisition"
	};
	
	String dataType;
	
	public DataType (String dataType) {
		this.dataType = dataType;
	}
}
