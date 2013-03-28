package com.nickotter.randomname.test;

import com.jayway.android.robotium.solo.Solo;
import com.nickotter.randomname.MainActivity;

import android.test.ActivityInstrumentationTestCase2;

public class MainTestCase extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;
	
	public MainTestCase() {
		super(MainActivity.class);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void test___(){
		
		solo.assertCurrentActivity("The App should lauch", MainActivity.class);
		
		solo.sendKey(Solo.MENU);
		
		solo.clickOnImage(0);
		
		solo.clickOnImage(0);
						
		solo.assertCurrentActivity("The App should lauch", MainActivity.class);
		
//		solo.clickOnMenuItem("LIST 2");
		
		solo.clickOnButton(2);
	
		solo.clickOnActionBarItem(1);
		solo.clickOnActionBarItem(2);
		solo.clickOnActionBarItem(3);
		solo.clickOnActionBarItem(4);
		solo.clickOnActionBarItem(5);
	}
	

}
