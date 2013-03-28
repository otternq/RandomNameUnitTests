package com.nickotter.randomname.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {

	public static Test suite() {
		
		TestSuite suite = new TestSuite(AllTests.class.getName());
		
		suite.addTest(new DatabaseCRUDTest("testAddGroup"));
		suite.addTest(new DatabaseCRUDTest("testQueryGroup"));
		suite.addTest(new DatabaseCRUDTest("testAddList"));
		
		suite.addTestSuite(MainActivityTest.class);
		
		return suite;
	}

}
