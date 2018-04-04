package main;
import adapters.IAccount;
import adapters.ICRComponent;
import adapters.ICompany;
import adapters.IProfitCenter;
import types.DataScenarioType;

public class Example1Checker {
	/**
	 * Check if the parameters of a data are valid
	 * @param company the Company
	 * @param profitCenter the Profit Center
	 * @param crComponent the C/R Component
	 * @param external true (external) false (internal)
	 * @param scenarioType the type of the Scenario
	 * @param account the Account
	 * @param partnerCode the code of the partner or null
	 * @param currencyCode the code of the currency or null
	 * @return true (valid) false (not valid)
	 */
	public boolean isValid(
			ICompany company, IProfitCenter profitCenter, ICRComponent crComponent, boolean external,
			DataScenarioType scenarioType, IAccount account, String partnerCode, String currencyCode) {
		
		// No Company
		if(company == null) {
			return false;
		}
		
		// No Profit Center
		if(profitCenter == null) {
			return false;
		}
		
		// No C/R Component
		if(crComponent == null) {
			return false;
		}
		
		// No Scenario
		if(scenarioType == null) {
			return false;
		}
		
		// No Account
		if(account == null) {
			return false;
		}
		
		
		boolean hasPartnerCode = !isEmpty(partnerCode);
		
		boolean hasCurrencyCode = !isEmpty(currencyCode);
		
		switch(account.getAccountClass().accountClass) {
		
		case "SalesReporting":

			// Profit Center
			switch(account.getAccountType().accountType) {
			case "BranchOffice":
			case "SpecialAnalyses":
			case "VK":
				if(!profitCenter.isNotAllocated()) {
					return false;
				}
				break;
			}
			
			// C/R Component
			switch(account.getAccountType().accountType) {
			case "VK":
				if(!crComponent.isVKAllowed() || !crComponent.isNotAllocated()) {
					return false;
				}
				break;
			case "SEAN":
				if(!crComponent.isSEANAllowed() || !crComponent.isNotAllocated()) {
					return false;
				}
				break;
			case "BranchOffice":
			case "SpecialAnalyses":
			case "Employees":
				if(!crComponent.isNotAllocated()) {
					return false;
				}
				break;
			case "SML":
			case "Customer":
				if(crComponent.isNotAllocated()) {
					return false;
				}
				break;
			}
			
			// Internal/External
			switch(account.getAccountType().accountType) {
			case "BranchOffice":
			case "SpecialAnalyses":
			case "VK":
				if(!external) {
					return false;
				}
				break;
			}
			
			// Scenario
			switch(scenarioType.dataScenarioType) {
			case "Deferral":
				switch(account.getAccountType().accountType) {
				case "BranchOffice":
					break;
				default:
					return false;
				}
			case "Extrapolation":
			case "Target":
			case "Plan":
				switch(account.getAccountType().accountType) {
				case "SEAN":
				case "SpecialAnalyses":
				case "SMLGrossProfit":
				case "SMLPotential":
					return false;
				}
				break;
			}

			// Partner
			if(hasPartnerCode) {
				return false;
			}
			
			// Currency
			if(hasCurrencyCode) {
				return false;
			}
			break;
			
		case "PLStatement":

			switch(account.getAccountType().accountType) {
			case "PrognosisSales":
			case "PrognosisOperatingResult":
			case "PrognosisNumOfAdmMPlus1":
			case "PrognosisNumOfAdmMPlus2":
			case "PrognosisNumOfAdmDecember":

				// Profit Center
				if(!profitCenter.isNotAllocated()) {
					return false;
				}
				
				// C/R Component
				if(!crComponent.isNotAllocated()) {
					return false;
				}

				// Internal/External
				switch(account.getAccountType().accountType) {
				case "PrognosisOperatingResult":
				case "PrognosisNumOfAdmMPlus1":
				case "PrognosisNumOfAdmMPlus2":
				case "PrognosisNumOfAdmDecember":
					if(!external) {
						return false;
					}
					break;
				}

				// Scenario
				switch(scenarioType.dataScenarioType) {
				case "Actual":
					break;
				default:
					return false;
				}

				// Partner
				if(hasPartnerCode) {
					return false;
				}
				
				// Currency
				if(hasCurrencyCode) {
					return false;
				}
				break;
				
			default:
				
				if(hasPartnerCode) {

					// Profit Center
					if(!profitCenter.isNotAllocated()) {
						return false;
					}
					
					// C/R Component
					if(!crComponent.isNotAllocated()) {
						return false;
					}

					// Internal/External
					if(!external) {
						return false;
					}
					
					// Scenario
					switch(scenarioType.dataScenarioType) {
					case "Actual":
						break;
					default:
						return false;
					}

					// Account
					if(!account.isPartnerAllowed()) {
						return false;
					}
					
					// Currency
					if(!hasCurrencyCode) {
						return false;
					}
				}
				
				else {

					// Currency
					if(hasCurrencyCode) {
						return false;
					}
				}
				break;
			}
			break;
			
		case "AllocationFormula":

			// Scenario
			switch(scenarioType.dataScenarioType) {
			case "Deferral":
			case "Extrapolation":
				return false;
			}
			
			// Partner
			if(hasPartnerCode) {
				return false;
			}
			
			// Currency
			if(hasCurrencyCode) {
				return false;
			}
			break;
			
		case "BalanceSheet":

			// Profit Center
			if(hasPartnerCode) {
				switch(account.getAccountType().accountType) {
				case "AssetPartner":
					break;
				default:
					if(!profitCenter.isNotAllocated()) {
						return false;
					}
					break;
				}
			}
			
			// C/R Component
			if(!crComponent.isNotAllocated()) {
				return false;
			}

			// Internal/External
			if(!external) {
				return false;
			}

			// Scenario
			switch(scenarioType.dataScenarioType) {
			case "Deferral":
				if(hasPartnerCode) {
					switch(account.getAccountType().accountType) {
					case "AssetPartner":
						break;
					default:
						return false;
					}
				}
				break;
			}
			
			// Currency
			if(hasPartnerCode) {
				switch(account.getAccountType().accountType) {
				case "AssetPartner":
					break;
				default:
					if(!hasCurrencyCode) {
						return false;
					}
					break;
				}
			}
			else {
				if(hasCurrencyCode) {
					return false;
				}
			}
			break;
			
		case "Logistics":
			
			// Profit Center
			if(!profitCenter.isNotAllocated()) {
				return false;
			}
			
			// C/R Component
			if(!crComponent.isNotAllocated()) {
				return false;
			}
			
			// Internal/External
			if(!external) {
				return false;
			}
			
			// Scenario
			switch(scenarioType.dataScenarioType) {
			case "Actual":
				break;
			default:
				return false;
			}
			
			// Partner
			if(hasPartnerCode) {
				return false;
			}
			
			// Currency
			if(hasCurrencyCode) {
				return false;
			}
			break;
		}

		return true;
	}

	
	/**
	 * Check if a code is empty
	 * @param code the code
	 * @return true (empty) false (not empty)
	 */
	private boolean isEmpty(String code) {
		return code == null || code.trim().length() == 0;
	}
}