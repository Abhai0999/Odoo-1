package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;

public class CommonSteps 
{
	WebDriver driver;
	BasePage bp;
	SeleniumLib sl;
	CustomerPage cp;
	public CommonSteps(WebDriver driver)
	{
		this.driver=driver;
		bp=new BasePage();
		sl=new SeleniumLib(driver);
		cp=new CustomerPage();
	}
	
	public void clickMenuDrpDwnList()
	{
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	{
		driver.findElement(By.xpath(bp.logout)).click();
	}

	public void clickCrm() {
		driver.findElement(By.xpath(bp.Crm)).click();
		sl.eWaitForVisiblity(20, bp.Sales);
		
		
	}
	public void clickSales() {
		driver.findElement(By.xpath(bp.Sales)).click();
		sl.eWaitForVisiblity(20, bp.Customer);
	}
	public void clickCust() {
		driver.findElement(By.xpath(bp.Customer)).click();
		//sl.eWaitForVisiblity(20, cp.Create);
		sl.iSleep(4);
	}
	
}
