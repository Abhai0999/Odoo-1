package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;
import com.odoo.steps.OpportunitySteps;

public class SalesFeatures 
{
	CustomerSteps cs;
	CommonSteps cms;
	OpportunitySteps os;
		
	public SalesFeatures(WebDriver driver) 
	{
		cs=new CustomerSteps(driver);
		cms=new CommonSteps(driver);
		os=new OpportunitySteps(driver);
	}
	
	public void createCustomer(String[] customerData) 
	{		
		cms.clickCRM();
		cms.clickSales();
		cms.clickCustomers();
		cs.clickCreate();
		cs.createCustomer(customerData);
		cs.VerifyCrtCustomer(customerData);
	}
	
	public void deleteCustomer(String[] customerData) 
	{
		cms.clickCRM();
		cms.clickSales();
		cms.clickCustomers();
		cs.deleteCustomer(customerData);
		cs.VerifyDltCustomer(customerData);
	}
	
	public void createOpportunity(String[] OpportunityData,String[] customerData) 
	{
		cms.clickCRM();
		cms.clickSales();
		cms.clickMyPipeLine();
		os.clickCreate();
		os.CreateOpportunity(OpportunityData, customerData);
		os.verifyOpportunity(OpportunityData);
	}
	public void dragAnOpportunity(String[] OpportunityData) 
	{
		cms.clickCRM();
		cms.clickSales();
		cms.clickMyPipeLine();
		os.dragAnOpportunity(OpportunityData);
		os.verifyDragedOpportunity(OpportunityData);
	}
}