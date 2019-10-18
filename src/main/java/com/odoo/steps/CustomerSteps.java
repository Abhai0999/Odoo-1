package com.odoo.steps;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.CustomerPage;
import com.odoo.pageobjects.LoginPage;

public class CustomerSteps {
	WebDriver driver;
	CustomerPage cp;
	SeleniumLib sl;
	LoginPage lp;
	//GenericLib gl;

	public CustomerSteps(WebDriver driver) {
		this.driver = driver;
		cp = new CustomerPage();
		sl = new SeleniumLib(driver);
		lp = new LoginPage();
		//gl = new GenericLib();

	}

	public void clickCreate() { // add all wait here
		sl.iSleep(6);
		driver.findElement(By.xpath(cp.Create)).click();
	}

	public void createCustomer(String[] customerData)

	{
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.customerName)).sendKeys(customerData[3]);
		driver.findElement(By.xpath(cp.Street)).sendKeys(customerData[4]);
		driver.findElement(By.xpath(cp.City)).sendKeys(customerData[5]);
		WebElement State = driver.findElement(By.xpath(cp.State));
		State.sendKeys(customerData[6]);
		State.sendKeys(Keys.ARROW_DOWN);
		State.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(cp.Zip)).sendKeys(customerData[7]);
		driver.findElement(By.xpath(cp.Zip)).sendKeys(customerData[8]);
		driver.findElement(By.xpath(cp.Mobile)).sendKeys(customerData[9]);
		driver.findElement(By.xpath(cp.Email)).sendKeys(customerData[10]);
		driver.findElement(By.xpath(cp.Zip)).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(cp.edit))).perform();
	    driver.findElement(By.xpath(cp.edit)).click();
		sl.iSleep(6);
		try {
			Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\autoit\\upload.exe");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.Save)).click();
	}
		
		public void deleteCustomer(String customerData)
		{
			 List<WebElement> Elmnt = driver.findElements(By.xpath(cp.ExistingCustomer));
			
			int count= Elmnt.size();
			System.out.println("customer names"+count);
			for(int i=0;i<count;i++)
			{
				WebElement ele =Elmnt.get(i);
						System.out.println(ele.getText());
				if(ele.getText().equalsIgnoreCase(customerData));
				{
					ele.click();
					break;
				}
			}
		driver.findElement(By.xpath(cp.Action)).click();
		driver.findElement(By.xpath(cp.Delete)).click();

	}

}
