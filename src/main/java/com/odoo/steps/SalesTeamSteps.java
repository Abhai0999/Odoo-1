package com.odoo.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
		sl=new SeleniumLib();
	}

	public void clickCreate() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.createBtn)).click();
	}
	public void createSalesTeam(String[] salesTeamData) 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.salesTeamNam)).sendKeys(salesTeamData[3]);
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.teamLeaderNam)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.clkAndEdt)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.teamLeadNam)).sendKeys(salesTeamData[4]);
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.teanLeadEmail)).sendKeys(salesTeamData[5]);
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.teamLeadSaveBtn)).click();
		sl.iSleep(10);
		WebElement email = driver.findElement(By.xpath(stp.email));
		email.click();
		email.sendKeys(salesTeamData[6]);
		sl.iSleep(10);
		WebElement saveBTN = driver.findElement(By.xpath(stp.saveBtn));
		saveBTN.click();
	}
	public void verifyCrtSalesTeam(String[] salesTeamData) 
	{ 
		sl.iSleep(5);
		String actualName = driver.findElement(By.xpath(stp.salesTeamName)).getText();
		sl.iSleep(5);
		String actualTitle = driver.getTitle();
		String expectedTitle = ""+salesTeamData[3]+" - Odoo";
		System.out.println(actualName+"*-*-*"+salesTeamData[3]+"*-*-*"+actualTitle+"*-*-*"+expectedTitle);
		Assert.assertEquals(actualName, salesTeamData[3]);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("***************Create SalesTeam Verified***************");
	}
	public void deleteSalesTeam(String[] salesTeamData) 
	{
		sl.iSleep(10);
		WebElement saleTeam = driver.findElement(By.xpath(stp.salesTeamTab));
		saleTeam.click();
		sl.iSleep(10);
		List<WebElement> allSalesTeams = driver.findElements(By.xpath(stp.allSalesTeam));
		for (WebElement ele : allSalesTeams) 
		{
			String salesTeamName = ele.getText();
			if(salesTeamName.equalsIgnoreCase(salesTeamData[3]))
			{
				System.out.println("*****************"+salesTeamData[3]+"*****************");
				ele.click();
				break;
			}
		}
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.actionDrpDwn)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.deleteBtn)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.okBtn)).click();
	}
	public void verifyDltSalesTeam(String[] salesTeamData) 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(stp.salesTeamTab)).click();
		sl.iSleep(5);
		List<WebElement> salesTeamName = driver.findElements(By.xpath(stp.allSalesTeam));
		for (WebElement ele : salesTeamName) 
		{
			String actualName = ele.getText();
			Assert.assertNotEquals(actualName, salesTeamData[3]);			
		}
		System.out.println("***************Delete SaleTeam Verified***************");
	}
}