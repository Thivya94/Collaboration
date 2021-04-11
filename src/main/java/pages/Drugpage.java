package pages;

import org.openqa.selenium.By;

public class Drugpage {
	
	public static By createDrug = By.id("//button[text()='Create Drug']");
	public static By searchItem = By.id("//input[@placeholder ='Search Item']");
	public static By name = By.id("name");
	public static By number = By.id("//input[@type='number']");
	public static By trackExpirationDates = By.id("//label[text()='Track Expiration Dates']/parent::*//span[contains(@class,'rc-switch-checked')]");
	public static By controlledSubstance = By.id("//label[text()='Controlled Substance']/parent::*//span[contains(@class,'rc-switch')]");
	public static By trackBy = By.id("//label[text()='Track By']/parent::*//select");
	public static By create = By.id("//button[text()='Create']");
	public static By Close = By.id("//button[text()='Close']");
	public static By save = By.id("//button[text()='Save']");

}
