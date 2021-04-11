package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExtentManager.extentManager;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
	
	public static WebDriver driver;
	public Properties prop;
	public WebDriverWait wait;
	
	@Before
	public void setup() throws IOException {
		
		prop = new Properties();
		String path = System.getProperty("user.dir") + "\\" + "src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "chromedriver.exe");
		
		driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		wait=new WebDriverWait(driver,10);
		
		//extentManager.test.log(Status.INFO,"[Navigate to URL]");
		driver.get(prop.getProperty("url"));
	//	extentManager.test.log(Status.PASS,"[Navigated to URL]"+" " +":"+ prop.getProperty("url"));
	}
	
	@After
	public void tearDown() throws IOException {
		driver.close();
	}

}
