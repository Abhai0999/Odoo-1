package com.odoo.features;



import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.steps.CreateCustomerStep;

public class CustomerFeature {
	public WebDriver driver;
	CreateCustomerStep ccs;
	BasePage bp;
	public CustomerFeature(WebDriver driver) {
		this.driver=driver;
		ccs=new CreateCustomerStep(driver);
		bp=new BasePage();
		
	}
	
	public void createCust(String name,String street,String city,String state,String zip,String country,String mobile,String email) {
		
		ccs.clickCreate();
		
		ccs.cust_Name(name);
		ccs.street(street);
		ccs.city(city);
		ccs.state(state);
		ccs.zip(zip);
		ccs.country(country);
		ccs.mobile(mobile);
		ccs.email(email);
		ccs.saveNew();
		
	}
	public void  verifyCreateCustomer(String req_cust) {
		//boolean flag = ccs.myname().isDisplayed();
		//String req_cust="Sandy";
		String act_cust = ccs.myname().getText();
		Assert.assertEquals(act_cust, req_cust);
		Reporter.log("create customer verified", true);
				
		
	}

}
