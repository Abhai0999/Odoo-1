package com.odoo.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.SalesTeamPage;

public class SalesTeamSteps 
{
	WebDriver driver;
	SalesTeamPage stp;
	SeleniumLib sl;

	public SalesTeamSteps(WebDriver driver)
	{
		this.driver=driver;
		stp=new SalesTeamPage();
		sl=new SeleniumLib(driver);
	}

	public void createSalesTeam(String[] salesTeam)
	{
		
		
			sl.iSleep(5);
			driver.findElement(By.xpath(stp.create)).click();
			sl.iSleep(5);
			
			driver.findElement(By.xpath(stp.salesTeamName)).sendKeys((salesTeam[3]));
			driver.findElement(By.xpath(stp.teamLeader)).click();
			sl.iSleep(5);
			driver.findElement(By.xpath(stp.createEdit)).click();
			sl.iSleep(5);
			WebElement click = driver.findElement(By.xpath(stp.TeamLeaderName));
			sl.iSleep(5);
			click.click();
			sl.iSleep(5);		
			click.sendKeys((salesTeam[4]));		
			sl.iSleep(10);
			driver.findElement(By.xpath(stp.teamLeaderEmail)).sendKeys((salesTeam[5]));
			sl.iSleep(5);
			driver.findElement(By.xpath(stp.teamLeadSave)).click();
			sl.iSleep(10);
			WebElement alise = driver.findElement(By.xpath(stp.aliseName));
			sl.iSleep(10);
			alise.click();
			sl.iSleep(10);
			alise.sendKeys(salesTeam[6]);
			sl.iSleep(5);
			driver.findElement(By.xpath(stp.add)).click();
			sl.iSleep(5);
			WebElement chck1 = driver.findElement(By.xpath(stp.checkbox1));		
			sl.jsClick(chck1);			
			WebElement chck2 = driver.findElement(By.xpath(stp.checkbox2));		
			sl.jsClick(chck2);		
			driver.findElement(By.xpath(stp.selectBtn)).click();		
			driver.findElement(By.xpath(stp.saveBtn)).click();
			sl.iSleep(5);		

			
		
			
		
		


	}
	
	
	
	

	public void verifySalesTeam(String expText,String teamName)
	{
		sl.iSleep(5);
		String actualText = driver.findElement(By.xpath(stp.verifyTeamLead)).getText();		
		Assert.assertEquals(actualText, expText);
		Reporter.log(""+expText+" Verified",true);

		String actualTitle = driver.getTitle();
		String expTitle=""+teamName+" - Odoo";
		Assert.assertEquals(actualTitle, expTitle);
		Reporter.log(""+expTitle+" title Verified",true);
	}
	
	public void dltSalesTeam(String[] salesTeamName)
	{
		List<WebElement> text = driver.findElements(By.xpath(stp.SalesTeam));
		int count = text.size();
		for (int i = 0; i <count; i++) 
		{
			WebElement textLink = text.get(i);
			String actualText = textLink.getText();
			if(actualText.equalsIgnoreCase(salesTeamName[3]))
			{
				textLink.click();
				break;
				
			}
		}
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.action)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.dltBtn)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.confirm)).click();;
	}
	
	
	public void verifyDltSalesTeam(String expSalesTeam)
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.salesTeamBtn)).click();
		
		List<WebElement> salesTeam = driver.findElements(By.xpath(stp.SalesTeam));
		int count = salesTeam.size();
		for (int i = 0; i <count; i++) 
		{
			WebElement teamTextLink = salesTeam.get(i);
			String teamText = teamTextLink.getText();
			Assert.assertNotEquals(teamText, expSalesTeam);;
		}
		Reporter.log("Delete SalesTeam Verified",true);
	}

}
