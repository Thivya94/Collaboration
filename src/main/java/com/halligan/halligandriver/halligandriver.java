package com.halligan.halligandriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.halligan.Prerequiste.Prerequisteimplementation;

public class halligandriver extends Prerequisteimplementation {
	

	public static void Sendkeys(By element, String value) {
		try {
			halliganAudit.log(Status.INFO, "[Enter the Test Data] - value is : " + "\"" + value + "\"");
			driver.findElement(element).sendKeys(value);

		} catch (Exception e) {
			
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);
		}

	}

	public static void Sendkeys(By element, int value) {

		try {

			String convertValue = String.valueOf(value);
			halliganAudit.log(Status.INFO, "[Enter the Test Data] - value is : " + "\"" + convertValue + "\"");
			driver.findElement(element).sendKeys(convertValue);
		} catch (Exception e) {
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);
		}
	}

	public static void Click(By element) {
		try {
			halliganAudit.log(Status.INFO, "[Click the element] - element is : " + "\"" + element + "\"");
			driver.findElement(element).click();
		} catch (Exception e) {
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);
		}
	}

	public static String Getattribute(By element, String attribute) {
		String value = "";
		try {
			value = driver.findElement(element).getAttribute(attribute);
			halliganAudit.log(Status.INFO, "[Extract the value from UI] - value is : " + "\"" + value + "\"");

		} catch (Exception e) {
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);
			
		}
		return value;
	}

	public static String Gettext(By element) {
		String value = "";
		try {
			value = driver.findElement(element).getText();
			halliganAudit.log(Status.INFO, "[Extract the value from UI] - value is : " + "\"" + value + "\"");

		} catch (Exception e) {
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);

		}
		return value;
	}

	public static void JSscrollandclick(By element) throws Exception {

		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
			Thread.sleep(1000);
			executor.executeScript("arguments[0].click();", driver.findElement(element));
			halliganAudit.log(Status.INFO, "[Scroll into view and Click the element] - element is : " + "\"" + element + "\"");

		} catch (Exception e) {
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);

		}

	}
	
	public static void JSscrollintoview(By element) throws Exception {

		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
			Thread.sleep(1000);
			halliganAudit.log(Status.INFO, "[Scroll into view and Click the element] - element is : " + "\"" + element + "\"");

		} catch (Exception e) {
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);
		}

	}
	
	public static void JSclick(By element) throws Exception {

		try {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(element));
			Thread.sleep(1000);
			halliganAudit.log(Status.INFO, "[Scroll into view and Click the element] - element is : " + "\"" + element + "\"");

		} catch (Exception e) {
			halliganAudit.log(Status.FAIL, e + "Failure element is - " + "\"" + element + "\"");
			throw(e);
		}

	}

}
