package com.odoo.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;

public class CustomerSteps 
{
	WebDriver driver;
	BasePage bp;
	CustomerPage ctp;
	SeleniumLib sl;
	
	public CustomerSteps(WebDriver driver)
	{
		this.driver=driver;
		bp=new BasePage();
		ctp=new CustomerPage();
		sl=new SeleniumLib(driver);
	}
	
	public void createCustomer(String customerName,String [] customerData,String exepath)
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(ctp.create)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(ctp.custName)).sendKeys(customerName);
		driver.findElement(By.xpath(ctp.street)).sendKeys(customerData[4]);
		driver.findElement(By.xpath(ctp.city)).sendKeys(customerData[5]);
		WebElement state = driver.findElement(By.xpath(ctp.state));
		state.sendKeys(customerData[6]);
		state.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(ctp.zip)).sendKeys(customerData[7]);
		driver.findElement(By.xpath(ctp.country)).sendKeys(customerData[8]);
		driver.findElement(By.xpath(ctp.mob)).sendKeys(customerData[9]);
		driver.findElement(By.xpath(ctp.email)).sendKeys(customerData[10]);
		WebElement ele = driver.findElement(By.xpath(ctp.img));
		sl.mouseOver(ele);
		driver.findElement(By.xpath(ctp.edit)).click();
		sl.iSleep(5);
		try {
			Runtime.getRuntime().exec(exepath);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		sl.iSleep(5);
		driver.findElement(By.xpath(ctp.save)).click();
		sl.iSleep(5);
		System.out.println("customer done****************");
	}
	public void deleteCustomer(String customerName)
	{
		sl.iSleep(10);
		List<WebElement> ele = driver.findElements(By.xpath(ctp.customerNames));
		
		for (int i = 0; i < ele.size(); i++) 
		{
			WebElement name = ele.get(i);
			if(name.getText().equalsIgnoreCase(customerName))
			{
				name.click();
				break;
			}
		}
		sl.iSleep(5);
		driver.findElement(By.xpath(ctp.actions)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(ctp.delete)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(ctp.confrmOk)).click();
	}
	

}
