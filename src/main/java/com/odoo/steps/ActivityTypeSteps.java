package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.ActivityTypePage;

public class ActivityTypeSteps 
{
	WebDriver driver;
	SeleniumLib sl;
	ActivityTypePage atp;
	
	public ActivityTypeSteps(WebDriver driver) 
	{
		this.driver=driver;
		sl= new SeleniumLib();
		atp= new ActivityTypePage();
	}

	public void createActivityType(String[] activityData) 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(atp.createTab)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(atp.nameInput)).sendKeys(activityData[3]);
		sl.iSleep(5);
		WebElement actToPreDrpDwn = driver.findElement(By.xpath(atp.actToPrefDrpDwn));
		sl.selectDrpDwnOption(actToPreDrpDwn, 1);
		sl.iSleep(5);
		WebElement defaultUserDrpDwn = driver.findElement(By.xpath(atp.defaultUserDrpDwn));
		sl.selectDrpDwnOption(defaultUserDrpDwn, activityData[4]);
		sl.iSleep(5);
		driver.findElement(By.xpath(atp.saveBtn)).click();
	}
	
	public void verifyActivityType(String[] activityData) 
	{
		sl.iSleep(5);
		String actualActivityName = driver.findElement(By.xpath(atp.activityName)).getText();
		String actualActivityTitle = driver.getTitle();
		String expectedActivityTitle=""+activityData[3]+" - Odoo";
		Assert.assertEquals(actualActivityName, activityData[3]);
		Assert.assertEquals(actualActivityTitle, expectedActivityTitle);
		System.out.println("*****************************ActivityType is Verified*******************************");
	}
}
