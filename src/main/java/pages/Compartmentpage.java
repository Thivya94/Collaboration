package pages;

import org.openqa.selenium.By;

public class Compartmentpage {
	
	public static By createCompartmentLayout = By.xpath("//button[text()='Create Compartment Layout']");
	public static By trackSeals = By.xpath("//label[text()='Track Seals']/parent::*//span[contains(@class,'rc-switch')]");
	public static By name = By.id("name");
	public static By signatureSettings = By.xpath("//label[text()='Signature Settings']/parent::*//select");
	public static By create = By.xpath("//button[text()='Create']");
	public static By save = By.xpath("//button[text()='Save']");
	public static By delete = By.xpath("//button[text()='Delete']");
	public static By createCompartmentLayoutTitle = By.xpath("//h4[text()='Create Compartment Layout']");
	

}
