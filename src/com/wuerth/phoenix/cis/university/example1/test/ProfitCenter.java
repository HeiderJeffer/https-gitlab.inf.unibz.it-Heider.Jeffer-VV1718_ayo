package com.wuerth.phoenix.cis.university.example1.test;

import com.wuerth.phoenix.cis.university.example1.adapters.IProfitCenter;

public class ProfitCenter implements IProfitCenter {
	
	private String name;
	private boolean isNotAllocated;

	public ProfitCenter(String name, boolean isNotAllocated) {
		this.name = name;
		this.isNotAllocated = isNotAllocated;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isNotAllocated() {
		return this.isNotAllocated;
	}

}
