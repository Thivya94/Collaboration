package runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.ExtentManager.extentManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/Features/login.feature", glue = {
		"StepDefinitions" }, monochrome = true, plugin = { "pretty", "json:target/HtmReports.json" })
@Listeners({ listener.ListenerClass.class })
public class TestRunner extends AbstractTestNGCucumberTests {

	public Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeSuite
	public void BeforeSuite() {
		extentManager.setExtent();
	}

	@AfterMethod
	public void tearDown() throws IOException {
		driver.close();
	}
	
	@AfterSuite
	public void AfterSuite() {
		
		extentManager.endReport();
		
	}

}
