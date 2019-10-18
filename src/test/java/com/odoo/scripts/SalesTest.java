package com.odoo.scripts;




import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class SalesTest extends BaseAbstractTest{
	
	@Test
	public void createCustomer(){
		
		
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] custdata = eu.readData("Sheet1", "create customer_ID" + 
				"");
		lf.login(custdata[1], custdata[2]);
		
		sf.createNewCustomer(custdata);
		
	}

}
