package com.nickotter.randomname.test;

import com.nickotter.randomname.CRUD;
import com.nickotter.randomname.Sqlite;

import android.content.ContentProvider;
import android.content.Context;
import android.test.ProviderTestCase2;
import android.util.Log;

public class DatabaseCRUDTest extends ProviderTestCase2<ContentProvider> {
	
	private String LOGTAG = "DatabaseCRUDTest";
	
	Context context = null;
	CRUD databaseCRUD = null;

	public DatabaseCRUDTest()
    {
        this(DatabaseCRUDTest.class, "my_authority_from_manifest");
    }
	
	public DatabaseCRUDTest(Class<ContentProvider> providerClass, String providerAuthority) {
		super(providerClass, providerAuthority);
		// TODO Auto-generated constructor stub
		
		this.context = getMockContext();
	}
	
	public void test_InitializingCRUD() {
		Log.v(LOGTAG, "test_InitializingCRUD e");

		Log.v(LOGTAG, "Initializing CRUD object");
		this.databaseCRUD = new CRUD(this.context);
		
		Log.v(LOGTAG, "test_InitializingCRUD x");
	}

}
