package com.nickotter.randomname.test;

import java.util.List;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.jayway.android.robotium.solo.Solo;
import com.nickotter.randomname.CRUD;
import com.nickotter.randomname.Group;
import com.nickotter.randomname.MainActivity;
import com.nickotter.randomname.Sqlite;
import com.nickotter.randomname.crudActivities.AddGroup;

public class AddGroupTest extends ActivityInstrumentationTestCase2<MainActivity> {
	
	private Solo solo;
	
	Context context= null;
	CRUD databaseCRUD = null;
	
	public AddGroupTest() {
		super(MainActivity.class);
	
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		
		this.context = this.getInstrumentation().getTargetContext().getApplicationContext();
		
		this.context.deleteDatabase(Sqlite.DATABASE_NAME);
		
		this.databaseCRUD = new CRUD(this.context);
		this.databaseCRUD.open();
	}
	
	public void testAddGroupSave() {
		
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
		solo.assertCurrentActivity("This test should start at the MainActivity Activity", MainActivity.class);
		
		//switch to the AddGroup Activity
		solo.clickOnImage(0);
		solo.clickOnButton("Add Group");
		
		solo.assertCurrentActivity("This test should have changed to the AddGroup Activity", AddGroup.class);
		
		solo.clearEditText(0);
		solo.enterText(0, "Unit Test Group Name");
		
		//click the save button
		solo.clickOnButton("Save");
		
		//switch to the MainActivity Activity
		solo.waitForActivity("MainActivity");
		solo.assertCurrentActivity("The App should go back to the MainActivity", MainActivity.class);
		
		List<Group> groupList = this.databaseCRUD.query_group();
		
		boolean found = false;
		
		Log.v("testAddGroup", "found this many groups:" + groupList.size());
		
		for (Group temp: groupList) {
			Log.v("testAddGroup", "found group: " + temp.getName());
			if (temp.getName().equals("Unit Test Group Name")) {
				found = true;
				Log.v("testAddGroup", "it has been found");
			}
		}
		
		assertTrue(found);
	}
	
	public void testAddGroupCancel() {
		
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
		solo.assertCurrentActivity("This test should start at the MainActivity Activity", MainActivity.class);
		
		//switch to the AddGroup Activity
		solo.clickOnImage(0);
		solo.clickOnButton("Add Group");
		
		solo.assertCurrentActivity("This test should have changed to the AddGroup Activity", AddGroup.class);
		
		//click the cancel button
		solo.clickOnButton("Cancel");
		
		solo.waitForActivity("MainActivity");
		solo.assertCurrentActivity("The App should go back to the MainActivity", MainActivity.class);
		
	}
	
	public void testAddGroupHome() {
		
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
		solo.assertCurrentActivity("This test should start at the MainActivity Activity", MainActivity.class);
		
		//switch to the AddGroup Activity
		solo.clickOnImage(0);
		solo.clickOnButton("Add Group");
		
		solo.assertCurrentActivity("This test should have changed to the AddGroup Activity", AddGroup.class);
		
		//click the home button
		solo.clickOnImage(0);
		
		solo.waitForActivity("MainActivity");
		solo.assertCurrentActivity("The App should go back to the MainActivity", MainActivity.class);
		
	}


}