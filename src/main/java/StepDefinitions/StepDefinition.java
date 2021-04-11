package StepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.ExtentManager.extentManager;
import com.aventstack.extentreports.Status;

import Driver.MedplusDriver;
import PageObjects.ICD;
import io.cucumber.java.en.*;




public class StepDefinition {



	 @Given("^user logged in and moved to manage$")
	    public void user_logged_in_and_moved_to_manage() throws Throwable {
		 extentManager.test.log(Status.INFO, "[Click the Manage button]");
			MedplusDriver.getICD().Manage.click();
			extentManager.test.log(Status.PASS, "[Clicked the Manage button]");
	       
	    }
	    

	    @Then("^clicked add$")
	    public void clicked_add() throws Throwable {
	    	extentManager.test.log(Status.INFO, "[Click the ICD Add button]");
			MedplusDriver.getICD().Add.click();
			extentManager.test.log(Status.PASS, "[Clicked the ICD Add button]");

			Thread.sleep(3000);

	    }

	    @Then("^Verified page header$")
	    public void verified_page_header() throws Throwable {
	    	extentManager.test.log(Status.INFO, "[Click the submit button]");
			String successMsg = Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(ICD.wait_successMsg())).getText();
			SoftAssert a = new SoftAssert();

			a.assertEquals(successMsg, "ICD Code added successfully");
			extentManager.test.log(Status.PASS, "[Submit button clicked]");
			a.assertAll();
	    }

	    @Then("^clicked submit$")
	    public void clicked_submit() throws Throwable {
	    	extentManager.test.log(Status.INFO, "[Click the submit button]");
			MedplusDriver.getICD().ICD_submit.click();
			extentManager.test.log(Status.PASS, "[Submit button clicked]");

	        
	    }

	    @And("^clicked ICD$")
	    public void clicked_icd() throws Throwable {
	    	extentManager.test.log(Status.INFO, "[Click the ICD button]");
			MedplusDriver.getICD().ICD.click();
			extentManager.test.log(Status.PASS, "[Clicked the ICD button]");
	    }

	    @And("^provided ICDname,ICD number,ICD type$")
	    public void provided_icdnameicd_numbericd_type() throws Throwable {
	    	Thread.sleep(3000);
	    	extentManager.test.log(Status.INFO, "[Send the icd number]");
			Hooks.wait.until(ExpectedConditions.presenceOfElementLocated(ICD.wait_ICDnum())).sendKeys("ICDnumbers");
			extentManager.test.log(Status.PASS, "[Sent the icd number]");

			Thread.sleep(3000);
			extentManager.test.log(Status.INFO, "[Choose the icd type]");
			MedplusDriver.getICD().ICD_codeType.click();
			Select icd_dropdown = new Select(MedplusDriver.getICD().ICD_codeType);
			icd_dropdown.selectByValue("ICD9");
			extentManager.test.log(Status.PASS, "[ICD Type is chosen]");

			extentManager.test.log(Status.INFO, "[Send the icd name]");
			MedplusDriver.getICD().ICD_codeName.sendKeys("ICDName");
			extentManager.test.log(Status.PASS, "[Sent the icd name]");

			Thread.sleep(3000);
	    }


	

}
