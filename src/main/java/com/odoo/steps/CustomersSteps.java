package com.odoo.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.CustomersPage;


public class CustomersSteps 
{
	WebDriver driver;
	CustomersPage cp;
	SeleniumLib sl;

	public CustomersSteps(WebDriver driver)
	{
		this.driver=driver;
		cp=new CustomersPage();
		sl=new SeleniumLib(driver);
	}
	
	public void clickCreate()
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.create)).click();
	}
	
	public void createCustomer(String[] customerData)
	{
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.nameTxtBX)).sendKeys(customerData[3]);
		driver.findElement(By.xpath(cp.streetTxtBx)).sendKeys(customerData[4]);
		driver.findElement(By.xpath(cp.cityTxtBx)).sendKeys(customerData[5]);
		WebElement state = driver.findElement(By.xpath(cp.stateTxtBx));
		state.sendKeys(customerData[6]);
	//	state.sendKeys(Keys.ARROW_DOWN);
		sl.iSleep(5);
		state.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(cp.zipTxtBx)).sendKeys(customerData[7]);
		driver.findElement(By.xpath(cp.countryTxtBx)).sendKeys(customerData[8]);
		driver.findElement(By.xpath(cp.mobTxtBx)).sendKeys(customerData[9]);
		driver.findElement(By.xpath(cp.emailTxtBx)).sendKeys(customerData[10]);
		driver.findElement(By.xpath(cp.image));
		driver.findElement(By.xpath(cp.edit)).click();
		sl.iSleep(6);
		try 
		{
			Runtime.getRuntime().exec("./Resources/uploaded.exe");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			
		}
		sl.iSleep(10);
		driver.findElement(By.xpath(cp.saveBtn)).click();
		sl.iSleep(10);
	}	
	
	public void deleteCustomer(String customersData)
	{ 
		sl.iSleep(5);
		
		List<WebElement> custName = driver.findElements(By.xpath(cp.CustomersName));
		int count = custName.size();
		System.out.println("Total cust: "+count);
		for(int i=0; i<count; i++)
		{
			WebElement ele = custName.get(i);
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase(customersData))
			{
		//		System.out.println("-----+name+-----");
		//		System.out.println("-----+customersData+-----");
				ele.click();
				break;
			}
		}
	sl.iSleep(4);
	driver.findElement(By.xpath(cp.actionDrpDwnlist)).click();
	driver.findElement(By.xpath(cp.deleteBtn)).click();
	sl.iSleep(6);
	driver.findElement(By.xpath(cp.okBtn)).click();
	
	}
	
/*	public void verifyCustName(String customerName)
	{
		String actualCustName = driver.findElement(By.xpath(cp.verifyCustName)).getText();
		System.out.println("*******"+actualCustName);
		Assert.assertEquals(actualCustName, customerName);
		
		
	}
	*/
	
}
	