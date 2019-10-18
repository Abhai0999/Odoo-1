package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;

public class SalesFeatures 
{
	CustomerSteps cs;
	CommonSteps cms;
	SeleniumLib sl;
		
	public SalesFeatures(WebDriver driver) 
	{
		cs=new CustomerSteps(driver);
		cms=new CommonSteps(driver);
		sl=new SeleniumLib(driver);
	}
	
	public void createNewCust(String[] customerData) 
	{		
		cms.clickCRM();
		cms.clickSales();
		cms.clickCustomers();
		cs.clickCreate();
		cs.createCustomer(customerData);
		cs.VerifyCrtCust(customerData);
	}
	public void deleteCust(String[] customerData) 
	{
		sl.iSleep(10);
		cms.clickCRM();
		sl.iSleep(10);
		cms.clickSales();
		cms.clickCustomers();
		cs.deleteCustomer(customerData);
		sl.iSleep(10);
		cs.VerifyDltCust(customerData);
	}
}