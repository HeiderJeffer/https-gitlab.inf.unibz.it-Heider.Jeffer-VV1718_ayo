package com.wuerth.phoenix.cis.university.example1.test;

import com.wuerth.phoenix.cis.university.example1.adapters.ICRComponent;

public class CRComponent implements ICRComponent {

	private String name;
	private boolean isNotAllocated;
	private boolean isVKAllowed;
	private boolean isSEANAllowed;

	public CRComponent(String name, boolean isNotAllocated, boolean isVKAllowed, boolean isSEANAllowed) {
		this.name = name;
		this.isNotAllocated = isNotAllocated;
		this.isVKAllowed = isVKAllowed;
		this.isSEANAllowed = isSEANAllowed;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isNotAllocated() {
		return this.isNotAllocated;
	}

	@Override
	public boolean isVKAllowed() {
		return this.isVKAllowed;
	}

	@Override
	public boolean isSEANAllowed() {
		return this.isSEANAllowed;
	}

}
