package com.nickotter.randomname.test;

import java.util.List;

import com.nickotter.randomname.CRUD;
import com.nickotter.randomname.Group;
import com.nickotter.randomname.Item;
import com.nickotter.randomname.MyList;
import com.nickotter.randomname.Sqlite;
import android.content.Context;

import android.test.AndroidTestCase;
import android.util.Log;

public class DatabaseCRUDTest extends AndroidTestCase {
	
	private String LOGTAG = "DatabaseCRUDTest";
	
	Context context = null;
	CRUD databaseCRUD = null;
	
	public DatabaseCRUDTest(String name) {
		this.setName(name);
	}

	public void setUp() {
		Log.v(LOGTAG, "setUp e");
		
		Log.v(LOGTAG, "Deleting DATABASE_NAME="+ Sqlite.DATABASE_NAME);
		getContext().deleteDatabase(Sqlite.DATABASE_NAME);

		Log.v(LOGTAG, "Initializing CRUD object");
		
		this.databaseCRUD = new CRUD(getContext());
		this.databaseCRUD.open();
		
		Log.v(LOGTAG, "setUp x");
	}
	
	public void tearDown() {
		this.databaseCRUD.close();
	}
	
	//GROUP TESTS
	
	/**
	 * Tests that databaseCRUd can insert a Group
	 */
	public void testAddGroup() {
		
		Group temp = new Group("CS480");
		this.databaseCRUD.add_group(temp);
		
		assertEquals(1, temp.getID());
	}
	
	/**
	 * Tests that databaseCRUD can find Groups
	 */
	public void testQueryGroup() {
		List<Group> groupList = this.databaseCRUD.query_group();
		
		String[] expectedName = {"CS480"};
		int[] expectedID = {1};
		
		for (int i = 0; i < groupList.size(); i++) {
			assertEquals(expectedID[i], groupList.get(i).getID()); //tests that it has the expected id
			assertEquals(expectedName[i], groupList.get(i).getName()); //tests that it has the expected name
		}
	}
	
	//List Test
	
	public void testAddList() {
		
		Group tempGroup = new Group("CS480");
		
		this.databaseCRUD.add_group(tempGroup);
		
		MyList temp = new MyList(0, tempGroup.getID(), "Test List Name");
		MyList temp2 = new MyList(0, tempGroup.getID(), "Test List Name 2");
		
		databaseCRUD.add_list(tempGroup, temp); //add the list to the database
		databaseCRUD.add_list(tempGroup, temp2);
		
		assertEquals(1, temp.getID());
		assertEquals(2, temp2.getID());
	}
	
	public void testQueryList() {
		
		String[] expectedName = {"Test List Name", "Test List Name 2"};
		int[] expectedID = {1,2};
		int[] expectedGroupID = {1,1};
		
		Group tempGroup = new Group("CS428");
		
		this.databaseCRUD.add_group(tempGroup);
		
		assertEquals(expectedGroupID[0], tempGroup.getID());
		
		MyList temp = new MyList(0, tempGroup.getID(), expectedName[0]);
		MyList temp2 = new MyList(0, tempGroup.getID(), expectedName[1]);
		
		databaseCRUD.add_list(tempGroup, temp); //add the list to the database
		databaseCRUD.add_list(tempGroup, temp2); //add the list to the database
		
		List<MyList> tempList = databaseCRUD.query_list(tempGroup);
		
		for (int i = 0; i < tempList.size(); i++) {
			assertEquals(expectedID[i], tempList.get(i).getID());
			assertEquals(expectedName[i], tempList.get(i).getName());
		}
		
	}
	
	//Item Test
	
	public void testAddItem() {
		
		String[] expectedGroup = {"CS428"};
		String[] expectedList = {"Test List Name"};
		String[] expectedItem = {"Test Item Name", "Test List Name 2"};
		
		int[] expectedListID = {1};
		int[] expectedGroupID = {1};
		int[] expectedItemID = {1,2};
		//add a group
		Group tempGroup = new Group(expectedGroup[0]);
		
		this.databaseCRUD.add_group(tempGroup);
		
		assertEquals(expectedGroupID[0], tempGroup.getID());
		
		//add a list
		MyList tempList = new MyList(0, tempGroup.getID(), expectedList[0]);
		
		databaseCRUD.add_list(tempGroup, tempList); //add the list to the database
		
		assertEquals(expectedListID[0], tempList.getID());
		
		//add an item
		Item[] tempItem = {
			new Item(0, tempList.getID(), expectedItem[0]), 
			new Item(0, tempList.getID(), expectedItem[1])
		};
		
		this.databaseCRUD.add_item(tempList, tempItem[0]);
		this.databaseCRUD.add_item(tempList, tempItem[1]);
		
		assertEquals(expectedItemID[0], tempItem[0].getID());
		assertEquals(expectedItemID[1], tempItem[1].getID());
		
		
	}
	
	public void testQueryItem() {
		
		Log.v(LOGTAG, "\tcreating groups start");
		Group g1 = new Group("CS480");
		Group g2 = new Group("CS481");
		Log.v(LOGTAG, "\tcreating groups end");
		
		MyList l1 = new MyList(0, g1.getID(), "List 1");
		MyList l2 = new MyList(0, g1.getID(), "List 2");
		MyList l3 = new MyList(0, g2.getID(), "List 3");
		
		Log.v(LOGTAG, "Adding Groups");
		databaseCRUD.add_group(g1);
		Log.v(LOGTAG, "Group 1 now has id="+ g1.getID());
		
		databaseCRUD.add_group(g2);
		Log.v(LOGTAG, "Group 2 now has id="+ g2.getID());
		
		Log.v(LOGTAG, "Adding Lists");
		databaseCRUD.add_list(g1, l1);
		databaseCRUD.add_list(g1, l2);
		databaseCRUD.add_list(g2, l3);
		
		Log.v(LOGTAG, "Adding Items");
		Item i1 = new Item(0, l1.getID(), "List 1 - Item 1");
		Item i2 = new Item(0, l1.getID(), "List 1 - Item 2");
		Item i3 = new Item(0, l2.getID(), "List 2 - Item 3");
		Item i4 = new Item(0, l2.getID(), "List 2 - Item 4");
		Item i5 = new Item(0, l3.getID(), "List 3 - Item 5");
		
		databaseCRUD.add_item(l1, i1);
		databaseCRUD.add_item(l1, i2);
		databaseCRUD.add_item(l2, i3);
		databaseCRUD.add_item(l2, i4);
		databaseCRUD.add_item(l3, i5);
		
		//check list 1
		List<Item> retItems = databaseCRUD.query_item(l1);
		assertEquals("List 1 - Item 1", retItems.get(0).getName());
		assertEquals("List 1 - Item 2", retItems.get(1).getName());
		
		//check list 2
		retItems = databaseCRUD.query_item(l2);
		assertEquals("List 2 - Item 3", retItems.get(0).getName());
		assertEquals("List 2 - Item 4", retItems.get(1).getName());
		
		//check list 3
		retItems = databaseCRUD.query_item(l3);
		assertEquals("List 3 - Item 5", retItems.get(0).getName());
		
		
		
	}

}
