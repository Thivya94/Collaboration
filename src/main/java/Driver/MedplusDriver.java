package Driver;


import PageObjects.ICD;
import PageObjects.Login;



public class MedplusDriver {
	
	public static Login getLogin()
	{
		return new Login();
	}
	
	public static ICD getICD()
	{
		return new ICD();
	}
	

}
