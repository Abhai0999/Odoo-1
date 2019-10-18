package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CreateCustomerStep;
import com.odoo.steps.DeleteCustStpes;

public class SalesFeatures {

	CreateCustomerStep ccs;
	CommonSteps cs;
	SeleniumLib sl;
	DeleteCustStpes dcs;

	public SalesFeatures(WebDriver driver) {

		ccs = new CreateCustomerStep(driver);
		cs = new CommonSteps(driver);
		sl = new SeleniumLib(driver);
		dcs = new DeleteCustStpes(driver);
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
	}

}
