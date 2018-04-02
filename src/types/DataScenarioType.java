package types;

public class DataScenarioType {

	String[] dataScenarioTypes = {
			"Actual",
			"Deferral",
			"Extrapolation",
			"Target",
			"Plan",
	};
	
	public String dataScenarioType;
	
	public DataScenarioType (String dataScenarioType) {
		this.dataScenarioType = dataScenarioType;
	}
}
