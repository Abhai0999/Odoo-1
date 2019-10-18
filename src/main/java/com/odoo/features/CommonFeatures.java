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
	
	public void logout()
	{
		sl.iSleep(6);
		cs.clickMenuDrpDwnList();
		cs.clickLogout();
	}
	public void salesDiv() {
		sl.iSleep(4);
		cs.clickCrm();
		//sl.iSleep(3);
		cs.clickSales();
		
		sl.iSleep(3);
		cs.clickCust();
		//sl.iSleep(3);
	}
}
