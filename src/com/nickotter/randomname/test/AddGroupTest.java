package com.nickotter.randomname.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.jayway.android.robotium.solo.Solo;
import com.nickotter.randomname.crudActivities.AddGroup;

public class AddGroupTest extends ActivityInstrumentationTestCase2<AddGroup> {
	
	private Solo solo;
	
	public AddGroupTest() {
		super(AddGroup.class);
	
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testAddGroup() {
		
		EditText groupName = (EditText) solo.getEditText("Enter Group Name");
		
		solo.clearEditText(groupName);
		
		groupName.setText("Unit Test Group Name");
		
		solo.clickOnButton("Cancel");
	}


}