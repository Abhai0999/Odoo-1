package com.odoo.steps;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.PipelinePage;

public class OpportunitySteps 
{
	WebDriver driver;
	PipelinePage pp;
	SeleniumLib sl;
	
	public OpportunitySteps(WebDriver driver) 
	{
		this.driver=driver;
		pp=new PipelinePage();
		sl= new SeleniumLib();
	}
	
	public void clickCreate() 
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(pp.createBtn)).click();	
	}
	
	public void CreateOpportunity(String[] OpportunityData,String[] customerData) 
	{ 
		sl.iSleep(10);
		driver.findElement(By.xpath(pp.opportunity)).sendKeys(OpportunityData[3]);
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.customerDrpDwn)).click();
		sl.iSleep(10);
		List<WebElement> existedCustomers = driver.findElements(By.xpath(pp.customerName));
		for (WebElement ele : existedCustomers) 
		{
			String customerName = ele.getText();
			if(customerName.equalsIgnoreCase(customerData[3])) 
			{
				ele.click();
			}
		}
		sl.iSleep(5);
		WebElement expectedRevenue = driver.findElement(By.xpath(pp.expcetedRevenue));
		expectedRevenue.sendKeys(Keys.CONTROL+"a");
		expectedRevenue.sendKeys(Keys.DELETE);
		expectedRevenue.sendKeys(OpportunityData[4]);
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.addBtn)).click();
	} 
	
	public void verifyOpportunity(String[] OpportunityData) 
	{
		sl.iSleep(10);
		String actaulOpportunity=driver.findElement(By.xpath(pp.newOpprotunity)).getText();
		String actualTitle=driver.getTitle();
		String expectedTitle=""+OpportunityData[3]+" - Odoo";
		
		sl.iSleep(5);
		Assert.assertEquals(actaulOpportunity, OpportunityData[3]);
		sl.iSleep(5);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("***************Create Opportunity Verified***************");
	}
	
	public void dragAnOpportunity(String[] OpportunityData) 
	{ 
		sl.iSleep(10);
		List<WebElement> allOpportunities = driver.findElements(By.xpath(pp.allOpprotunities));
		sl.iSleep(10);
		WebElement srcEle = driver.findElement(By.xpath(pp.srcEle));
		sl.iSleep(10);
		WebElement destEle = driver.findElement(By.xpath(pp.destEle));
		sl.iSleep(5);
		for (WebElement ele : allOpportunities) 
		{
			String customer = ele.getText();
			if(customer.equalsIgnoreCase(OpportunityData[3])) 
			{
				sl.dragAndDropByWebelement(srcEle, destEle);
				break;
			}
		}
	}
	
	public void verifyDragedOpportunity(String[] OpportunityData) {}
	public void deleteDragedOpportunity(String[] OpportunityData) {}
	public void verifyDeleteDragedOpportunity(String[] OpportunityData) {}
	public void scheduleActivity(String[] OpportunityData9) {}
}
