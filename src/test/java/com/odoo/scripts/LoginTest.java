package com.odoo.scripts;

import org.testng.annotations.Test;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.webutils.BaseAbstractTest;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest extends BaseAbstractTest
{
	@Test
	@Story("Valid login Test")
	@Severity(SeverityLevel.BLOCKER)
	public void validLoginTest()
	{
		String filepath=GenericLib.dir+"/testdata/Odoodata.xlsx";
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String[] data = eu.readData("Sheet1", "validLogin_ID");

		lf.login(data[1], data[2]);
		
		lf.verifyValidLogin(data[1]);
	}
}
