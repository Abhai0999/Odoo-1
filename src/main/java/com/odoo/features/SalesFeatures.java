package com.odoo.features;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerCreateSteps;
import com.odoo.steps.DeletCustomerSteps;

public class SalesFeatures 
{
	DeletCustomerSteps dcs;
	CustomerCreateSteps ccs;
	CommonSteps cs;
	SeleniumLib sl;
    
public SalesFeatures(WebDriver driver) 
{
	
	ccs=new CustomerCreateSteps(driver);
	cs=new CommonSteps(driver);
	sl=new SeleniumLib(driver);
	dcs=new DeletCustomerSteps(driver);
}
public void createCustomer(String[] customerData) throws EncryptedDocumentException, IOException
{
	sl.iSleep(10);
	cs.clickCrm();
	sl.iSleep(7);
	cs.clickonSales();
	sl.iSleep(7);
	cs.ClickCustomerBtn();
	sl.iSleep(7);
	ccs.clickCreateBtn();
	sl.iSleep(7);
	ccs.createCustomer(customerData);
	ccs.verifyCreateCustomer();
}
			
public void delcustmoer()
{   
	sl.iSleep(7);
	cs.clickCrm();
	
	sl.iSleep(7);
	cs.clickonSales();
	
	sl.iSleep(7);
	cs.ClickCustomerBtn();
	
	sl.iSleep(7);
	dcs.deleteCustomer();
}

}
