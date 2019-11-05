package com.odoo.features;

import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.steps.CommonSteps;
import com.odoo.steps.CustomersSteps;
import com.odoo.steps.PipeLineSteps;

public class SalesFeature 
{


	CustomersSteps cus;
	CommonSteps cs;
	SeleniumLib sl;
	PipeLineSteps pls;




	public SalesFeature(WebDriver driver)
	{

		cus=new CustomersSteps(driver);
		cs=new CommonSteps(driver);
		sl=new SeleniumLib(driver);
		pls=new PipeLineSteps(driver);

	}

	public void createNewCustomer(String[] customerData)
	{
		cs.clickCRM();
		cs.clickSales();
		cs.clickCst();
		cus.clickCreate();
		cus.createCustomer(customerData);
	}

	public void verifyNewCustomer(String userName,String custName)
	{
		cus.VerifyNewCustomer(userName, custName);
	}



	public void dltNewCustomer(String[] customerData1 )
	{

		cs.clickCRM();
		cs.clickSales();
		cs.clickCst();
		cus.dltCustomer(customerData1);
	}

	public void verifyDltCustomer(String[] expextedCust )
	{
		cus.verifyDltCustomer(expextedCust);
	}


	public void createOpportunity(String[] opportunity,String[] customer )
	{
		//sl.iSleep(5);
		cs.clickCRM();
		//sl.iSleep(5);
		cs.clickSales();
		cs.clickMyPipeLine();
		pls.createOpportunity(opportunity, customer);		
	}

	public void verifyOpportunity(String[] expected )
	{
		pls.verifyOpportunity(expected);
	}

	public void deleteOpportunity(String[] opportunity )
	{
		//sl.iSleep(5);
		cs.clickCRM();
		//sl.iSleep(5);
		cs.clickSales();
		cs.clickMyPipeLine();
		pls.deleteOpportunity(opportunity);
	}

	public void verifyDltOpportunity(String[] opportunity )
	{
		pls.verifyDltOpportunity(opportunity);
	}


	public void schdMeetingAct(String[] activityType )
	{
		
		cs.clickCRM();				
		pls.schdMeetingAct(activityType);		
	}

	public void verfschdMeetingAct(String[]expected,String[] opportunity)
	{
		pls.verfschdMeetingAct(expected, opportunity);
	}

	public void MeetingActivityDone(String[] data)
	{
		pls.MeetingActivityDone(data);
	}

	public void verifyMeetingActDone(String[] data)
	{
		pls.verifyMeetingActDone(data);
	}

	public void dragOpportunityNewToQualified(String[]opportunity)
	{
		pls.dragOpportunityNewToQualified(opportunity);
	}

	public void verifyDragOpportunityToQlfd(String[]data)
	{
		pls.verifyDragOpportunityToQlfd(data);
	}
	
	public void creatCallAct(String[] activityType )
	{
		
		cs.clickCRM();		
		pls.creatCallAct(activityType);
	}
	
	public void verifyCreatCallAct(String[]opportunity,String[] expected)
	{
		pls.verifyCreatCallAct(opportunity, expected);
	}
	
	public void callActDone(String[] data)
	{
		pls.callActDone(data);
	}
	public void VerifyCallActDone(String[] expected)
	{
		pls.VerifyCallActDone(expected);
	}
	public void dragOpprQualfdToPrep(String[]opportunity)
	{
		pls.dragOpprQualfdToPrep(opportunity);
	}
	public void verifydragOpprQualfdToPrep(String[] expected )
	{
		pls.verifydragOpprQualfdToPrep(expected);
	}
	
	public void createEmailAct(String[] activityType)
	{
		
		cs.clickCRM();		
		pls.createEmailAct(activityType);
	}
	public void verifyCreatEmailAct(String[] opportunity,String[] expected )
	{
		pls.verifyCreatEmailAct(opportunity, expected);
	}
	
	public void EmailActDone(String[] data)
	{
		pls.EmailActDone(data);
	}
	
	public void VerifyEmailActDone(String[] expected )
	{
		pls.verifyEmailActDone(expected);
	}
	
	public void dragOpprPrepToWon(String[] opportunity )
	{
		pls.dragOpprPrepToWon(opportunity);
	}
	public void verifydragOpprPrepToWon(String[] expected )
	{
		pls.verifydragOpprPrepToWon(expected);
	}

}
