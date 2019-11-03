package com.odoo.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.CustomerPage;

public class CustomerSteps 
{
	WebDriver driver;
	CustomerPage cp;
	SeleniumLib sl;

	public CustomerSteps(WebDriver driver) 
	{
		this.driver=driver;
		cp=new CustomerPage();
		sl=new SeleniumLib(driver);
	}

	
	public void createCustomer(String[] CustomerData) 
	{
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.createBtn)).click();
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.customerName)).sendKeys(CustomerData[3]);
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.streetName)).sendKeys(CustomerData[4]);
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.cityName)).sendKeys(CustomerData[5]);
			sl.iSleep(5);
			WebElement state = driver.findElement(By.xpath(cp.stateName));
			sl.iSleep(5);
			state.sendKeys(CustomerData[6]);
			state.sendKeys(Keys.ARROW_DOWN);
			state.sendKeys(Keys.ENTER);
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.zipCode)).sendKeys(CustomerData[7]);
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.countryName)).sendKeys(CustomerData[8]);
			sl.iSleep(2);
			driver.findElement(By.xpath(cp.phoneNo)).sendKeys(CustomerData[9]);
			sl.iSleep(2);
			driver.findElement(By.xpath(cp.emailID)).sendKeys(CustomerData[10]);
			sl.iSleep(2);
			driver.findElement(By.xpath(cp.image)).click();
			sl.iSleep(2);
			driver.findElement(By.xpath(cp.pencil)).click();
			sl.iSleep(2);
			try 
			{
				Runtime.getRuntime().exec("./Resource/Clair.exe");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			sl.iSleep(10);
			driver.findElement(By.xpath(cp.saveBtn)).click();
	}
	public void VerifyCrtCustomer(String[] customerData) 
	{
		sl.iSleep(5);
		String actualName = driver.findElement(By.xpath(cp.newCustName)).getText();
		String actualTitle = driver.getTitle();
		String expectedTitle = ""+customerData[3]+" - Odoo"; 
		System.out.println(actualName+"*-*-*"+customerData[3]+"*-*-*"+actualTitle+"*-*-*"+expectedTitle);
		sl.iSleep(5);
		Assert.assertEquals(actualName, customerData[3]);
		sl.iSleep(5);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("***************Create Customer Verified***************");
	}
	public void deleteCustomer(String[] customerData) 
	{
		sl.iSleep(5);
		List<WebElement> custNames = driver.findElements(By.xpath(cp.allCustomers));
		for (WebElement ele : custNames) 
		{
			String name = ele.getText();
			if(name.equalsIgnoreCase(customerData[3])) 
			{
				System.out.println("*****************"+customerData[3]+"*****************");
				ele.click();
				break;
			}	
		}
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.actinDrpDwn)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.deleteBtn)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.OkBtn)).click();
	}
	public void VerifyDltCustomer(String[] customerData) 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.customersTab)).click();
		List<WebElement> allCustNames = driver.findElements(By.xpath(cp.allCustomers));
		for (WebElement ele : allCustNames) 
		{
			String actualName = ele.getText();
			Assert.assertNotEquals(actualName, customerData[3]);		
		}
		System.out.println("***************Delete Customer Verified***************");
	}
}