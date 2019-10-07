package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;

public class CommonFeatures 
{
	CommonSteps cs;
	
	public CommonFeatures(WebDriver driver)
	{
		cs=new CommonSteps(driver);
	}
	
	public void logout()
	{
		cs.clickMenuDrpDwnList();
		cs.clickLogout();
	}
}
