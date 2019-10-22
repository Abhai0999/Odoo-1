package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class OdooTest extends BaseAbstractTest
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
	
	@Test()
	public void createCustomer() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_customer_ID",4);
		
		String[] customerData = eu.readData("Sheet1","create_customer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.createCustomer(customerData);	
	}
	
	@Test(dependsOnMethods= {"createCustomer"})
	public void deleteCustomer() 
	{ 
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "create_customer_ID");
		
		lf.login(customerData[1],customerData[2]);
		sf.deleteCustomer(customerData);
	}
	
	@Test
	public void createSalesTeam() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_salesTeam_ID", 4);
		
		String[] salesTeamData = eu.readData("Sheet1","create_salesTeam_ID");
		lf.login(salesTeamData[1],salesTeamData[2]);
		cff.createSalesTeam(salesTeamData);
	}
	
	@Test(dependsOnMethods= {"createSalesTeam"})
	public void deleteSalesTeam() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] salesTeamData = eu.readData("Sheet1", "create_salesTeam_ID");
		
		lf.login(salesTeamData[1],salesTeamData[2]);
		cff.deleteSalesTeam(salesTeamData);	
	}
	
	@Test()
	public void createOpportunity() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_customer_ID", 4);
		String[] opportunityData=eu.readData("Sheet1", "create_opportunity_ID");
		
		String[] customerData=eu.readData("sheet1", "create_customer_ID");
		lf.login(opportunityData[1], opportunityData[2]);
		sf.createOpportunity(opportunityData, customerData);
	}
	
	@Test(dependsOnMethods= {"createOpportunity"})
	public void drgAndDrpOpportunity() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		
		eu.readAndWriteData("Sheet1","create_opportunity_ID", 4);
		
		String[] opportunityData=eu.readData("Sheet1", "create_opportunity_ID");
		
		String[] customerData=eu.readData("sheet1", "create_customer_ID");
		lf.login(customerData[1], customerData[2]);
		sf.dragAnOpportunity(opportunityData);
	}
}