package StepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExtentManager.extentManager;
import com.aventstack.extentreports.Status;

import Driver.MedplusDriver;
import PageObjects.Login;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks {

	public static WebDriver driver;
	public Properties prop;
	public static WebDriverWait wait;
	
	
  
	

	@Before
	public void setup() throws IOException {
		System.out.println("am in hooks before");

		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\" + "src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
			
		}

		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "geckodriver.exe");

			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		wait=new WebDriverWait(driver,10);
//switching branch


		extentManager.test.log(Status.INFO,"[Navigate to URL]");
		driver.get(prop.getProperty("url"));
		extentManager.test.log(Status.PASS,"[Navigated to URL]"+" " +":"+ prop.getProperty("url"));
		
		extentManager.test.log(Status.INFO,"[Pass the Username]");
		MedplusDriver.getLogin().userName.sendKeys(prop.getProperty("username"));
		extentManager.test.log(Status.PASS,"[UserName is Passed]");
		
		extentManager.test.log(Status.INFO,"[Pass the Password]");
		MedplusDriver.getLogin().Password.sendKeys(prop.getProperty("Password"));
		extentManager.test.log(Status.PASS,"[Password is passed]");
		
		extentManager.test.log(Status.INFO,"[Click the signIn button]");
		wait.until(ExpectedConditions.presenceOfElementLocated(Login.wait_signIn())).click();
		extentManager.test.log(Status.PASS,"[Clicked the signIn button]");
	}

	@After
	public void tearDown() throws IOException {
		System.out.println("am in hooks after");
		

		
	}

}
