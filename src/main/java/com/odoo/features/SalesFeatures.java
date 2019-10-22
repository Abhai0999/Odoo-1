package com.odoo.features;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CreateCustomerSteps;
import com.odoo.steps.DeleatCustomerSteps;
import com.odoo.steps.MyPipelineSteps;

public class SalesFeatures
{
	
CommonSteps cs;
CreateCustomerSteps ccs;
DeleatCustomerSteps dcs;
SeleniumLib sl;
MyPipelineSteps mps;
public SalesFeatures(WebDriver driver)
{

	cs=new CommonSteps(driver);
	ccs=new CreateCustomerSteps(driver);
	dcs=new DeleatCustomerSteps(driver);
	sl=new SeleniumLib(driver);
	mps=new MyPipelineSteps(driver);
}

public void createNewCustomer(String[] customerData) 
{
    sl.iSleep(2);
	cs.clickOnCrm();
	cs.clickOnSales();
	cs.clickOnCustomer();
	ccs.clickCreate();
	ccs.createCustmer(customerData);
	ccs.verifyCreateCustomer();

}

public void deleteCustmer(String delCustmername)
{

  
	cs.clickOnCrm();
	cs.clickOnSales();
	cs.clickOnCustomer();
	dcs.delCustomer(delCustmername);
	
	
}

public void importCusomerFeature()
{
	cs.clickOnCrm();
	cs.clickOnSales();
	sl.iSleep(2);
	cs.clickOnCustomer();
	ccs.importCustomerSteps();
	ccs.verifyImport();

}

public void createMPpipeline(String Opportunity)
{
	cs.clickOnCrm();
	mps.createPipeline(Opportunity);	
	mps.verifyOpportunity();
}


}
