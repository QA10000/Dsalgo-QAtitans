package com.qa.dsalgo.myhooks;

import io.cucumber.java.Before;

import com.qa.dsalgo.base.DriverScripts;

import io.cucumber.java.After;

public class Dsalgohooks extends DriverScripts {
	@Before
	
	public void setup() {
		System.out.println("This is good");
	}
	
	@After
	
	public void tearDown(){

	//	closeCurrentWindow();		

		System.out.println("This is good");

		closeCurrentWindow();		

	}

}

