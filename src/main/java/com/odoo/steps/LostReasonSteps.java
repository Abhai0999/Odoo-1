package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.LostReasonPage;

public class LostReasonSteps 
{
	
	WebDriver driver;	
	LostReasonPage lrp;
	SeleniumLib sl;
	
	public LostReasonSteps(WebDriver driver)
	{
		this.driver=driver;		
		lrp=new LostReasonPage();
		sl=new SeleniumLib(driver) ;
				
	}
	
	public void ClickOnLostReason()
	{
		driver.findElement(By.xpath(lrp.clickOnLostReason)).click();
	}
	
	public void createLostReason(String[] reason)
	{
	
		sl.iSleep(5);
		driver.findElement(By.xpath(lrp.createButton)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(lrp.reasonSlot)).sendKeys(reason[3]);
		sl.iSleep(5);
		driver.findElement(By.xpath(lrp.save)).click();
		
	}
	
	public void verifyCreateLostReason(String[] expected,String[]reason)
	{
		sl.iSleep(5);
		String actual = driver.findElement(By.xpath(lrp.verfyCrtLostRsn)).getText();
		Assert.assertEquals(actual, expected[3]);		
		String actual1 = driver.getTitle();
		String expected1 = ""+reason[3]+" - Odoo";
		Assert.assertEquals(actual1, expected1);
		Reporter.log(expected1+ " is verified",true);
	}
	

}
