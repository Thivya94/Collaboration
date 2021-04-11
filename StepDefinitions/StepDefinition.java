package StepDefinitions;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExtentManager.extentManager;
import com.aventstack.extentreports.Status;

import Driver.MedplusDriver;
import PageObjects.Login;
import io.cucumber.java.en.*;




public class StepDefinition {

	public Properties prop;
	public WebDriverWait wait;

	
	@Given("user is on login page")
	public void user_is_on_login_page() throws IOException {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\" + "src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
	//	extentManager.test.log(Status.PASS,"[Navigated to URL]"+" " +":"+ prop.getProperty("url"));
	    
	}
	@And("Provide userame and password")
	public void provide_userame_and_password() {
		
		//extentManager.test.log(Status.INFO,"[Pass the Username]");
		MedplusDriver.getLogin().userName.sendKeys("administrator");
		//extentManager.test.log(Status.PASS,"[UserName is Passed]");
		
	//	extentManager.test.log(Status.INFO,"[Pass the Password]");
		MedplusDriver.getLogin().Password.sendKeys("Wbcuser_1");
	//	extentManager.test.log(Status.PASS,"[Password is passed]");
	  
	}
	@Then("click signIn")
	public void click_sign_in() {
		//extentManager.test.log(Status.INFO,"[Click the signIn button]");
		wait.until(ExpectedConditions.presenceOfElementLocated(Login.wait_signIn())).click();
		//extentManager.test.log(Status.PASS,"[Clicked the signIn button]");
	}
	@Then("Verify page header")
	public void verify_page_header() {
		System.out.println("Verified");
	   
	}

}
