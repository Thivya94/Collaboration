package com.halligan.getdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Retrievedatafromresources {

	public static String browserType=null;
	public static String url=null;
	public static String password=null;
	public static String userName=null;
	 
	
	
	public static void Getdatafrompropertyfile() throws FileNotFoundException
	{
		
		Properties con = new Properties();
		File inputFile = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\halligan\\Configfile\\Config.properties");
		FileInputStream configFile = null;
		try {

			configFile = new FileInputStream(inputFile);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			con.load(configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		browserType = con.getProperty("browserType");
		url = con.getProperty("url");
		userName = con.getProperty("userName");
		password = con.getProperty("password");
		
	}
	
	

}
