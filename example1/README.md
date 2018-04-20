# Software Reliability and Testing
# 1st Assignment - Reduce the number of combinations

## Test class
src/com/wuerth/phoenix/cis/university/example1/test/Test.java

## Dependency
JUnit4.

## Total combinations and reduction strategy
Total combinations is 84.

Steps to reduce the combinations were:
* Reduced redundant rows from Account.csv to 21 rows, omitted the getCode column since it was not be used at Example1Checker.java
* Reduced redundant rows from CRComponent.csv to 3 rows, omitted the getName column since it was not be used at Example1Checker.java
* Reduced redundant rows from ProfitCenter.csv to 2 rows, omitted the getName column since it was not be used at Example1Checker.java
* Merge Account.csv , CRComponent.csv , and ProfitCenter.csv (21 x 3 x 2 = 126 rows)
* Reduced 126 rows to 84 combinations, based on Example1.docx and Example1Combinations.docx

![Alt text](data/result.PNG)

### Combinations
```
pcName,isNotAllocated,crName,isNotAllocated,isVKAllowed,isSEANAllowed,external,dataScenarioType,accountCode,accountClass,accountType,isPartnerAllowed,partnerCode,currencyCode
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,TRUE,Plan,0,AllocationFormula,,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,TRUE,Plan,1,AllocationFormula,,FALSE,,
PCArt,FALSE,DIRECTSALES02,FALSE,TRUE,TRUE,TRUE,Plan,2,AllocationFormula,,FALSE,,
PC0,TRUE,DIRECTSALES01,FALSE,TRUE,TRUE,TRUE,Plan,3,AllocationFormula,,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Plan,4,AllocationFormula,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Plan,5,AllocationFormula,,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Plan,6,AllocationFormula,,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Plan,7,AllocationFormula,,FALSE,,
PCArt,FALSE,DIRECTSALES02,FALSE,TRUE,TRUE,FALSE,Plan,8,AllocationFormula,,FALSE,,
PC0,TRUE,DIRECTSALES01,FALSE,TRUE,TRUE,FALSE,Plan,9,AllocationFormula,,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Plan,10,AllocationFormula,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Plan,11,AllocationFormula,,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,TRUE,Target,12,AllocationFormula,,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,TRUE,Target,13,AllocationFormula,,FALSE,,
PCArt,FALSE,DIRECTSALES02,FALSE,TRUE,TRUE,TRUE,Target,14,AllocationFormula,,FALSE,,
PC0,TRUE,DIRECTSALES01,FALSE,TRUE,TRUE,TRUE,Target,15,AllocationFormula,,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Target,16,AllocationFormula,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Target,17,AllocationFormula,,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Target,18,AllocationFormula,,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Target,19,AllocationFormula,,FALSE,,
PCArt,FALSE,DIRECTSALES02,FALSE,TRUE,TRUE,FALSE,Target,20,AllocationFormula,,FALSE,,
PC0,TRUE,DIRECTSALES01,FALSE,TRUE,TRUE,FALSE,Target,21,AllocationFormula,,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Target,22,AllocationFormula,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Target,23,AllocationFormula,,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,TRUE,Actual,24,AllocationFormula,,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,TRUE,Actual,25,AllocationFormula,,FALSE,,
PCArt,FALSE,DIRECTSALES02,FALSE,TRUE,TRUE,TRUE,Actual,26,AllocationFormula,,FALSE,,
PC0,TRUE,DIRECTSALES01,FALSE,TRUE,TRUE,TRUE,Actual,27,AllocationFormula,,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,28,AllocationFormula,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,29,AllocationFormula,,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,30,AllocationFormula,,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,31,AllocationFormula,,FALSE,,
PCArt,FALSE,DIRECTSALES02,FALSE,TRUE,TRUE,FALSE,Actual,32,AllocationFormula,,FALSE,,
PC0,TRUE,DIRECTSALES01,FALSE,TRUE,TRUE,FALSE,Actual,33,AllocationFormula,,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,34,AllocationFormula,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,35,AllocationFormula,,FALSE,,
PC0,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,36,BalanceSheet,AssetPartner,TRUE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,37,BalanceSheet,AssetPartner,TRUE,,
PC0,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,38,BalanceSheet,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,39,BalanceSheet,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,40,Logistics,,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,41,PLStatement,PrognosisNumOfAdmDecember,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,42,PLStatement,PrognosisNumOfAdmMPlus1,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,43,PLStatement,PrognosisNumOfAdmMPlus2,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,44,PLStatement,PrognosisOperatingResult,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,45,PLStatement,PrognosisSales,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,46,SalesReporting,Customer,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,47,SalesReporting,Customer,FALSE,,
PCArt,FALSE,DIRECTSALES09,FALSE,TRUE,TRUE,FALSE,Actual,48,SalesReporting,Customer,FALSE,,
PC0,TRUE,DIRECTSALES03,FALSE,TRUE,TRUE,FALSE,Actual,49,SalesReporting,Customer,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,50,SalesReporting,Employees,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,51,SalesReporting,Employees,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,52,SalesReporting,SEAN,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,53,SalesReporting,SEAN,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,54,SalesReporting,SML,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,55,SalesReporting,SML,FALSE,,
PCArt,FALSE,DIRECTSALES10,FALSE,TRUE,TRUE,FALSE,Actual,56,SalesReporting,SML,FALSE,,
PC0,TRUE,DIRECTSALES04,FALSE,TRUE,TRUE,FALSE,Actual,57,SalesReporting,SML,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,58,SalesReporting,SMLGrossProfit,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,59,SalesReporting,SMLGrossProfit,FALSE,,
PCArt,FALSE,DIRECTSALES11,FALSE,TRUE,TRUE,FALSE,Actual,60,SalesReporting,SMLGrossProfit,FALSE,,
PC0,TRUE,DIRECTSALES05,FALSE,TRUE,TRUE,FALSE,Actual,61,SalesReporting,SMLGrossProfit,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,62,SalesReporting,SMLGrossProfit,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,63,SalesReporting,SMLGrossProfit,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,64,SalesReporting,SMLPotential,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,65,SalesReporting,SMLPotential,FALSE,,
PCArt,FALSE,DIRECTSALES12,FALSE,TRUE,TRUE,FALSE,Actual,66,SalesReporting,SMLPotential,FALSE,,
PC0,TRUE,DIRECTSALES06,FALSE,TRUE,TRUE,FALSE,Actual,67,SalesReporting,SMLPotential,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,68,SalesReporting,SMLPotential,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,69,SalesReporting,SMLPotential,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,70,SalesReporting,SpecialAnalyses,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,71,SalesReporting,SpecialAnalysesNumOfInvoicingDays,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,72,SalesReporting,SpecialAnalysesNumOfInvoicingDays,FALSE,,
PCArt,FALSE,DIRECTSALES13,FALSE,TRUE,TRUE,FALSE,Actual,73,SalesReporting,SpecialAnalysesNumOfInvoicingDays,FALSE,,
PC0,TRUE,DIRECTSALES07,FALSE,TRUE,TRUE,FALSE,Actual,74,SalesReporting,SpecialAnalysesNumOfInvoicingDays,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,75,SalesReporting,SpecialAnalysesNumOfInvoicingDays,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,76,SalesReporting,SpecialAnalysesNumOfInvoicingDays,FALSE,,
PCArt,FALSE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,77,SalesReporting,SpecialAnalysesServiceDegree,FALSE,,
PC0,TRUE,ADMINISTRATIONFINANCIAL,FALSE,FALSE,FALSE,FALSE,Actual,78,SalesReporting,SpecialAnalysesServiceDegree,FALSE,,
PCArt,FALSE,DIRECTSALES14,FALSE,TRUE,TRUE,FALSE,Actual,79,SalesReporting,SpecialAnalysesServiceDegree,FALSE,,
PC0,TRUE,DIRECTSALES08,FALSE,TRUE,TRUE,FALSE,Actual,80,SalesReporting,SpecialAnalysesServiceDegree,FALSE,,
PCArt,FALSE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,81,SalesReporting,SpecialAnalysesServiceDegree,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,FALSE,Actual,82,SalesReporting,SpecialAnalysesServiceDegree,FALSE,,
PC0,TRUE,AREANOALLOCATION,TRUE,TRUE,TRUE,TRUE,Actual,83,SalesReporting,VK,FALSE,,
```

## New CSV file
data\combinations.csv