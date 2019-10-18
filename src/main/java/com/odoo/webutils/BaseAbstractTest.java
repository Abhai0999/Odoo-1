package com.odoo.webutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.odoo.features.CommonFeatures;
import com.odoo.features.LoginFeatures;
import com.odoo.features.SalesFeature;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public abstract class BaseAbstractTest 
{
	public static EventFiringWebDriver driver;   //global driver
	public LoginFeatures lf;
	public CommonFeatures cf;
	public SalesFeature sf;
	
	@BeforeClass
	public void setUp()
	{
		
		  MyTestListener listener=new MyTestListener(); driver=new
		  EventFiringWebDriver(Driver.getDriver()); //global driver
		  driver.register(listener); lf=new LoginFeatures(driver); cf=new
		  CommonFeatures(driver); sf=new SalesFeature(driver);
		 
	}
		@BeforeMethod
	public void preCondition()
	{
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(GenericLib.getValue(GenericLib.getConfigFile(), "url"));
	}
	
	
	 // @AfterMethod 
	 // public void postCondition() 
	 // { 
		//  cf.logout();
	  
	  //}
	 
}
