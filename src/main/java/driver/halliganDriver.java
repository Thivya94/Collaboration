package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import base.Testbase;


public class halliganDriver extends Testbase{
	
	public static void findLocator_sendKeys(By loctor, String input )
	{
		Driver.findElement(loctor).sendKeys(input);
	}

	public static void findLocator_clear(By loctor)
	{
		Driver.findElement(loctor).clear();
	}
	
	public static void findLocator_click(By loctor)
	{
		Driver.findElement(loctor).click();
	}
	
	public static String findLocator_getAttribute(By loctor,String attValue)
	{
		String value = Driver.findElement(loctor).getAttribute(attValue);
		return value;
	}
	
	public static void Searchandselect(By loctor, String value)
	{
		Driver.findElement(loctor).sendKeys(value+Keys.TAB);
	}
	
	public static void Javascriptclick(By locator)
	{
		WebElement element = Driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)Driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void Javascriptscroll(By locator)
	{
		WebElement element = Driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)Driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void Selectoption(By locator, String optionValue)
	{
		Select option = new Select(Driver.findElement(locator));
		option.selectByVisibleText(optionValue);
	}
}
