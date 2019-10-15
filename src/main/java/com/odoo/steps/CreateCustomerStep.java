package com.odoo.steps;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;
import com.odoo.pageobjects.LoginPage;
import com.odoo.pageobjects.NewCustomerPage;

public class CreateCustomerStep {
	WebDriver driver;
	BasePage bp;
	CustomerPage cp;
	NewCustomerPage ncp;
	LoginPage lp;
	SeleniumLib sl;
	public CreateCustomerStep(WebDriver driver) {
		this.driver=driver;
		bp=new BasePage();
		cp=new CustomerPage();
		ncp=new NewCustomerPage();
		lp=new LoginPage();
		sl=new SeleniumLib(driver);
		
		
	}
	
	
	public void clickCreate() {//add all wait here
		driver.findElement(By.xpath(cp.Create)).click();
		sl.eWaitForVisiblity(20, ncp.Save);
	}
	public void cust_Name(String Namefield) {
		driver.findElement(By.xpath(ncp.NameField)).sendKeys(Namefield);
	}
	public void street(String Street) {
		driver.findElement(By.xpath(ncp.Street)).sendKeys(Street);
	}
	public void city(String City) {
		driver.findElement(By.xpath(ncp.City)).sendKeys(City);
	}
	public void state(String State) {
		WebElement st = driver.findElement(By.xpath(ncp.State));
		st.sendKeys(State);
		st.sendKeys(Keys.ENTER);
		
	}
	public void zip(String Zip) {
		driver.findElement(By.xpath(ncp.Zip)).sendKeys(Zip);
	}
	public void country(String Country) {
		WebElement ct = driver.findElement(By.xpath(ncp.Country));//.sendKeys(Country);
				ct.sendKeys(Country);
				ct.sendKeys(Keys.ARROW_DOWN);
				ct.sendKeys(Keys.ENTER);
			
				
		
	}
	public void mobile(String Mobile) {
		driver.findElement(By.xpath(ncp.Mobile)).sendKeys(Mobile);
	}
	public void email(String Email) {
		driver.findElement(By.xpath(ncp.Email)).sendKeys(Email);
	}
	
	
	public void saveNew() {
		driver.findElement(By.xpath(ncp.Save)).click();
		//l.iSleep(3);
	}
	
	public WebElement myname() {
	WebElement we = driver.findElement(By.xpath(cp.Sandy));
	return we;
	}
	
	
	
	
	
	
	
	
	
	
	

}
