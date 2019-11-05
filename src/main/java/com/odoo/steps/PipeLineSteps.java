package com.odoo.steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.PipeLinePage;

public class PipeLineSteps 
{
	WebDriver driver;
	PipeLinePage plp;
	SeleniumLib sl;

	public PipeLineSteps(WebDriver driver)
	{
		this.driver=driver;
		plp=new PipeLinePage();
		sl=new SeleniumLib(driver);
	}

	public void createOpportunity(String[] opportunity,String[] customer)
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(plp.create)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(plp.opportunityText)).sendKeys(opportunity[3]);
		sl.iSleep(5);
		driver.findElement(By.xpath(plp.custText)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(plp.search)).click();
		sl.iSleep(5);
		List<WebElement> allCust = driver.findElements(By.xpath(plp.addCst));
		
		int count = allCust.size();
		
		for (int i = 0; i<count; i++) 
		{
			WebElement custLink = allCust.get(i);
			String custText = custLink.getText();
			if(custText.equalsIgnoreCase(customer[3]))
			{
				
				sl.jsClick(custLink);
				break;

			}
		}

		sl.iSleep(3);
		WebElement click = driver.findElement(By.xpath(plp.expRev));
		WebElement click1 = sl.prescenceOfElementWait(20, plp.expRev);
		sl.jsClick(click1);		
		sl.jsClick(click);				
		WebElement clear = sl.eWaitForVisiblity(30,click);
		clear.clear();
		WebElement data = sl.eWaitForVisiblity(30,click);		
		data.sendKeys(opportunity[5]);		
		driver.findElement(By.xpath(plp.addBtn)).click();

	}

	public void verifyOpportunity(String[] expected )
	{
		sl.iSleep(5);
		List<WebElement> alloptions = driver.findElements(By.xpath(plp.verifyOpportunity));
		int count = alloptions.size();

		for (int i = 0; i <count; i++) 
		{
			WebElement getLink = alloptions.get(i);
			String actual = getLink.getText();			
			if(actual.equalsIgnoreCase(expected[3]))
			{			
				Assert.assertEquals(actual, expected[3]);
				Reporter.log(expected[3] + " Opportunity is verifyied",true);
				break;
			}

		}

	}

	public void deleteOpportunity(String[] opportunityName)
	{
		List<WebElement> alloptions = driver.findElements(By.xpath(plp.createdOpportunity));
		for (WebElement ele : alloptions) 
		{
			String optionText = ele.getText();
			if(optionText.equalsIgnoreCase(opportunityName[3]))
			{
				ele.click();
			}
		}
		sl.iSleep(3);
		driver.findElement(By.xpath(plp.action)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(plp.delete)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(plp.deleteConfirmation)).click();
	}


	public void verifyDltOpportunity(String[] opportunityName)
	{
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.clickPipeline)).click();
		List<WebElement> alloptions = driver.findElements(By.xpath(plp.createdOpportunity));
		for (WebElement ele : alloptions) 
		{
			String optionsText = ele.getText();
			if(optionsText.equalsIgnoreCase(opportunityName[3]))
			{
				Assert.assertNotEquals(optionsText, opportunityName[3]);
				Reporter.log("verify delete Opportunity",true);

			}

		}

	}



	public void schdMeetingAct(String[] activityType)
	{		
		sl.iSleep(5);
		List<WebElement> ele = driver.findElements(By.xpath(plp.clock));
		ele.get(0).click();
		sl.iSleep(5);
		WebElement activityClick = driver.findElement(By.xpath(plp.activity));
		sl.jsClick(activityClick);
		sl.iSleep(10);
		WebElement activityDrpDwn = driver.findElement(By.xpath(plp.activityType));	
		sl.jsClick(activityDrpDwn);
		//activityDrpDwn.click();
		sl.iSleep(5);
		activityDrpDwn.sendKeys(activityType[3]);
		sl.iSleep(5);
		activityDrpDwn.sendKeys(Keys.ENTER);
		sl.iSleep(5);
		driver.findElement(By.xpath(plp.actSummury)).sendKeys(activityType[4]);
		driver.findElement(By.xpath(plp.openCalander)).click();		
		int expDate = LocalDate.now().plusDays(2).getDayOfMonth();
		String dateString = Integer.toString(expDate);		
		sl.iSleep(5);		
		List<WebElement> alldate= driver.findElements(By.xpath(plp.selectdate));
		sl.iSleep(5);
		int count = alldate.size();		 
		for (int i = 0; i < count; i++)  
		{
			WebElement text = alldate.get(i);
			String text1 = text.getText();

			if(text1.equalsIgnoreCase(dateString))
			{	
				sl.jsClick(text);
				break;
			}
		}

		sl.iSleep(3);
		driver.findElement(By.xpath(plp.actdayWise)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(plp.time)).click();
		sl.iSleep(3);		 
		driver.findElement(By.xpath(plp.creatActBtn)).click();	

	}

	public void verfschdMeetingAct(String[]expected,String[] opportunity)
	{
		sl.iSleep(3);
		driver.findElement(By.xpath(plp.clickPipeline)).click();
		sl.iSleep(3);
		List<WebElement> alloptions = driver.findElements(By.xpath(plp.verifyOpportunity));
		int count = alloptions.size();
		for (int i = 0; i <count; i++) 
		{
			WebElement link = alloptions.get(i);

			String text = link.getText();

			if (text.equalsIgnoreCase(opportunity[3])) 
			{
				link.click();
				sl.iSleep(3);
				String actual = driver.findElement(By.xpath(plp.verifySchdAct)).getText();		
				sl.iSleep(3);
				Assert.assertEquals(actual, expected[8]);		
				Reporter.log(expected[3] + "is Verifyied",true);
				break;
			}
		}		

	}

	public void MeetingActivityDone(String[] data)
	{
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.clickPipeline)).click();
		sl.iSleep(2);
		List<WebElement> ele = driver.findElements(By.xpath(plp.clock));
		ele.get(0).click();
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.markDone)).click();
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.feedBack)).sendKeys(data[5]);
		sl.iSleep(2);
		WebElement actDone = driver.findElement(By.xpath(plp.actCnfBtn));		
		sl.jsClick(actDone);
	}

	public void verifyMeetingActDone(String[] expected)
	{
		sl.iSleep(2);
		List<WebElement> ele = driver.findElements(By.xpath(plp.clock));
		ele.get(0).click();
		sl.iSleep(2);
		String actualText = driver.findElement(By.xpath(plp.verifyActdone)).getText();		
		Assert.assertEquals(actualText, expected[9]);
		Reporter.log(expected[9] + "for this opportunity",true);
	}
	public void dragOpportunityNewToQualified(String[] opportunity )
	{
		sl.iSleep(2);
		List<WebElement> allOptions = driver.findElements(By.xpath(plp.verifyOpportunity));
		int count = allOptions.size();
		for(int i=0;i<count;i++)
		{
			WebElement optionsLink = allOptions.get(i);
			String linkText = optionsLink.getText();

			if(linkText.equalsIgnoreCase(opportunity[3]))
			{
				sl.dragAndDrop(optionsLink,250, 100);
			}
		}

	}

	public void verifyDragOpportunityToQlfd(String[]expected)
	{
		sl.iSleep(2);
		List<WebElement> opportunity = driver.findElements(By.xpath(plp.verifyQualifiedOpp));		
		for (int i = 0; i < opportunity.size(); i++) 
		{
			WebElement link = opportunity.get(i);
			String actual = link.getText();			
			if(actual.equalsIgnoreCase(expected[3]))				
			{				
				Assert.assertEquals(actual, expected[3]);
				Reporter.log("Qualified " + expected[3] + " is verified",true);
				break;
			}

		}

	}

	public void creatCallAct(String[]activityType )
	{
		sl.iSleep(5);
		List<WebElement> ele = driver.findElements(By.xpath(plp.qualifiedClock));
		ele.get(0).click();
		sl.iSleep(5);
		WebElement activityClick = driver.findElement(By.xpath(plp.activity));
		sl.jsClick(activityClick);
		sl.iSleep(5);
		WebElement activityDrpDwn = driver.findElement(By.xpath(plp.activityType));	
		activityDrpDwn.click();
		sl.iSleep(5);
		activityDrpDwn.sendKeys(activityType[3]);
		sl.iSleep(5);
		activityDrpDwn.sendKeys(Keys.ENTER);
		sl.iSleep(5);
		driver.findElement(By.xpath(plp.actSummury)).sendKeys(activityType[4]);
		sl.iSleep(3);
		WebElement dueDate = driver.findElement(By.xpath(plp.dueDate));
		sl.iSleep(3);
		dueDate.clear();
		LocalDate date = LocalDate.now().plusDays(2);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String text = date.format(formatters);
		dueDate.sendKeys(text);
		WebElement assigned = driver.findElement(By.xpath(plp.assignTo));
		assigned.clear();
		assigned.sendKeys(activityType[6]);
		assigned.sendKeys(Keys.ENTER);		
		driver.findElement(By.xpath(plp.scheduledBtn)).click();


	}

	public void verifyCreatCallAct(String[]opportunity,String[] expected)
	{
		sl.iSleep(3);
		List<WebElement> alloptions = driver.findElements(By.xpath(plp.verifyOpportunity));
		int count = alloptions.size();

		for (int i = 0; i <count; i++) 
		{
			WebElement link = alloptions.get(i);
			String text = link.getText();
			if (text.equalsIgnoreCase(opportunity[3])) 
			{

				link.click();
				sl.iSleep(3);
				String actual = driver.findElement(By.xpath(plp.verifySchdAct)).getText();		
				sl.iSleep(3);
				Assert.assertEquals(actual, expected[7]);		
				Reporter.log(expected[3] + " Activity is Verifyied",true);
				break;
			}
		}

	}
	
	public void callActDone(String[] data )
	{
		
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.clickPipeline)).click();
		sl.iSleep(2);
		List<WebElement> ele = driver.findElements(By.xpath(plp.qualifiedClock));
		ele.get(0).click();
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.markDone)).click();
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.feedBack)).sendKeys(data[8]);
		sl.iSleep(2);
		WebElement actDone = driver.findElement(By.xpath(plp.actCnfBtn));		
		sl.jsClick(actDone);
		
	}
	
	public void VerifyCallActDone(String[] expected )
	{
		sl.iSleep(2);
		List<WebElement> ele = driver.findElements(By.xpath(plp.qualifiedClock));
		ele.get(0).click();
		sl.iSleep(2);
		String actualText = driver.findElement(By.xpath(plp.verifyActdone)).getText();		
		Assert.assertEquals(actualText, expected[9]);
		Reporter.log(expected[9] + "for this opportunity",true);
		
	}
	
	public void dragOpprQualfdToPrep(String[] opportunity)
	{
		sl.iSleep(2);
		List<WebElement> allOptions = driver.findElements(By.xpath(plp.verifyOpportunity));
		int count = allOptions.size();
		for(int i=0;i<count;i++)
		{
			WebElement optionsLink = allOptions.get(i);
			String linkText = optionsLink.getText();

			if(linkText.equalsIgnoreCase(opportunity[3]))
			{
				sl.dragAndDrop(optionsLink,250, 100);
			}
		}
	}
	
	public void verifydragOpprQualfdToPrep(String[] expected)
	{
		sl.iSleep(2);
		List<WebElement> opportunity = driver.findElements(By.xpath(plp.verifyPropositionOpp));		
		for (int i = 0; i < opportunity.size(); i++) 
		{
			WebElement link = opportunity.get(i);
			String actual = link.getText();			
			if(actual.equalsIgnoreCase(expected[3]))				
			{				
				Assert.assertEquals(actual, expected[3]);
				Reporter.log("Proposition " + expected[3] + " is verified",true);
				break;
			}

		}
		
	}
	
	public void createEmailAct(String[] activityType )
	{
		sl.iSleep(3);
		List<WebElement> ele = driver.findElements(By.xpath(plp.PropositioClock));
		ele.get(0).click();
		sl.iSleep(3);
		WebElement activityClick = driver.findElement(By.xpath(plp.activity));
		sl.jsClick(activityClick);
		sl.iSleep(5);
		WebElement activityDrpDwn = driver.findElement(By.xpath(plp.activityType));	
		activityDrpDwn.click();
		sl.iSleep(5);
		activityDrpDwn.sendKeys(activityType[3]);
		sl.iSleep(5);
		activityDrpDwn.sendKeys(Keys.ENTER);
		sl.iSleep(5);
		driver.findElement(By.xpath(plp.actSummury)).sendKeys(activityType[4]);
		sl.iSleep(5);
		WebElement dueDate = driver.findElement(By.xpath(plp.dueDate));
		sl.iSleep(5);
		dueDate.clear();
		LocalDate date = LocalDate.now().plusDays(4);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String text = date.format(formatters);
		dueDate.sendKeys(text);
		WebElement assigned = driver.findElement(By.xpath(plp.assignTo));
		assigned.clear();
		assigned.sendKeys(activityType[5]);
		assigned.sendKeys(Keys.ENTER);		
		driver.findElement(By.xpath(plp.scheduledBtn)).click();
		
	}
	
	public void verifyCreatEmailAct(String[] opportunity,String[] expected )
	{
		sl.iSleep(3);
		List<WebElement> alloptions = driver.findElements(By.xpath(plp.verifyOpportunity));
		int count = alloptions.size();

		for (int i = 0; i <count; i++) 
		{
			WebElement link = alloptions.get(i);
			String text = link.getText();
			if (text.equalsIgnoreCase(opportunity[3])) 
			{

				link.click();
				sl.iSleep(3);
				String actual = driver.findElement(By.xpath(plp.verifySchdAct)).getText();		
				sl.iSleep(3);
				Assert.assertEquals(actual, expected[6]);		
				Reporter.log(expected[3] + " Activity is Verifyied",true);
				break;
			}
		}
		
	}
	
	public void EmailActDone(String[] data)
	{
		
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.clickPipeline)).click();
		sl.iSleep(2);
		List<WebElement> ele = driver.findElements(By.xpath(plp.PropositioClock));
		ele.get(0).click();
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.markDone)).click();
		sl.iSleep(2);
		driver.findElement(By.xpath(plp.feedBack)).sendKeys(data[7]);
		sl.iSleep(2);
		WebElement actDone = driver.findElement(By.xpath(plp.actCnfBtn));		
		sl.jsClick(actDone);
	}
	
	public void verifyEmailActDone(String[] expected )
	{
		sl.iSleep(2);
		List<WebElement> ele = driver.findElements(By.xpath(plp.PropositioClock));
		ele.get(0).click();
		sl.iSleep(2);
		String actualText = driver.findElement(By.xpath(plp.verifyActdone)).getText();		
		Assert.assertEquals(actualText, expected[8]);
		Reporter.log(expected[8] + "for this opportunity",true);
		
	}
	
	public void dragOpprPrepToWon(String[] opportunity )
	{
		sl.iSleep(2);
		List<WebElement> allOptions = driver.findElements(By.xpath(plp.verifyOpportunity));
		int count = allOptions.size();
		for(int i=0;i<count;i++)
		{
			WebElement optionsLink = allOptions.get(i);
			String linkText = optionsLink.getText();

			if(linkText.equalsIgnoreCase(opportunity[3]))
			{
				sl.dragAndDrop(optionsLink,250, 100);
			}
		}
		
	}
	public void verifydragOpprPrepToWon(String[] expected )
	{
		sl.iSleep(2);
		List<WebElement> opportunity = driver.findElements(By.xpath(plp.verifyWonOpportunity));		
		for (int i = 0; i < opportunity.size(); i++) 
		{
			WebElement link = opportunity.get(i);
			String actual = link.getText();			
			if(actual.equalsIgnoreCase(expected[3]))				
			{				
				Assert.assertEquals(actual, expected[3]);
				Reporter.log("Won " + expected[3] + " is verified",true);
				break;
			}

		}
	}

}














