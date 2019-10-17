package com.odoo.steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
		driver.findElement(By.xpath(cp.createBtn)).click();
	}
		
		
//		public String custName(String[] customerData )
//		{
//			String NewCustomerName = "'"+customerData+""+"-"+"'{0}";
//
//			driver.findElement(By.xpath(cp.custNameTxtBx)).sendKeys(sl.randomNumber("'"+customerData[3]+""+"-"+"'{0}"));
//
//			return NewCustomerName;
//
//		}
		
		public void  createCustomer(String[] customerData)
		{
			sl.iSleep(3);
			driver.findElement(By.xpath(cp.custNameTxtBx)).sendKeys(sl.randomNumber("'"+customerData[3]+""+"-"+"'{0}"));
			//sendKeys(sl.randomNumber("'"+customerData[3]+""+"-"+"'{0}"))
			driver.findElement(By.xpath(cp.streetTxtBx)).sendKeys(customerData[4]);
			driver.findElement(By.xpath(cp.cityTxtBx)).sendKeys(customerData[5]);
			WebElement state = driver.findElement(By.xpath(cp.stateTxtBx));
			state.sendKeys(customerData[6]);			
			state.sendKeys(Keys.ENTER);
			driver.findElement(By.xpath(cp.zipTxtbx)).sendKeys(customerData[7]);
			driver.findElement(By.xpath(cp.countryTxtBx)).sendKeys(customerData[8]);
			driver.findElement(By.xpath(cp.mobTxtBx)).sendKeys(customerData[9]);
			driver.findElement(By.xpath(cp.emailTxtBx)).sendKeys(customerData[10]);
			
			driver.findElement(By.xpath(cp.image)).click();
			sl.iSleep(5);
			try {
				Runtime.getRuntime().exec("./resource/image1.exe");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			sl.iSleep(10);
			driver.findElement(By.xpath(cp.saveBtn)).click();
			
		}
		
		
		public void dltCustomer(String[] customerData1)
		
		{
			sl.iSleep(10);
			List<WebElement> alloptions = driver.findElements(By.xpath(cp.createdCustomer));
			int count = alloptions.size();
			for(int i=0;i<count;i++)
			{
				WebElement option = alloptions.get(i);
				String optiontext = option.getText();
				System.out.println(optiontext);
				if(optiontext.equalsIgnoreCase(customerData1[1]))
				{
					driver.findElement(By.xpath("//div[@class='oe_kanban_details']//span[text()='"+customerData1[1]+"']")).click();
					
					break;
				}
				
				
			}
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.action)).click();
			sl.iSleep(5);
			
			driver.findElement(By.xpath(cp.delete)).click();
			sl.iSleep(5);
			driver.findElement(By.xpath(cp.deleteConfirmation)).click();
		}
		
		
		

}
