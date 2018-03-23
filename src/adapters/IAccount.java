package adapters;

import types.AccountClass;
import types.AccountType;

public interface IAccount {

	public String getCode();
	
	public AccountClass getAccountClass();
	
	public AccountType getAccountType();

	public boolean isPartnerAllowed();
}
