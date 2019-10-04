package com.odoo.webutils;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public abstract class BaseAbstractTest 
{
	public static EventFiringWebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		
		
		
	}
	
	@BeforeMethod
	public void preCondition()
	{
		MyTestListener listener=new MyTestListener();
		driver=new EventFiringWebDriver(Driver.getDriver());
		driver.register(listener);
		driver.get(GenericLib.getValue(GenericLib.getConfigFile(), "url"));
	}
	
	@AfterMethod
	public void postCondition()
	{
		
		
	}
	
	
	
}
