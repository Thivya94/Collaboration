package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Getcredential {

	public static String environment;
	public static String browser_Type;
	public static String s_userNameCSON;
	public static String s_passwordCSON;
	public static String s_userNameCSOFF;
	public static String s_passwordCSOFF;
	public static String d_userNameCSON;
	public static String d_passwordCSON;
	public static String d_userNameCSOFF;
	public static String d_passwordCSOFF;
	public static String d_url;
	public static String s_url;

	public static void Credential() throws IOException{

		Properties prop = new Properties();

		File inputFile = new File("D:\\Scripts\\Eclipse\\Cucumber\\orangehrm\\src\\main\\java\\config\\config.properties");
		
		

		FileInputStream configFile = null;
		try {

			configFile = new FileInputStream(inputFile);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		try {
			prop.load(configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		environment = prop.getProperty("env");
		browser_Type = prop.getProperty("browserType");
		s_userNameCSON = prop.getProperty("s_userName-CSON");
		s_url = prop.getProperty("s_url");
		d_url = prop.getProperty("d_url");
		s_passwordCSON = prop.getProperty("s_password-CSON");
		s_userNameCSOFF = prop.getProperty("s_userName-CSOFF");
		s_passwordCSOFF = prop.getProperty("s_password-CSOFF");
		d_userNameCSON = prop.getProperty("d_userName-CSON");
		d_passwordCSON = prop.getProperty("d_password-CSON");
		d_userNameCSOFF = prop.getProperty("d_userName-CSOFF");
		d_passwordCSOFF = prop.getProperty("d_password-CSOFF");
		
		
		System.out.print("new browsertyop" + browser_Type);

	}

}
