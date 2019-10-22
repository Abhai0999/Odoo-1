package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.LostReasonPage;

public class LostReasonSteps
{
    WebDriver driver;
    BasePage bp;
	SeleniumLib sl;
	LostReasonPage lrp;
	
	public LostReasonSteps(WebDriver driver)
	{
		this.driver = driver;
		bp=new BasePage();
		sl=new SeleniumLib(driver);
		lrp= new LostReasonPage();
	}
	
	public void createLostReason()
	{
		sl.iSleep(3);
		driver.findElement(By.xpath(lrp.create)).click();
		sl.iSleep(3);
		driver.findElement(By.xpath(lrp.inputBtn)).sendKeys("out of stock");
		sl.iSleep(3);
		
		driver.findElement(By.xpath(lrp.save)).click();
		
	}
	
	public void verifyLostName()
	{
//         sl.iSleep(2);
	    String lstText = driver.findElement(By.xpath(lrp.lstr)).getText();
		sl.iSleep(2);
		driver.findElement(By.xpath(lrp.gotoLost)).click();
		sl.iSleep(3);
		String lostname = driver.findElement(By.xpath(lrp.verifylost)).getText();
		System.out.println(lostname);
		sl.iSleep(2);
    	Assert.assertEquals(lstText,lostname);
		System.out.println("lost reason is verified");
		
		
		
		
		
		
	}
	
	
}
