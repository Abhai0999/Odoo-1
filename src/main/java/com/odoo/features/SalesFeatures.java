package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomersSteps;

public class SalesFeatures 
{
	CommonSteps cs;
	CustomersSteps csts;
	
	public SalesFeatures(WebDriver driver)
	{
		cs=new CommonSteps(driver);
		csts=new CustomersSteps(driver);
	}
	
	public void createCustomer(String[] customerData)
	{
		cs.clickCrm();
		cs.clickSales();
		cs.clickCustomers();
		csts.clickCreate();
		csts.createCustomer(customerData);
//		csts.verifyCustName(customerName);
		
	}
	public void deleteCustomer(String customerData )
	{
		cs.clickCrm();
		cs.clickSales();
		cs.clickCustomers();
		csts.deleteCustomer(customerData);	
	}

	

}
