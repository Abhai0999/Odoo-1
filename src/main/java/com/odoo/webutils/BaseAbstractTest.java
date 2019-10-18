package com.odoo.webutils;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.odoo.features.CommonFeatures;

import com.odoo.features.LoginFeatures;
import com.odoo.features.SalesFeatures;
import com.odoo.generic.Driver;
import com.odoo.generic.GenericLib;

public abstract class BaseAbstractTest 
{
	public static EventFiringWebDriver driver;   //global driver
	public LoginFeatures lf;
	public CommonFeatures cf;
    public SalesFeatures sf;
	
	@BeforeClass
	public void setUp()
	{
		MyTestListener listener=new MyTestListener();
		driver=new EventFiringWebDriver(Driver.getDriver());
		driver.register(listener);
		lf=new LoginFeatures(driver);
		cf=new CommonFeatures(driver);
		sf=new SalesFeatures(driver);
		
	}
	
	@BeforeMethod
	public void preCondition()
	{
		driver.get(GenericLib.getValue(GenericLib.getConfigFile(),"url"));
	}
//	
//	@AfterMethod
//	public void postCondition()
//	{
//		cf.logout();
//	}

}
