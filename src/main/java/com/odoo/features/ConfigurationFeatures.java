package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CreateCustomerSteps;
import com.odoo.steps.DeleatCustomerSteps;
import com.odoo.steps.LostReasonSteps;
import com.odoo.steps.SalesTeamSteps;

public class ConfigurationFeatures 
{

	CommonSteps cs;
    LostReasonSteps lrs;
	SeleniumLib sl;
	SalesTeamSteps stt;
	public ConfigurationFeatures(WebDriver driver)
	{
		cs=new CommonSteps(driver);
	    lrs=new LostReasonSteps(driver);
		sl=new SeleniumLib(driver);
		stt=new SalesTeamSteps(driver);
	}
	
	public void createLostReason()
	{
		cs.clickOnCrm();
		cs.clickOnConfiguration();
		cs.clickOnLost();
		lrs.createLostReason();
		lrs.verifyLostName();
		
	}
	
	public void createSalesTeam(String[] salestmn)
	{
		cs.clickOnCrm();
		cs.clickOnConfiguration();
		cs.clickOnSalesTeam();
		stt.salesTeamCreate(salestmn);
		
	}
	
	public void verifysalesTeam()
	{
		sl.iSleep(3);
		cs.clickOnCrm();
		sl.iSleep(3);
		cs.clickOnConfiguration();
		cs.clickOnSalesTeam();
		stt.salesTeamVerify();
		
	}
}
