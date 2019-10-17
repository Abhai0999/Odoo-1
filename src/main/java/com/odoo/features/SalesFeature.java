package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomersSteps;

public class SalesFeature 
{

	CustomersSteps cus;
	CommonSteps cs;
	SeleniumLib sl;
	
	
	
	public SalesFeature(WebDriver driver)
	{
		
		cus=new CustomersSteps(driver);
		cs=new CommonSteps(driver);
		sl=new SeleniumLib(driver);
	}
	
	public void createNewCustomer(String[] customerData)
	{
		cs.clickCRM();
		cs.clickSales();
		cs.clickCst();
		cus.clickCreate();
		cus.createCustomer(customerData);
	}
	
	public void dltNewCustomer(String[] customerData1 )
	{
		
		cs.clickCRM();
		cs.clickSales();
		cs.clickCst();
		cus.dltCustomer(customerData1);
	}
	
	
	
	
	
}
