package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class ConfigurationTest extends BaseAbstractTest
{ 
	@Test
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
}