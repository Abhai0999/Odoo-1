package com.odoo.generic;

import org.openqa.selenium.WebDriver;

public class Driver 
{
	private static WebDriver wdriver;
	
	public static WebDriver getDriver()
	{
		return wdriver;
	}
	
	public static void setDriver(WebDriver driver)
	{
		wdriver=driver;
	}
	
}
