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
	public void clickCreate() 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.createBtn)).click();
	}

	public void createCustomer(String[] CustomerData) 
	{

		WebElement name = sl.explicitlyWait(cp.customerName);
		name.sendKeys(CustomerData[3]);

		WebElement street = sl.explicitlyWait(cp.streetName);
		street.sendKeys(CustomerData[4]);

		WebElement city = sl.explicitlyWait(cp.cityName);
		city.sendKeys(CustomerData[5]);

		WebElement state= sl.explicitlyWait(cp.stateName);
		state.sendKeys(CustomerData[6]);
		state.sendKeys(Keys.ARROW_DOWN);
		state.sendKeys(Keys.ENTER);

		WebElement zip= sl.explicitlyWait(cp.zipCode);
		zip.sendKeys(CustomerData[7]);

		WebElement conutry = sl.explicitlyWait(cp.countryName);
		conutry.sendKeys(CustomerData[8]);

		WebElement phone = sl.explicitlyWait(cp.phoneNo);
		phone.sendKeys(CustomerData[9]);

		WebElement email = sl.explicitlyWait(cp.emailID);
		email.sendKeys(CustomerData[10]);

		WebElement image = sl.explicitlyWait(cp.image);
		image.click();

		WebElement pencil = sl.explicitlyWait(cp.pencil);
		pencil.click();

		sl.iSleep(5);

		try 
		{
			Runtime.getRuntime().exec("./Resource/image.exe");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		sl.iSleep(5);

		WebElement save = sl.explicitlyWait(cp.saveBtn);
		sl.iSleep(5);
		save.click();
	}
	public void VerifyCrtCust(String[] customerData) 
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
		List<WebElement> custNames = driver.findElements(By.xpath(cp.customers));
		System.out.println("*****************"+custNames.size()+"*****************");
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
	public void VerifyDltCust(String[] customerData) 
	{
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.customersTab)).click();
		List<WebElement> custNames = driver.findElements(By.xpath(cp.customers));
		for (WebElement ele : custNames) 
		{
			String actualName = ele.getText();
			Assert.assertNotEquals(actualName, customerData[3]);		
		}
		System.out.println("***************Delete Customer Verified***************");
	}
}