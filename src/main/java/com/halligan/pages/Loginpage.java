package com.halligan.pages;

import org.openqa.selenium.By;

public class Loginpage {
	
	public static By userName = By.id("email");
	public static By Continue = By.xpath("//button[text()='Continue']");
	public static By password = By.id("password");
	public static By signIn = By.xpath("//button[text()='Sign in']");

}
