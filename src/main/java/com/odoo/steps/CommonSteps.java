package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.odoo.pageobjects.BasePage;

public class CommonSteps 
{
	WebDriver driver;
	BasePage bp;
	
	public CommonSteps(WebDriver driver)
	{
		this.driver=driver;
		bp=new BasePage();
	}
	
	public void clickMenuDrpDwnList()
	{
		driver.findElement(By.xpath(bp.menuDrpDwnList)).click();
	}
	
	public void clickLogout()
	{
		driver.findElement(By.xpath(bp.logout)).click();
	}
	
}
