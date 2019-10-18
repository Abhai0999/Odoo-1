package com.odoo.features;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CreateCustomerSteps;
import com.odoo.steps.DeleatCustomerSteps;

public class SalesFeatures
{
	
CommonSteps cs;
CreateCustomerSteps ccs;
DeleatCustomerSteps dcs;
SeleniumLib sl;
public SalesFeatures(WebDriver driver)
{

	cs=new CommonSteps(driver);
	ccs=new CreateCustomerSteps(driver);
	dcs=new DeleatCustomerSteps(driver);
	sl=new SeleniumLib(driver);
}

public void createNewCustomer(String[] customerData) throws EncryptedDocumentException, IOException
{
    sl.iSleep(2);
	cs.clickOnCrm();
	cs.clickOnSales();
	cs.clickOnCustomer();
	ccs.clickCreate();
	ccs.createCustmer(customerData);
	ccs.verifyCreateCustomer();

}

public void deleteCustmer()
{

  
	cs.clickOnCrm();
	cs.clickOnSales();
	cs.clickOnCustomer();
	dcs.delCustomer();
	
	
}



}
