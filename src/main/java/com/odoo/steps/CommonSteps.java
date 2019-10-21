package com.odoo.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;

public class CommonSteps 
{
	WebDriver driver;
	BasePage bp;
	SeleniumLib sl;
	
	
	public CommonSteps(WebDriver driver)
	{
		this.driver=driver;
		bp=new BasePage();
		sl=new SeleniumLib(driver);
	}
	
	public void clickMenuDrpDwnList()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(bp.logout)).click();
	}
	public void clickOnCRM()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.Crm)).click();	
	}
	public void clickOnSales()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.sales)).click();
	}
	public void clickOncustomers()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.customers)).click();
	}
	public void clickOnCreate()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.create)).click();
	}
	
	public void clickOnSave()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.save)).click();
	}
	public void clickOnConfiguration()
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.configuration)).click();
	}
	public void clickOnSalesTeam()
	{ 
		sl.iSleep(5);
		driver.findElement(By.xpath(bp.salesTeam)).click();
	}
	
	

	
	
}
