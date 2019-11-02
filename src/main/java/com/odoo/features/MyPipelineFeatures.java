package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.MyPipelineSteps;

public class MyPipelineFeatures
{
	SeleniumLib sl;
	CommonSteps cs;
	MyPipelineSteps mps;
	
	public MyPipelineFeatures(WebDriver driver)
	{
		sl=new SeleniumLib(driver);
		cs=new CommonSteps(driver);
		mps=new MyPipelineSteps(driver);
		
	}
	
	public void createOpportunity(String[] pipeline)
	{
		cs.clickCRM();
		sl.iSleep(5);
		cs.clickSales();
		sl.iSleep(5);
		mps.createPipeline(pipeline);
	}
	
//	public void verifyOpportunity(String actualText, String Opportunity)
//	{
//		mps
//		
//		
//	}

}
