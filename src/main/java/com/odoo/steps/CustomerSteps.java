package com.odoo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomersPage;

public class CustomerSteps 
{
	WebDriver driver;
	SeleniumLib sl;
	CustomersPage cp;
	
	public CustomerSteps(WebDriver driver)
	{
		this.driver=driver;
		sl=new SeleniumLib(driver);
		cp=new CustomersPage();
	}
	
	public void clickCreate()
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.create)).click();
//		sl.jsClick(driver.findElement(By.xpath(cp.create)));
	}
	
	public void createCustomer(String[] customerData)
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.customerName)).sendKeys(customerData[3]);
		driver.findElement(By.xpath(cp.street)).sendKeys(customerData[4]);
		driver.findElement(By.xpath(cp.city)).sendKeys(customerData[5]);
		WebElement state = driver.findElement(By.xpath(cp.state));
		state.sendKeys(customerData[6]);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(cp.zip)).sendKeys(customerData[7]);
		driver.findElement(By.xpath(cp.country)).sendKeys(customerData[8]);
		driver.findElement(By.xpath(cp.mobileNumber)).sendKeys(customerData[9]);
		driver.findElement(By.xpath(cp.email)).sendKeys(customerData[10]);
		driver.findElement(By.xpath(cp.save)).click();
	}
	
}
