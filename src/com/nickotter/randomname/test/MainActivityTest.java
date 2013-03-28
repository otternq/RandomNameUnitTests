package com.nickotter.randomname.test;

import com.jayway.android.robotium.solo.Solo;
import com.nickotter.randomname.MainActivity;

import android.test.ActivityInstrumentationTestCase2;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	public MainActivityTest() {
		super(MainActivity.class);

	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	/*public void testOpenSideDrawer() {
		
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
		
		solo.clickOnActionBarHomeButton();
		
	}*/
	
	public void testChangeActionBarTab() {
		
		solo.assertCurrentActivity("The App should launch", MainActivity.class);
		
		solo.clickOnActionBarItem(1);
		
		
		
		solo.clickOnActionBarItem(2);
		
	}

	/*public void test___(){

		solo.assertCurrentActivity("The App should lauch", MainActivity.class);

		solo.sendKey(Solo.MENU);

		solo.clickOnImage(0);

	T	solo.clickOnImage(0);

		solo.assertCurrentActivity("The App should lauch", MainActivity.class);

//		solo.clickOnMenuItem("LIST 2");

		solo.clickOnButton(2);

		solo.clickOnActionBarItem(1);
		solo.clickOnActionBarItem(2);
		solo.clickOnActionBarItem(3);
		solo.clickOnActionBarItem(4);
		solo.clickOnActionBarItem(5);
	}*/


}