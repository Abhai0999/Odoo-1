package com.odoo.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.PipelinePage;

public class PipelineSteps
{
	WebDriver driver;
	PipelinePage pp;
	SeleniumLib sl;
	
	
	public PipelineSteps(WebDriver driver)
	{
		this.driver=driver;
		pp=new PipelinePage();
		sl=new SeleniumLib(driver);
	}
    public void clickOnCreate()
	{
    	sl.iSleep(5);
		driver.findElement(By.xpath(pp.create)).click();
	}
	
public void createOppotunity(String oppName,String exprevenue,String customerName)
{
	 sl.iSleep(5);
	 driver.findElement(By.xpath(pp.oppName)).sendKeys(oppName);
	 WebElement custEle = driver.findElement(By.xpath(pp.custName));
	 custEle.sendKeys(customerName);
	 sl.iSleep(5);
	 custEle.sendKeys(Keys.ENTER);
	 sl.iSleep(5);
	 WebElement revenueEle = driver.findElement(By.xpath(pp.expRevenue));
	 revenueEle.clear();
	 revenueEle.sendKeys(exprevenue);
	 sl.iSleep(5);
	 driver.findElement(By.xpath(pp.add)).click();
	
}
public void veriOppoNames(String opptName)
{
	sl.iSleep(5);
	List<WebElement> optEles = driver.findElements(By.xpath(pp.OppNames));
	int count = optEles.size();
	for (int i = 0; i < count; i++)
	{
	    	WebElement optName = optEles.get(i);
	    	if(optName.getText().equalsIgnoreCase(opptName))
	    	{
	    		Reporter.log(opptName+" Create successfully done.",true);
	    		break;
	    	}
	    	else
	    	{
	    		Assert.assertEquals("actual", opptName);
	    	}
	}

	
}
	

}
