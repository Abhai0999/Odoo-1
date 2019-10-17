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
		cs.clickMenuDrpDwnList();
		cs.clickLogout();
	}
	
	
}
