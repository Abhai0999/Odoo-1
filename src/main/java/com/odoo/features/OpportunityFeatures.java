package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;
import com.odoo.steps.OpportunitySteps;

public class OpportunityFeatures {
	CustomerSteps ccs;
	LoginFeatures lf;
	CommonSteps cs;
	SeleniumLib sl;
	OpportunitySteps os;
	
	public OpportunityFeatures(WebDriver driver){
		
		ccs = new CustomerSteps(driver);
		lf = new LoginFeatures(driver);
		cs = new CommonSteps(driver);
		sl = new SeleniumLib(driver);	
		os =  new OpportunitySteps(driver);
		
	}
public void CreateOpportunity(String username,String password,String OppName,String CustomerName,String Revenue){
	
	lf.login(username, password);
	sl.iSleep(5);
	cs.CrmBtn();
	sl.iSleep(5);
	os.CreatePiplineBtn();
	sl.iSleep(5);
	os.EnterOpportunity(OppName);
	sl.iSleep(5);
	os.EnterCustomerName(CustomerName);
	sl.iSleep(5);
	os.AddBtn();
	}
	
}
