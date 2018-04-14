package com.wuerth.phoenix.cis.university.example1.test;

import com.wuerth.phoenix.cis.university.example1.adapters.IAccount;
import com.wuerth.phoenix.cis.university.example1.types.AccountClass;
import com.wuerth.phoenix.cis.university.example1.types.AccountType;

public class Account implements IAccount {
	private String code;
	private AccountClass accountClass;
	private AccountType accountType;
	private boolean isPartnerAllowed;
	
	public Account(String code, String accountClass, String accountType, boolean isPartnerAllowed) {
		this.code = code;
		
		AccountClass[] ac = AccountClass.values();
		for(AccountClass a: ac) {
			if(a.toString().equals(accountClass))
				this.accountClass = a;
		}
		
		AccountType[] at = AccountType.values();
		for(AccountType a: at) {
			if(a.toString().equals(accountType))
				this.accountType = a;
		}
		
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
