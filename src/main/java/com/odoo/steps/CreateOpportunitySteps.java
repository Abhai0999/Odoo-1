package com.odoo.steps;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.PipelinePage;

public class CreateOpportunitySteps {
	WebDriver driver;
	PipelinePage pp;
	SeleniumLib sl;

	public CreateOpportunitySteps(WebDriver driver) {
		this.driver = driver;
		pp = new PipelinePage();
		sl = new SeleniumLib(driver);
	}
	//div[@class='o_content']//div[@role='feed']//strong[@class='o_kanban_record_title']//span[text()='500 Keyboard and computer']
	public void createOpportunity(String[] customerData, String[] customername) {
		driver.findElement(By.xpath(pp.createBtn)).click();
		sl.iSleep(1);
		String name;
		Random rm = new Random();
		int randonvalue = rm.nextInt(1000);

		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);

		String[] customer = eu.readData("Sheet1", "CreateCustomer_ID");
		name = customer[3].concat(Integer.toString(randonvalue));
		eu.setCellValue("Sheet1", 2, 3, name);
		
		driver.findElement(By.xpath(pp.OpportunityTxtFeild)).sendKeys(name);
		sl.iSleep(1);
		driver.findElement(By.xpath(pp.customerTxtFeild)).sendKeys(customername[3]);
		sl.iSleep(1);
		sl.enter();

		sl.iSleep(1);
		sl.clearTextFeild(driver.findElement(By.xpath(pp.expeReveTxtFeild)));
		driver.findElement(By.xpath(pp.expeReveTxtFeild)).sendKeys(customerData[4]);
		sl.iSleep(1);
		sl.jsClick(driver.findElement(By.xpath(pp.addBtn)));
		sl.iSleep(3);

		String actualtxt = driver.findElement(By.xpath(pp.OppTxt)).getText();
		String exptxt = customerData[3];
		Assert.assertEquals(actualtxt, exptxt);
		Reporter.log(customerData[3] + " Opportunity has been created and successfully verify  ", true);
	}

}
