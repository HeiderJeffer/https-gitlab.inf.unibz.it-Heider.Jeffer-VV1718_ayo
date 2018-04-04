package main;

import adapters.IProfitCenter;

public class ProfitCenter implements IProfitCenter {

	String name;
	boolean isNotAllocated;
	
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
