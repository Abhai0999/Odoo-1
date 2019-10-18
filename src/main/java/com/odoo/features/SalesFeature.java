package com.odoo.features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.pageobjects.BasePage;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomerStep;

public class SalesFeature {
	public WebDriver driver;
	CustomerStep ccs;
	BasePage bp;
	CommonSteps cs;
	public SalesFeature(WebDriver driver) {
		this.driver=driver;
		ccs=new CustomerStep(driver);
		bp=new BasePage();
		cs=new CommonSteps(driver);
		
	}
	
	public void createCust(String[] cust_data) {
		cs.clickCrm();
		cs.clickSales();
		cs.clickCust();
		ccs.clickCreate();
		ccs.createCustomer(cust_data);
		
		ccs.saveNew();
		
	}
	public void  verifyCreateCustomer(String cust_data) {
		String nm = driver.getTitle();
		//System.out.println(nm);
		String[] y = nm.split(" ");
		String act_name = y[0];
		//System.out.println(act_name);
		String req_name=cust_data;
		//System.out.println(req_name);
		Assert.assertEquals(act_name, req_name);
		Reporter.log("create customer verified", true);
	}
	
	public void cust_del_F(String[] cust_data) {
		//ccs.delcustStep(cust_data[3]);
	}
	public void cust_del_F2() {
		ccs.delcustStep2();
	}
	public void  createCustIMP_f() {
		cs.clickCrm();
		cs.clickSales();
		cs.clickCust();
		ccs.clickImport();
		ccs.clickLoad();
		ccs.clickImport_con();
		
		
	}
}
