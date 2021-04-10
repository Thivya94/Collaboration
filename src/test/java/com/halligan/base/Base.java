package com.halligan.base;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.halligan.Prerequiste.Prerequisteimplementation;
import com.halligan.getdata.Retrievedatafromresources;

public class Base extends Prerequisteimplementation {

	
	public void Initialize() {
		try {
			Retrievedatafromresources.Getdatafrompropertyfile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Lanuchreport();
		Launchbrowser(Retrievedatafromresources.browserType);
		//DB_connection();
	}

	
	public void Termination() {
		Quitbrowser();
		Quitreport();
	}

}
