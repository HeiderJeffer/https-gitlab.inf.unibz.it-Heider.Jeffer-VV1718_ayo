package main;
import adapters.IAccount;
import types.AccountClass;
import types.AccountType;

public class Account implements IAccount {
	String code;
	AccountClass accountClass;
	AccountType accountType;
	boolean isPartnerAllowed;
	
	public Account(String code, String accountClass, String accountType, boolean isPartnerAllowed) {
		this.code = code;
		this.accountClass = new AccountClass (accountClass);
		this.accountType = new AccountType (accountType);
		this.isPartnerAllowed = isPartnerAllowed;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public AccountClass getAccountClass() {
		return this.accountClass;
	}	

	@Override
	public AccountType getAccountType() {
		return this.accountType;
	}

	@Override
	public boolean isPartnerAllowed() {
		return this.isPartnerAllowed;
	}

}
