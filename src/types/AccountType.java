package types;

public class AccountType {

	String[] accountTypes = {
			"BranchOffice",
			"SpecialAnalyses",
			"SpecialAnalysesNumOfInvoicingDays",
			"SpecialAnalysesServiceDegree",
			"VK",
			"SEAN",
			"Employees",
			"SML",
			"SMLGrossProfit",
			"SMLPotential",
			"Customer",

			"PrognosisSales",
			"PrognosisOperatingResult",
			"PrognosisNumOfAdmMPlus1",
			"PrognosisNumOfAdmMPlus2",
			"PrognosisNumOfAdmDecember",

			"AssetPartner"
	};
	
	public String accountType;
	
	public AccountType (String accountType) {
		this.accountType = accountType;
	}
}
