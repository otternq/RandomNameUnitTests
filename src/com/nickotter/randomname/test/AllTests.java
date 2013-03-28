package com.nickotter.randomname.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(DatabaseCRUDTest.class);
		//$JUnit-END$
		return suite;
	}

}
