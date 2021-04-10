package com.halligan.testlistener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.halligan.Prerequiste.Prerequisteimplementation;

public class Listener extends Prerequisteimplementation implements  ITestListener   {

	@Override
	public void onTestStart(ITestResult result) {
		
		halliganAudit = report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		halliganAudit.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		halliganAudit.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		halliganAudit.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		String screenshotPath = null;
		try {
			screenshotPath = Prerequisteimplementation.TakeScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		halliganAudit.fail("Test Case Failed Snapshot is below " + halliganAudit.addScreenCaptureFromPath(screenshotPath));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		halliganAudit.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
	
	}
	
	

}
