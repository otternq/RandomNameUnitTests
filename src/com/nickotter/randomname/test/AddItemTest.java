package com.nickotter.randomname.test;

import java.util.List;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.ImageButton;

import com.jayway.android.robotium.solo.Solo;
import com.nickotter.randomname.CRUD;
import com.nickotter.randomname.Group;
import com.nickotter.randomname.MainActivity;
import com.nickotter.randomname.Sqlite;
import com.nickotter.randomname.crudActivities.AddGroup;
import com.nickotter.randomname.crudActivities.AddList;
import com.squareup.spoon.Spoon;


public class AddItemTest extends ActivityInstrumentationTestCase2<MainActivity> {
private Solo solo;
	
	Context context= null;
	CRUD databaseCRUD = null;
	
	public AddItemTest() {
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
	
	public void testAddItemSave(){
		
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
		
		solo.clickOnImageButton(1);
				
		solo.clickOnButton("Add Item");
				
		solo.clearEditText(0);
				
		solo.enterText(0, "A new item added");
				
		solo.clickOnImage(3);
				
	}
	
	public void testAddItemCancel(){
				
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
				
		solo.clickOnImageButton(1);
				
		solo.clickOnButton("Add Item");
				
		solo.clearEditText(0);
				
		solo.enterText(0, "A new item added");
				
		solo.clickOnImage(2);
				
	}
	
	public void testRemoveItem(){
				
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
				
		solo.clickLongOnText("List 1 - Item 1");
				
		solo.clickOnButton("Delete Item");
		
	}
	
	public void testEditItem(){
		
		
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
				
		solo.clickLongOnText("List 1 - Item 2");
				
		solo.clickOnButton("Edit Item");
				
		solo.clearEditText(0);
				
		solo.enterText(0, "Edited Item");
				
		solo.clickOnImage(3);
				
		solo.clickOnButton("Save");
		
	}
}
