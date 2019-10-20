package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerSteps;

public class SalesFeatures {
	
	CustomerSteps cus;
	CommonSteps cs;

	public SalesFeatures(WebDriver driver) {
		
       cus = new CustomerSteps(driver);
		cs = new CommonSteps(driver);	
	}

	public void CreateNewCustomer(String[] customerData)  {
		
	    cs.CrmBtn();
		cs.ClickSales();
		cs.SelectCustomer();
		cus.clickCreate();
		cus.createCustomer(customerData);
	    cus.verifyCreateCustomer();
	

	}
	
public void DeleteExistingCustomer(String[] name ) {
		

	    cs.CrmBtn();
		cs.ClickSales();
		cs.SelectCustomer();
		 cus.deleteCustomer(name);
}
public void ImportFile( ){
	
	cs.CrmBtn();
	cs.ClickSales();
	cs.SelectCustomer();
	cus.importFile();
	
	
	
}
public void verifyImportedFile(String sheet, int row, int cell){
	
	cs.CrmBtn();
	cs.ClickSales();
	cs.SelectCustomer();
	cus.importFile();
	cus.verifyImportFile(sheet, row, cell);
}



}


