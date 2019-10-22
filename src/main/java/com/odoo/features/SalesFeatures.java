package com.odoo.features;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.steps.ActivityTypeStep;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CreateCustomerStep;
import com.odoo.steps.CreateOpportunitySteps;
import com.odoo.steps.CreateSalesTeamSteps;
import com.odoo.steps.DeleteCustStpes;

public class SalesFeatures {

	CreateCustomerStep ccs;
	CommonSteps cs;
	SeleniumLib sl;
	CreateOpportunitySteps cos;
	DeleteCustStpes dcs;
	CreateSalesTeamSteps csts;
	ActivityTypeStep ats;

	public SalesFeatures(WebDriver driver) {

		ccs = new CreateCustomerStep(driver);
		cs = new CommonSteps(driver);
		sl = new SeleniumLib(driver);
		dcs = new DeleteCustStpes(driver);
		cos = new CreateOpportunitySteps(driver);
		csts = new CreateSalesTeamSteps(driver);
		ats = new ActivityTypeStep(driver);
	}

	public void createActivity(String activityData[]) {
		sl.iSleep(5);
		cs.clickOnCRM();
		sl.iSleep(5);
		cs.clickOnConfiguration();
		sl.iSleep(3);
		cs.clickOnActivityType();
		sl.iSleep(3);
		ats.CreateActivity(activityData);
	}

	public void createSalesTeam(String salesTeamData[]) {
		sl.iSleep(5);
		cs.clickOnCRM();
		sl.iSleep(9);
		cs.clickOnConfiguration();
		sl.iSleep(5);
		csts.clickOnSalesTeam();
		sl.iSleep(5);
		csts.clickOnCreate();
		sl.iSleep(5);
		csts.createSalTem(salesTeamData);
		Reporter.log("Sales Team has been successfully created ", true);

//		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
//		ExcelUtilities eu = new ExcelUtilities(filepath);

		// String[] salesTeamName[3] = eu.readData("Sheet1", "CreatingSalesTeam_ID");
		// salesTeamData=eu.readData("Sheet1", "CreatingSalesTeam_ID");
		// ("Sheet1", 5, 3, name);
		// csts.validateSaleTeam(salesTeamData[3], salesTeamData[4]);
	}

	public void createNewCustomer(String[] customerData) {
		sl.iSleep(6);
		cs.clickOnCRM();
		sl.iSleep(3);
		cs.clickOnSales();
		sl.iSleep(3);
		cs.clickOnCustomers();
		sl.iSleep(3);
		ccs.clickOncreate();
		sl.iSleep(3);
		ccs.createCustomer(customerData);

	}

	public void CreateOpp(String[] customerData, String[] customername) {
		sl.iSleep(2);
		cs.clickOnCRM();
		sl.iSleep(3);
		cos.createOpportunity(customerData, customername);
	}

	public void deleteCustomer(String name) {
		sl.iSleep(3);
		cs.clickOnCRM();
		sl.iSleep(3);
		cs.clickOnSales();
		sl.iSleep(3);
		cs.clickOnCustomers();
		sl.iSleep(3);
		dcs.selectCust(name);
		sl.iSleep(3);
		dcs.clickOnAction();
		sl.iSleep(3);
		dcs.clickOnDel();
		sl.iSleep(3);
		dcs.confDel();
		dcs.vryDeleteCustomer(name);
	}

}
