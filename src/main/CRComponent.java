package main;

import adapters.ICRComponent;

public class CRComponent implements ICRComponent {

	String name;
	boolean isNotAllocated;
	boolean isVKAllowed;
	boolean isSEANAllowed;
	
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
