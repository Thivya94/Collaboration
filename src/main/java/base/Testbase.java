package base;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Writable;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Report.Reportutility;
import config.Getcredential;
import driver.halliganDriver;
import pages.Homepage;
import pages.Loginpages;

public class Testbase {

	public static WebDriver Driver = null;
	public static WebDriverWait wait = null;
	public static ExtentReports report;
	public static ExtentSparkReporter reporter;
	public static ExtentTest halliganAudit;

	

	public static void Launchbrowser() throws IOException {

		Getcredential.Credential();

		if (Getcredential.browser_Type.toLowerCase().equalsIgnoreCase("chrome".toLowerCase())) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\driver\\chromedriver.exe");
			Driver = new ChromeDriver();
		}

		if (Getcredential.browser_Type.toLowerCase().equalsIgnoreCase("firefox".toLowerCase())) {
			System.setProperty("webdriver.firefox.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\halligan\\driver\\geckodriver.exe");
			Driver = new FirefoxDriver();
		}

		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(Driver, 20);

	}

	public static void Lanuchreport() {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String reportName = "Halligan_report";
		reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Extentreports/" + reportName + dateName + ".html");
		report = new ExtentReports();
		report.attachReporter(reporter);

		reporter.config().setDocumentTitle("First report");
		reporter.config().setReportName("colour report2");
		reporter.config().setTheme(Theme.DARK);

		report.setSystemInfo("QA", "john");
		report.setSystemInfo("Windows", "8.1");
		report.setSystemInfo("Browser", "chrome");

	}

	public static void Launchapplication(String controlledSubstance) {

		if (Getcredential.environment.toLowerCase().equalsIgnoreCase("staging".toLowerCase())) {
			Driver.get(Getcredential.s_url);
			if (controlledSubstance.toLowerCase().equalsIgnoreCase("on".toLowerCase())) {

				/*
				 * halliganDriver.findLocator_sendKeys(Loginpages.email,
				 * "ehernandez@halligan.io");
				 * halliganDriver.findLocator_click(Loginpages.Continue);
				 * halliganDriver.findLocator_sendKeys(Loginpages.password, "123456");
				 * halliganDriver.findLocator_click(Loginpages.signIn);
				 * 
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(Homepage.postButton)
				 * );
				 */
			}

			if (controlledSubstance.toLowerCase().equalsIgnoreCase("off".toLowerCase())) {
				/*
				 * halliganDriver.findLocator_sendKeys(Loginpages.email,
				 * "ehernandez@halligan.io");
				 * halliganDriver.findLocator_click(Loginpages.Continue);
				 * halliganDriver.findLocator_sendKeys(Loginpages.password, "123456");
				 * halliganDriver.findLocator_click(Loginpages.signIn);
				 * wait.until(ExpectedConditions.visibilityOfElementLocated(Homepage.postButton)
				 * );
				 */
			}
		}

		if (Getcredential.environment.toLowerCase().equalsIgnoreCase("dev".toLowerCase())) {
			Driver.get(Getcredential.d_url);

			if (controlledSubstance.toLowerCase().equalsIgnoreCase("on".toLowerCase())) {

			}

			if (controlledSubstance.toLowerCase().equalsIgnoreCase("off".toLowerCase())) {

			}

		}

	}

}
