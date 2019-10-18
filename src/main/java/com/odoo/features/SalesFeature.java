package com.odoo.features;





import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;

public class SalesFeature {
	public WebDriver driver;
	CustomerSteps cus;
	CommonSteps cs;
	SeleniumLib sl;
	
	public SalesFeature(WebDriver driver) {
		
		this.driver=driver;
		
		cus=new CustomerSteps(driver);
		cs=new CommonSteps(driver);
		sl=new SeleniumLib(driver);
		
	}
	
	public void createNewCustomer(String [] customerData) 
	{
		sl.iSleep(4);
		cs.clickCrm();
		sl.iSleep(4);
		cs.clickSales();
		sl.iSleep(4);
		
		cs.clickCust();
		sl.iSleep(4);
		cus.clickCreate();
		sl.iSleep(4);
		cus.createCustomer(customerData);
	
		
	}
	

}
