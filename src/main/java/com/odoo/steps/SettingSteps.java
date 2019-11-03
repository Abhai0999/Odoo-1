package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.SettingPage;

public class SettingSteps 
{
	WebDriver driver;
	SettingPage sp;
	SeleniumLib sl;

	public SettingSteps(WebDriver driver) 
	{
		this.driver=driver;
		sp=new SettingPage();
		sl=new SeleniumLib();
	}

	public void clickGeneralSetting() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(sp.generalSett)).click();
	}
	public void clickMngUser() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(sp.mngUsers)).click();
	}
	public void createUser(String[] userData) 
	{
		for (int i = 0; i < 4; i++) 
		{
			sl.iSleep(5);
			driver.findElement(By.xpath(sp.createBtn)).click();
			sl.iSleep(5);
			driver.findElement(By.xpath(sp.userName)).sendKeys(userData[i+2]);
			sl.iSleep(5);
			driver.findElement(By.xpath(sp.usserEmail)).sendKeys(userData[i+2]+"@hiTect.com");
			sl.iSleep(5);
			WebElement saleDrpDwn = driver.findElement(By.xpath(sp.saleDrpDwn));
			sl.iSleep(5);
			sl.selectDrpDwnOption(saleDrpDwn, "User: Own Documents Only");
			sl.iSleep(5);
			WebElement adminDrpDwn = driver.findElement(By.xpath(sp.adminDrpdwn));
			sl.iSleep(5);
			sl.selectDrpDwnOption(adminDrpDwn, "Access Rights");
			sl.iSleep(5);
			driver.findElement(By.xpath(sp.saveBtn)).click();
			sl.iSleep(10);
		}
	}
}