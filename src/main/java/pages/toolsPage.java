package pages;

import org.openqa.selenium.By;

public class toolsPage {
	
	
	public static By createTool = By.xpath("//button[text()='Create Tool']");
	public static By createNewTool = By.xpath("//h4[text()='Create New Tool']");
	public static By name = By.id("name");
	public static By selectCategory = By.xpath("//div[text()='Select or Create Category...']/parent::*//div/input");
	public static By create = By.xpath("//button[text()='Create']");
	public static By close = By.xpath("//button[text()='Close']");
	public static By save = By.xpath("//button[text()='Save']");
	
}
