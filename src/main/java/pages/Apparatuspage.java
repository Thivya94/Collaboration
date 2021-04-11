package pages;

import org.openqa.selenium.By;

public class Apparatuspage {

	public static By apparatusHeader = By.xpath("//h1[text()='Apparatus']");
	public static By addApparatus = By.xpath("//button[text()='Add Apparatus']");
	public static By apparatuName = By.id("name");
	public static By vin = By.id("vin");
	public static By make = By.id("make");
	public static By model = By.id("model");
	public static By year = By.id("year");
	public static By create = By.xpath("//button[text()='Create']");
	public static By close = By.xpath("//button[text()='Close']");
	
}
