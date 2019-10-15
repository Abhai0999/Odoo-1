package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.features.CustomerFeature;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class CustomerTest extends BaseAbstractTest{
	
	@Test
	public void createCustomer(){
		String filepath = GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("Sheet1", "create customer_2");
		lf.login(data[1], data[2]);
			
		cf.salesDiv();
		
		CustomerFeature cusf=new CustomerFeature(driver);
		cusf.createCust(data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10]);
		
		//cf.salesDiv();
		//cusf.verifyCreateCustomer(data[3]);
		
		
	}

}
