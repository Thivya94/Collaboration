package com.halligan.Prerequiste;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.halligan.intface.Prerequiste;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Prerequisteimplementation implements Prerequiste {

	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentSparkReporter reporter;
	public static ExtentTest halliganAudit;
	
	public void Launchapplication() {
		
		

	}

	public void Launchbrowser(String browserType) {

		switch (browserType.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			FirefoxOptions ffOptions = new FirefoxOptions();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(ffOptions);
			break;
		case "internetexplore":
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(ieOptions);
			break;

		}
	}

	public void Lanuchreport() {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String reportName = "Halligan_report";
	    reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Report/" + reportName + dateName + ".html");
	    report = new ExtentReports();
		report.attachReporter(reporter);
		
		reporter.config().setDocumentTitle("First report");
        reporter.config().setReportName("colour report2");
        reporter.config().setTheme(Theme.DARK);
        
        report.setSystemInfo("QA", "john");
        report.setSystemInfo("Windows", "8.1");
        report.setSystemInfo("Browser", "chrome");

	}
	
	public static String TakeScreenshot(String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public void DB_connection()
	{
		String connectionUrl =
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                + "database=logincredential;"
                + "user=mmraj;"
                + "password=admin;"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl);
                Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "select * from credential where userName='checkit-cs-on@halligan.io'";
            		
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString("url") + " " + resultSet.getString("password"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public void Quitapplication() {
		// TODO Auto-generated method stub

	}

	public void Quitbrowser() {

		driver.quit();

	}

	public void Quitreport() {
		
		report.flush();
	}

}
