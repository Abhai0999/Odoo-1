package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.SalesTeamPage;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.SalesTeamSteps;

public class SalesTeamFeatures 

{    
	 WebDriver driver;	
	 CommonSteps cs;
     SalesTeamSteps sts;
     SalesTeamPage stp;
	 SeleniumLib sl;
     
	
	public SalesTeamFeatures(WebDriver driver)
	{
		this.driver=driver;
		sts = new SalesTeamSteps(driver);
		sl = new SeleniumLib(driver);
		cs = new CommonSteps(driver);
		stp = new SalesTeamPage();
	}
	
	public void createSalesTeam(String[] salesteamdata)
	
	{
		sl.iSleep(5);
		cs.clickCRM();
		
		sl.iSleep(5);
		cs.clickConfiguration();
		
		sl.iSleep(5);
		cs.clickSalesTeams();
		
		sl.iSleep(5);
		sts.createSales();
		
		sl.iSleep(5);
		sts.salesTeam(salesteamdata);
		
		
	}
}
