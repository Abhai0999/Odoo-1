package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        sl = new SeleniumLib(driver);
	}
	
	public void clickMenuDrpDwnList()
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(bp.logout)).click();
	}
	
	public void clickCRM()
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(bp.Crm)).click();
	}
	
	public void clickSales()
	{
		sl.iSleep(10);
		driver.findElement(By.xpath(bp.Sales)).click();
		   
	}
	   
	public void clickCustomers()
	{
		sl.iSleep(10);   
		driver.findElement(By.xpath(bp.Customers)).click();  
	}
	
	public void clickConfiguration()
	{
		sl.iSleep(10);   
		driver.findElement(By.xpath(bp.Configuration)).click();  
	}
	
	public void clickSalesTeams()
	{
		sl.iSleep(10);   
		driver.findElement(By.xpath(bp.salesTeamBtn)).click();  
	}
	
}
