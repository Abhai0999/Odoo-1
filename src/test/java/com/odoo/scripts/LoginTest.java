package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class LoginTest extends BaseAbstractTest
{
	@Test
	public void validLoginTest()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("Sheet1", "validLogin_ID");
		lf.login(data[1], data[2]);
		
		lf.verifyValidLogin(data[1]);
	}

//	@Test
//	public void createOpportunityTest() {
//		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
//		ExcelUtilities eu = new ExcelUtilities(filepath);
//		String[] data = eu.readData("Sheet1", "CreateOpportunity_ID");
//		of.CreateOpportunity(data[1], data[2], data[3], data[4], data[5]);
//	
//}
}

