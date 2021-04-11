package stepDefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import Report.Reportutility;
import base.Testbase;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", plugin = { "html:target/site/cucumber-pretty",
		"json:target/cucumber.json" }, glue = { "" }, monochrome = true)
@Listeners({ Listener.Listener.class })
public class Testrunner extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void Startbrowser() throws IOException {
		
		System.out.println("Beforesuite");
		Testbase.Launchbrowser();
		Testbase.Lanuchreport();
	}

	@AfterSuite
	public void generateReport() {
		Reportutility.generateJVMReport();
		Testbase.Driver.quit();
		Testbase.report.flush();
	}

}
