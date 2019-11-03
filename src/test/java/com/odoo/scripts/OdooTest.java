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
	
	@Test(dependsOnMethods= {"validLoginTest"})
	public void createUsers() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		eu.readAndWriteData2("Sheet2","Sheet1","create_user_ID",6);
		String[] userData = eu.readData("Sheet1","create_users_ID");
		lf.login(userData[1],userData[2]);
		cff.createUser(userData);		
	}
	
	@Test(dependsOnMethods= {"createUsers"})
	public void createSalesTeam() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		eu.readAndWriteData2("Sheet2","Sheet1","create_salesTeam_ID",7);	
		String[] salesTeamData = eu.readData("Sheet1","create_salesTeam_ID");
		lf.login(salesTeamData[1],salesTeamData[2]);
		cff.createSalesTeam(salesTeamData);
	}
	
	@Test(dependsOnMethods= {"createSalesTeam"})
	public void createCustomer() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		eu.readAndWriteData1("Sheet2","Sheet1","create_customer_ID",3,3);
		String[] customerData = eu.readData("Sheet1","create_customer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.createCustomer(customerData);	
	}
	
	@Test(dependsOnMethods= {"createCustomer"})
	public void createOpportunity() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		eu.readAndWriteData1("Sheet2","Sheet1","create_opportunity_ID",4,3);
		String[] opportunityData=eu.readData("Sheet1", "create_opportunity_ID");
		String[] customerData=eu.readData("sheet1", "create_customer_ID");
		lf.login(customerData[1], customerData[2]);
		sf.createOpportunity(opportunityData, customerData);
	}
	
	@Test(dependsOnMethods= {"createOpportunity"})
	public void scheduleMeetingActivity() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		eu.readAndWriteData1("Sheet2","Sheet1","create_scheduleActivity_ID",5,3);
		String[] customerData = eu.readData("Sheet1","create_customer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.scheduleActitivity();
	}
	
	@Test(dependsOnMethods= {"scheduleActivity"})
	public void drgAndDrpOpportunity() 
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		eu.readAndWriteData1("Sheet2","Sheet1","create_opportunity_ID",4,3);
		String[] opportunityData=eu.readData("Sheet1", "create_opportunity_ID");
		lf.login(opportunityData[1], opportunityData[2]);
		sf.dragAnOpportunity(opportunityData);
	}

	@Test(dependsOnMethods= {"drgAndDrpOpportunity"})
	public void deleteCustomer() 
	{ 
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] customerData = eu.readData("Sheet1", "create_customer_ID");
		lf.login(customerData[1],customerData[2]);
		sf.deleteCustomer(customerData);
	}
}