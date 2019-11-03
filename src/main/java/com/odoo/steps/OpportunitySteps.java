package com.odoo.steps;
import java.time.LocalDate;
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
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.opportunity)).sendKeys(OpportunityData[3]);
		sl.iSleep(3);
		driver.findElement(By.xpath(pp.customerDrpDwn)).click();
		sl.iSleep(3);
		List<WebElement> existedCustomers = driver.findElements(By.xpath(pp.customerName));
		for (WebElement ele : existedCustomers) 
		{
			String customerName = ele.getText();
			if(customerName.equalsIgnoreCase(customerData[3])) 
			{
				ele.click();
			}
		}
		sl.iSleep(3);
		WebElement expectedRevenue = driver.findElement(By.xpath(pp.expcetedRevenue));
		expectedRevenue.sendKeys(Keys.CONTROL+"a");
		expectedRevenue.sendKeys(Keys.DELETE);
		expectedRevenue.sendKeys(OpportunityData[4]);
		sl.iSleep(3);
		driver.findElement(By.xpath(pp.addBtn)).click();
	} 
	
	public void verifyCreateOpportunity(String[] OpportunityData) 
	{
		sl.iSleep(5);
		List<WebElement> opprotunities = driver.findElements(By.xpath(pp.allOpprotunities));
		for (WebElement ele : opprotunities) 
		{
			String Opportunity=ele.getText();
			if(Opportunity.equalsIgnoreCase(OpportunityData[3])) 	
			{
				ele.click();
			}
		}
		sl.iSleep(5);
		String actaulOpportunity = driver.findElement(By.xpath(pp.newOpprotunity)).getText();
		Assert.assertEquals(actaulOpportunity, OpportunityData[3]);
		sl.iSleep(5);
		String actualTitle=driver.getTitle();
		String expectedTitle=""+OpportunityData[3]+" - Odoo";
		sl.iSleep(5);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("***************Create Opportunity Verified***************");
	}
	
	public void scheduleActivity() 
	{
		sl.iSleep(5);
		List<WebElement> clocksImg = driver.findElements(By.xpath(pp.clock1));
		sl.iSleep(5);
		clocksImg.get(0).click();
		sl.iSleep(10);
		driver.findElement(By.xpath(pp.scheduleAct)).click();
		sl.iSleep(10);
		driver.findElement(By.xpath(pp.actTypeDrpdwn)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.actTypeDrpdwn)).sendKeys("Meeting");
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.actTypeDrpdwn)).sendKeys(Keys.ENTER);
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.summaryInput)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.summaryInput)).sendKeys(" -Activity");
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.openCalBtn)).click();
		sl.iSleep(5);
		List<WebElement> allDates = driver.findElements(By.xpath(pp.allDates));
		sl.iSleep(5);
		System.out.println("**************"+allDates.size()+"**************");
		sl.iSleep(5);
		int expectedDate = LocalDate.now().plusDays(4).getDayOfMonth();
		String exptDate = Integer.toString(expectedDate);
		for (int i = 0; i <allDates.size() ; i++) 
		{
			String date = allDates.get(i).getText();
			if(date.equalsIgnoreCase(exptDate)) 
			{
				allDates.get(i).click();
				break;
			}
		}
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.dayBtn)).click();
		sl.iSleep(10);
		driver.findElement(By.xpath(pp.timeSlot)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.crtActSummry)).sendKeys("meeting");                                 
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.actCreateBtn)).click();
	}
	
	public void verifyScheduleActivity() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.pipelineTab)).click();
		sl.iSleep(5);
		List<WebElement> clocksImg = driver.findElements(By.xpath(pp.clock1));
		sl.iSleep(5);
		clocksImg.get(0).click();
		sl.iSleep(5);
		String actualActivity = driver.findElement(By.xpath(pp.activityName)).getText();
		String expectedActivity = "Meeting";	
		Assert.assertEquals(actualActivity, expectedActivity);
		System.out.println("***************Schedule Activity Verified***************");
	}
	
	public void dragAnOpportunity(String[] OpportunityData) 
	{ 
		sl.iSleep(5);
		List<WebElement> clocksImg = driver.findElements(By.xpath(pp.clock1));
		sl.iSleep(5);
		clocksImg.get(0).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.doneMark)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(pp.doneBtn)).click();
		sl.iSleep(5);
		List<WebElement> allOpportunities = driver.findElements(By.xpath(pp.allOpprotunities));
		sl.iSleep(5);
		for (WebElement ele : allOpportunities) 
		{
			String customer = ele.getText();
			if(customer.equalsIgnoreCase(OpportunityData[3])) 
			{
				sl.dragAndDropByCoodinate(ele,250,100);
				break;
			}
		}
	}
	
	public void verifyDragedOpportunity(String[] OpportunityData) {}
	public void deleteDragedOpportunity(String[] OpportunityData) {}
	public void verifyDeleteDragedOpportunity(String[] OpportunityData) {}
}