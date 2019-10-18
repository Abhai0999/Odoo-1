package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;

public class CommonFeatures 
{
	CommonSteps cs;
	SeleniumLib sl;
	
	public CommonFeatures(WebDriver driver)
	{
		cs=new CommonSteps(driver);
		sl=new SeleniumLib(driver);
	}
	
	 
//	public void commonEle()
//	{
//		sl.iSleep(20);
//		cs.clickCRM();
//		sl.iSleep(10);
//		cs.clickSales();
//		sl.iSleep(10);
//		cs.clickCst();
//		sl.iSleep(10);
//		
//	}
	
	
	public void logout()
	{
		cs.clickMenuDrpDwnList();
		cs.clickLogout();
	}
	
	
}
