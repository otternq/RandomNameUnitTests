package com.nickotter.randomname.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {

	public static Test suite() {
		
		TestSuite suite = new TestSuite(AllTests.class.getName());
		
		//test the MainActivity Activity
		suite.addTestSuite(MainActivityTest.class);
		
		//test the AddGroup Activity
		suite.addTestSuite(AddGroupTest.class);
		
		//test CRUD operations
		suite.addTest(new DatabaseCRUDTest("testAddGroup"));
		suite.addTest(new DatabaseCRUDTest("testQueryGroup"));
		suite.addTest(new DatabaseCRUDTest("testAddList"));
		suite.addTest(new DatabaseCRUDTest("testAddItem"));
		
		return suite;
	}

}
