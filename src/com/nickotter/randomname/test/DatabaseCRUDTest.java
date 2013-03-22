package com.nickotter.randomname.test;

import junit.framework.TestCase;

import com.nickotter.randomname.CRUD;
import com.nickotter.randomname.Group;
import com.nickotter.randomname.Sqlite;

import android.content.ContentProvider;
import android.content.Context;

import android.test.AndroidTestCase;
import android.test.mock.MockContext;
import android.util.Log;

public class DatabaseCRUDTest extends AndroidTestCase {
	
	private String LOGTAG = "DatabaseCRUDTest";
	
	Context context = null;
	CRUD databaseCRUD = null;
	
	public void setUp() {
		Log.v(LOGTAG, "test_InitializingCRUD e");

		Log.v(LOGTAG, "Initializing CRUD object");
		
		this.databaseCRUD = new CRUD(getContext());
		this.databaseCRUD.open();
		
		Log.v(LOGTAG, "test_InitializingCRUD x");
	}
	
	public void tearDown() {
		this.databaseCRUD.close();
	}
	
	public void testAddGroup() {
		Group temp = new Group("CS480");
		this.databaseCRUD.add_group(temp);
		
		assertEquals(1, temp.getID());
	}

}
