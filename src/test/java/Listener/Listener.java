package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.Testbase;

public class Listener extends Testbase implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		System.out.println("Listener");
		halliganAudit = report.createTest(result.getName());


	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		halliganAudit.log(Status.PASS,
				MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Listener-fail");
		halliganAudit.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		halliganAudit.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		halliganAudit.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
