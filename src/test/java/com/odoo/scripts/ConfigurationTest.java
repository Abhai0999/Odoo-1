package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class ConfigurationTest extends BaseAbstractTest
{
	@Test
	public void salesTeam()
	{
		 String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		 ExcelUtilities eu=new ExcelUtilities(filepath);
		 String[] slTmData = eu.readData("sheet1", "createSalesTeam_ID");
		 String salesName=eu.readAndWriteData("sheet1", "createSalesTeam_ID", 3);
		 lf.login(slTmData[1], slTmData[2]);
		 
		 cgf.createSalesTeam(salesName, slTmData);
		 
		
	}

}
