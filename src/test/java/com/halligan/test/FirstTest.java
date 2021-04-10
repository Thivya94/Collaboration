package com.halligan.test;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.halligan.Prerequiste.Prerequisteimplementation;
import com.halligan.getdata.Retrievedatafromresources;
import com.halligan.halligandriver.halligandriver;
import com.halligan.pages.Loginpage;

public class FirstTest extends Prerequisteimplementation {
	
	
	@BeforeMethod
	@Parameters("First")
	public void Initialize(String browserName) {
		try {
			Retrievedatafromresources.Getdatafrompropertyfile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Lanuchreport();
		Launchbrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(Retrievedatafromresources.url);
		//DB_connection();
	}
	
	@Test
	public void chrome ()
	{
		halligandriver.Sendkeys(Loginpage.userName, Retrievedatafromresources.userName);
		halligandriver.Click(Loginpage.Continue);
		halligandriver.Sendkeys(Loginpage.password, Retrievedatafromresources.password);
		halligandriver.Click(Loginpage.signIn);
	}
	
	@AfterMethod
	public void Terminate()
	{
		report.flush();
		driver.quit();
	}
	
	

}
