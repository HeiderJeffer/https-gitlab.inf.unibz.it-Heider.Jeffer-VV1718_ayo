package com.wuerth.phoenix.cis.university.example1.test;

import static org.junit.Assert.*;

import com.wuerth.phoenix.cis.university.example1.Example1Checker;

public class Test {

	@org.junit.Test
	public void test() {
		Example1Checker checker = new Example1Checker();
		
		boolean oracle = false;
		boolean result = checker.isValid(null, null, null, false, null, null, null, null);
		
		assertEquals(oracle, result);
	}

}
