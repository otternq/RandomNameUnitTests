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
	}

}