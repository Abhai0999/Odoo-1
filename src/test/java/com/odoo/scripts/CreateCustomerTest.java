package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class CreateCustomerTest extends BaseAbstractTest {

@Test 

	public void createCustomer() {

		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);

		String[] customerData = eu.readData("Sheet1", "CreateCustomer_ID");

		lf.login(customerData[1], customerData[2]);

		sf.createNewCustomer(customerData);

	}

	@Test
	public void creadteOpp() {
		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		String[] data = eu.readData("Sheet1", "CreateOpportunity_ID");
		lf.login(data[1], data[2]);
		String[] name = eu.readData("Sheet1", "CreateCustomer_ID");
		sf.CreateOpp(data, name);
	}

	@Test 
	public void deleteCustomer() {
		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);

		String[] customerName = eu.readData("Sheet1", "CreateCustomer_ID");
		String[] customerData = eu.readData("Sheet1", "DeleteCustomer_ID");

		lf.login(customerData[1], customerData[2]);
		sf.deleteCustomer(customerName[3]);
	}

	@Test
	public void CreatingSalesTeam() {
		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		String[] salesTeamData = eu.readData("Sheet1", "CreatingSalesTeam_ID");
		lf.login(salesTeamData[1], salesTeamData[2]);
		sf.createSalesTeam(salesTeamData);
		
	}
	
	
	@Test
	public void CreateActivity() {
		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		String[] activityData = eu.readData("Sheet1", "CreateActivity_ID");
		lf.login(activityData[1], activityData[2]);
		sf.createActivity(activityData);
	}

}
