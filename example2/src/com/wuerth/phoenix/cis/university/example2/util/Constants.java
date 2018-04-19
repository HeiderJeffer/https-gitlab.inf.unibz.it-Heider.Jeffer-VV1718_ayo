package com.wuerth.phoenix.cis.university.example2.util;

public class Constants {
   
	public enum IFRS16ImportCompanyDataColumnSectionType {
		None,
		Contract,
		ContractData,
		Condition,
		ConditionData,
	}
	
	public enum IFRS16ImportCompanyDataErrorType {
		DifferentAttributeContract,
		DifferentAttributeContractData,
		DifferentAttributeCondition,
		DifferentAttributeConditionData,
		NoGroupPosition,
		ConditionTypeNotAvailable,
		Empty,
		ExceedingText,
		Unparsable,
		NotEditable,
		Historical,
	}

	public static final int MAX_LENGHT_CREDITORNUMBER 			= 20;
	public static final int MAX_LENGHT_CREDITORNAME 			= 100;
	public static final int MAX_LENGHT_CONTRACTNUMBER 			= 20;
	public static final int MAX_LENGHT_DESIGNATIONLEASEDOBJECT	= 250;
	public static final int MAX_LENGHT_COSTCENTER 				= 50;

	public static final int DECIMALS_INTERESTRATE 	= 2;
	public static final int DECIMALS_AMOUNT 		= 2;

	public static final char SEPARATOR = ',';

	public static final char SEPARATOR_COMMA 				= ',';
	public static final char SEPARATOR_POINT 				= '.';
	public static final char SEPARATOR_NOBREAKSPACE 		= (char)160;
	public static final char SEPARATOR_SINGLEQUOTATIONMARK	= '\'';
	public static final char SEPARATOR_SPACE 				= ' ';

	public static final String DATE_DE = "dd mm yy";
	public static final String DATE_EN = "mm dd yy";

	public static final String SETTTING_DATE_DE = "dd-MM-yyyy";
	public static final String SETTTING_DATE_EN = "MM-dd-yyyy";

	public static final String IFRS16_RIGHT_OF_USE_LAND_OFFICES        = "NDS_BS11320111";
    public static final String IFRS16_RIGHT_OF_USE_LAND_RESIDENTIALS   = "NDS_BS11320121";
    public static final String IFRS16_RIGHT_OF_USE_LAND_NO_BUILDINGS   = "NDS_BS11320131";
    public static final String IFRS16_RIGHT_OF_USE_BUILDINGS           = "NDS_BS11320141";
    public static final String IFRS16_RIGHT_OF_USE_TECHNICAL_EQUIPMENT = "NDS_BS11320201";
    public static final String IFRS16_RIGHT_OF_USE_EQUIPMENT           = "NDS_BS11320311";
    public static final String IFRS16_RIGHT_OF_USE_VEHICLE_FLEET       = "NDS_BS11320321";

    public static final String[] IFRS16_GROUP_POSITION_ACCOUNT_CODES = {
                IFRS16_RIGHT_OF_USE_LAND_OFFICES,
                IFRS16_RIGHT_OF_USE_LAND_RESIDENTIALS,
                IFRS16_RIGHT_OF_USE_LAND_NO_BUILDINGS,
                IFRS16_RIGHT_OF_USE_BUILDINGS,
                IFRS16_RIGHT_OF_USE_TECHNICAL_EQUIPMENT,
                IFRS16_RIGHT_OF_USE_EQUIPMENT,
                IFRS16_RIGHT_OF_USE_VEHICLE_FLEET
    };
    
    public static final String CONDITIONTYPE_CODE_RentI											= "IFRS16ConditionType.01";
    public static final String CONDITIONTYPE_CODE_GrantForRemodelingCosts						= "IFRS16ConditionType.02";
    public static final String CONDITIONTYPE_CODE_Utilities										= "IFRS16ConditionType.03";
    public static final String CONDITIONTYPE_CODE_Power											= "IFRS16ConditionType.04";
    public static final String CONDITIONTYPE_CODE_Water											= "IFRS16ConditionType.05";
    public static final String CONDITIONTYPE_CODE_Heating										= "IFRS16ConditionType.06";
    public static final String CONDITIONTYPE_CODE_PropertyTax									= "IFRS16ConditionType.07";
	public static final String CONDITIONTYPE_CODE_RentParkingArea								= "IFRS16ConditionType.08";
	public static final String CONDITIONTYPE_CODE_RentII										= "IFRS16ConditionType.09";
	public static final String CONDITIONTYPE_CODE_RentIII										= "IFRS16ConditionType.10";
	public static final String CONDITIONTYPE_CODE_RentTechnicalEquipmentAndMachines				= "IFRS16ConditionType.11";
	public static final String CONDITIONTYPE_CODE_RentFixturesFittingsAndOfficeEquipment		= "IFRS16ConditionType.12";
	public static final String CONDITIONTYPE_CODE_RentVehicleFleet								= "IFRS16ConditionType.13";
    public static final String CONDITIONTYPE_CODE_ServiceFeeTechnicalEquipmentAndMachines		= "IFRS16ConditionType.14";
    public static final String CONDITIONTYPE_CODE_ServiceFeeFixturesFittingsAndOfficeEquipment	= "IFRS16ConditionType.15";
	public static final String CONDITIONTYPE_CODE_ServiceFeeVehicleFleet						= "IFRS16ConditionType.16";

	public static final String[] CONDITIONTYPE_CODES = {
				CONDITIONTYPE_CODE_RentI,
				CONDITIONTYPE_CODE_GrantForRemodelingCosts,
				CONDITIONTYPE_CODE_Utilities,
				CONDITIONTYPE_CODE_Power,
				CONDITIONTYPE_CODE_Water,
				CONDITIONTYPE_CODE_Heating,
				CONDITIONTYPE_CODE_PropertyTax,
				CONDITIONTYPE_CODE_RentParkingArea,
				CONDITIONTYPE_CODE_RentII,
				CONDITIONTYPE_CODE_RentIII,
				CONDITIONTYPE_CODE_RentTechnicalEquipmentAndMachines,
				CONDITIONTYPE_CODE_RentFixturesFittingsAndOfficeEquipment,
				CONDITIONTYPE_CODE_RentVehicleFleet,
				CONDITIONTYPE_CODE_ServiceFeeTechnicalEquipmentAndMachines,
				CONDITIONTYPE_CODE_ServiceFeeFixturesFittingsAndOfficeEquipment,
				CONDITIONTYPE_CODE_ServiceFeeVehicleFleet,
	};
	
	public static final String KEYWORD_ERROR_COLUMNASSOCIATION_DUPLICATED 	= "IFRS16ImportCompanyDataWizard.Error.ColumnAssociation.Duplicated";
	public static final String KEYWORD_ERROR_COLUMNASSOCIATION_NO 			= "IFRS16ImportCompanyDataWizard.Error.ColumnAssociation.No";
}
