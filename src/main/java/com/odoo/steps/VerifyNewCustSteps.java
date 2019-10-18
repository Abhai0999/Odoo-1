package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.VerifyNewCustPage;

public class VerifyNewCustSteps 
{
	WebDriver driver;

	VerifyNewCustPage vncp;
	SeleniumLib sl;

	public VerifyNewCustSteps(WebDriver driver)

	{
		this.driver=driver;
		vncp=new VerifyNewCustPage();
		sl=new SeleniumLib(driver);

	}

	public void verifyCustomer(String userName)
	{
		sl.iSleep(3);
		String actual = driver.findElement(By.xpath(vncp.newCustName)).getText();
		Assert.assertEquals(actual, userName);

	}

	public void verifyTitle(String custName )
	{
		String actualTitle = driver.getTitle();
		String expTitle=""+custName+" - Odoo";		
		Assert.assertEquals(actualTitle, expTitle);		

	}

}
