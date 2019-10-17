package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.VerifyNewCustSteps;

public class VerifyNewCustFeature 
{
	VerifyNewCustSteps vncs;
	 
	public VerifyNewCustFeature(WebDriver Driver)
	{
		vncs=new VerifyNewCustSteps(Driver);
	}
	
	public void verifyNewCustomer(String userName,String custName )
	{
		vncs.verifyCustomer(userName);
		vncs.verifyTitle(custName);
	}

}
