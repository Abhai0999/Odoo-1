package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

public class CreateOpportunityTest extends BaseAbstractTest
{
	@Test
	public void createOpportunity()
	{
		String filepath= GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);
		eu.readAndWriteData("Sheet1",4,3);
		eu.readAndWriteData("Sheet1",4,4);
		eu.readAndWriteData("Sheet1",4,5);
		String[] pipeline=eu.readData("Sheet1", "createOpportunity_ID");
		lf.login(pipeline[1],pipeline[2]);
		mpf.createOpportunity(pipeline);
	}

}
