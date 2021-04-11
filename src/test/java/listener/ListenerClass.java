package listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ExtentManager.extentManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import StepDefinitions.Hooks;


public class ListenerClass extends extentManager implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println("am in test start");
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Pass Test case is: " + result.getName());

	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

		String pathstring="";
		
		try {
			
			 pathstring = screenShot(Hooks.driver, result.getName());	
			 test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(pathstring));
			
		} 
		catch (IOException e) {
		
			e.printStackTrace();
		}
		
		


	}
	
	public  String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return destination;
	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, "Skipped Test case is: " + result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stubb
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("am in  start 1");//extentManager.setExtent();

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//extentManager.endReport();
	}

}
