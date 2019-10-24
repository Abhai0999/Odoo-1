package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomersSteps;

public class SalesFeatures 

{
    CommonSteps cs;
	CustomersSteps cus;
	SeleniumLib sl;
	
	public SalesFeatures(WebDriver driver)
	
	{
		cus = new CustomersSteps(driver);
		cs = new CommonSteps(driver);
		sl = new SeleniumLib(driver);
		
	}
	
	public void createNewCustomer(String[] customerData)
	
	{
		sl.iSleep(7);
		cs.clickCRM();
		sl.iSleep(7);

		cs.clickSales();
		sl.iSleep(7);

		cs.clickCustomers();
		sl.iSleep(7);

		cus.clickCreate();
		sl.iSleep(7);

		cus.createCustomer(customerData);
		sl.iSleep(7);
		
		
	}
	
	
}
