package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.features.ConfigurationFeatures;
import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class ConfigurationTest extends BaseAbstractTest
{
   @Test
   public void lostRsnCreateTest()
   {
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] customerData = eu.readData("verifysheet", "createCustomer_ID");
	lf.login(customerData[1], customerData[2]);
	cof.createLostReason();
	
}
   @Test
   public void salesTeamCreateTest()
   {
	String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
	ExcelUtilities eu=new ExcelUtilities(filepath);
	String[] customerData = eu.readData("verifysheet", "createCustomer_ID");
	lf.login(customerData[1], customerData[2]);
	String[] salesTmData=eu.readData("verifysheet", "salesteam_ID");
	cof.createSalesTeam(salesTmData);
	cof.verifysalesTeam();
	
}
}
