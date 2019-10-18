package com.odoo.steps;


import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;
import com.odoo.pageobjects.CustomerPage;
import com.odoo.pageobjects.LoginPage;


public class CustomerStep {
	WebDriver driver;
	BasePage bp;
	CustomerPage cp;
	LoginPage lp;
	SeleniumLib sl;
	public CustomerStep(WebDriver driver) {
		this.driver=driver;
		bp=new BasePage();
		cp=new CustomerPage();
		lp=new LoginPage();
		sl=new SeleniumLib(driver);
		
		
		
	}
	public void createCustomer(String[] cust_data) {
		//fit here dynamic portion
		
		driver.findElement(By.xpath(cp.NameField)).sendKeys(cust_data[3]);
		driver.findElement(By.xpath(cp.Street)).sendKeys(cust_data[4]);
		driver.findElement(By.xpath(cp.City)).sendKeys(cust_data[5]);
		WebElement st = driver.findElement(By.xpath(cp.State));
		st.sendKeys(cust_data[6]);
		st.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(cp.Zip)).sendKeys(cust_data[7]);
		WebElement ct = driver.findElement(By.xpath(cp.Country));//.sendKeys(Country);
		ct.sendKeys(cust_data[8]);
		ct.sendKeys(Keys.ARROW_DOWN);
		ct.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(cp.Mobile)).sendKeys(cust_data[9]);
		driver.findElement(By.xpath(cp.Email)).sendKeys(cust_data[10]);
		driver.findElement(By.xpath(cp.photoUpload)).click();
		sl.iSleep(4);
		try {
			Runtime.getRuntime().exec("C:\\Users\\jensen\\Desktop\\upload1.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void clickCreate() {//add all wait here
		driver.findElement(By.xpath(cp.Create)).click();
		//sl.eWaitForVisiblity(20, ncp.Save);
		sl.iSleep(3);
	}
	public void saveNew() {
		sl.iSleep(4);
		driver.findElement(By.xpath(cp.Save)).click();
		sl.iSleep(5);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']/span[text()='Ok']")).click();
	}
	
	public void  delcustStep1(String del_name) {
		System.out.println(del_name);
		List<WebElement> names = driver.findElements(By.xpath(cp.delname));
		int count = names.size();
		for (int i = 0; i < count; i++) {
			WebElement we = names.get(i);
			String act_name = we.getText();
			System.out.println(act_name);
			if (act_name.equalsIgnoreCase(del_name)) {
				we.click();
				driver.findElement(By.xpath(cp.action)).click();
				driver.findElement(By.xpath(cp.delete));
			}		
			
		}	
		
	}
	public void delcustStep2() {
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.action)).click();
		driver.findElement(By.xpath(cp.delete)).click();
	}
	public void clickImport() {
		driver.findElement(By.xpath(cp.Import));
		sl.iSleep(4);
		
	}
	public void clickLoad() {
		sl.iSleep(3);
		driver.findElement(By.xpath(cp.Load));
		sl.iSleep(5);
		try {
			Runtime.getRuntime().exec("/Odoo/exefiles/custload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sl.iSleep(3);
	}
	public void clickImport_con() {
		driver.findElement(By.xpath(cp.import_confirm));
		sl.iSleep(3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
