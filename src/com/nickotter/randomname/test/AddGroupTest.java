package com.nickotter.randomname.test;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.Window;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.internal.ActionBarSherlockCompat;
import com.actionbarsherlock.internal.view.menu.ActionMenuItem;
import com.jayway.android.robotium.solo.Solo;
import com.nickotter.randomname.CRUD;
import com.nickotter.randomname.Group;
import com.nickotter.randomname.MainActivity;
import com.nickotter.randomname.Sqlite;
import com.nickotter.randomname.crudActivities.AddGroup;
import com.squareup.spoon.Spoon;

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
		
		//this.context.deleteDatabase(Sqlite.DATABASE_NAME);
		
		this.databaseCRUD = new CRUD(this.context);
		this.databaseCRUD.open();
	}
	
	public static void clickOnUpActionBarButton(Solo solo) {
	    if (Build.VERSION.SDK_INT < 15) {
	        Activity activity = solo.getCurrentActivity();

	        ActionMenuItem logoNavItem = new ActionMenuItem(activity, 0, android.R.id.home, 0, 0, "");
	        ActionBarSherlockCompat absc = (ActionBarSherlockCompat) UiTestUtils.invokePrivateMethodWithoutParameters(
	                SherlockFragmentActivity.class, "getSherlock", activity);
	        absc.onMenuItemSelected(Window.FEATURE_OPTIONS_PANEL, logoNavItem);
	    } else { // Working on latest sdk versions (above 4.0)
	        solo.clickOnView(solo.getView(android.R.id.home));
	    }
	}
	
	public void testAddGroupSave() {
		
//		Spoon.screenshot(getActivity(), "initialize");
//		
//		solo.assertCurrentActivity("The App should launch", MainActivity.class);
//		
//		solo.clickOnImage(0);
//		
//		solo.clickOnButton("Add Group");
//				
//		solo.clearEditText(0);
//		solo.enterText(0, "Unit Test Group Name");
//
//		solo.clickOnImage(3);
//		
//
//		solo.waitForActivity("MainActivity");
//		solo.assertCurrentActivity("The App should go back to the MainActivity", MainActivity.class);
//		
		//check that the group was added to the interface
//		List<Group> groupList = this.databaseCRUD.query_group();
//		
//		boolean found = false;
//		
//		Log.v("testAddGroup", "found this many groups:" + groupList.size());
//		
//		for (Group temp: groupList) {
//			Log.v("testAddGroup", "found group: " + temp.getName());
//			if (temp.getName().equals("Unit Test Group Name")) {
//				found = true;
//				Log.v("testAddGroup", "it has been found");
//			}
//		}
//		
//		assertTrue(found);
//		
//		Spoon.screenshot(getActivity(), "after");
	}

	
//	public void testAddGroupCancel() {
//		
//		solo.assertCurrentActivity("The App should launch", MainActivity.class);
//		solo.assertCurrentActivity("This test should start at the MainActivity Activity", MainActivity.class);
//		
//		//switch to the AddGroup Activity
//		solo.clickOnImage(1);
//		solo.clickOnButton("Add Group");
//		
//		solo.assertCurrentActivity("This test should have changed to the AddGroup Activity", AddGroup.class);
//		
//		//click the cancel button
//		solo.clickOnImage(2);
//		
//		solo.waitForActivity("MainActivity");
//		solo.assertCurrentActivity("The App should go back to the MainActivity", MainActivity.class);
//		
//		Spoon.screenshot(getActivity(), "initialize");
//		
//	}
//	
//	public void testAddGroupHome() {
//		
//		solo.assertCurrentActivity("The App should launch", MainActivity.class);
//		solo.assertCurrentActivity("This test should start at the MainActivity Activity", MainActivity.class);
//		
//		//switch to the AddGroup Activity
//		solo.clickOnImage(1);
//		solo.clickOnButton("Add Group");
//		
//		solo.assertCurrentActivity("This test should have changed to the AddGroup Activity", AddGroup.class);
//		
//		//click the home button
//		solo.clickOnImage(1);
//		
//		solo.waitForActivity("MainActivity");
//		solo.assertCurrentActivity("The App should go back to the MainActivity", MainActivity.class);
//		
//		Spoon.screenshot(getActivity(), "initialize");
//		
//	}
//
//
}