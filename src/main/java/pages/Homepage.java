package pages;

import org.openqa.selenium.By;

public class Homepage {
	
	public static By postButton = By.xpath("//button[text()='Post']");
	public static By apparatus = By.xpath("//span[text()='Apparatus']");
	public static By storeRooms = By.xpath("//span[text()='Store Rooms']");
	public static By equipment = By.xpath("//span[text()='Equipment']");
	public static By inventory = By.xpath("//span[text()='Inventory']");
	public static By inventoryArrow = By.xpath("//span[text()='Inventory']/parent::*");
	public static By tools = By.xpath("//span[text()='Tools']");
	public static By medicalSupplies = By.xpath("//span[text()='Medical Supplies']");
	public static By drugs = By.xpath("//span[text()='Drugs']");
	public static By compartments = By.xpath("//span[text()='Compartments']");
	public static By controlledSubstances = By.xpath("//span[text()='controlledSubstances']");
	public static By tickets = By.xpath("//span[text()='tickets']");
	public static By users = By.xpath("//span[text()='Users']");
	public static By permissions = By.xpath("//span[text()='Permissions']");

}
