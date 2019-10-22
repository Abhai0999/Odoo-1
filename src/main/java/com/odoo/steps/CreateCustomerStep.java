package com.odoo.steps;

import java.util.Random;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.GenericLib;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.BasePage;

import com.odoo.pageobjects.CustomersPage;

public class CreateCustomerStep {
	WebDriver driver;
	CustomersPage cp;

	SeleniumLib sl;
	BasePage bp;
	GenericLib gl;
	ExcelUtilities eu;

	public CreateCustomerStep(WebDriver driver) {
		this.driver = driver;
		cp = new CustomersPage();

		sl = new SeleniumLib(driver);
		bp = new BasePage();
		gl = new GenericLib();
		eu = new ExcelUtilities();
	}

	public void clickOncreate() {
		driver.findElement(By.xpath(cp.create)).click();
	}

	public void createCustomer(String[] customerData) {
		String name;
		Random rm = new Random();
		int randonvalue = rm.nextInt(1000);

		String filepath = GenericLib.dir + "/testdata/Odoodata.xlsx";
		ExcelUtilities eu = new ExcelUtilities(filepath);

		String[] customer = eu.readData("Sheet1", "CreateCustomer_ID");
		name = customer[3].concat(Integer.toString(randonvalue));
		eu.setCellValue("Sheet1", 2, 3, name);
		

		driver.findElement(By.xpath(cp.nameFeild)).sendKeys(name);

		driver.findElement(By.xpath(cp.addressStreet)).sendKeys(customerData[4]);
		driver.findElement(By.xpath(cp.addressStreet2)).sendKeys(customerData[5]);
		driver.findElement(By.xpath(cp.addressCity)).sendKeys(customerData[6]);
		driver.findElement(By.xpath(cp.addressState)).sendKeys(customerData[7]);
		sl.enter();
		driver.findElement(By.xpath(cp.addressZip)).sendKeys(customerData[8]);
		driver.findElement(By.xpath(cp.addressCountry)).sendKeys(customerData[9]);
		driver.findElement(By.xpath(cp.mobileTxtFeild)).sendKeys(customerData[10]);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(cp.photoframe))).perform();
		act.click().perform();
		sl.iSleep(5);
		sl.RunAutoIT("./Resouce/fileupload.exe");
		sl.iSleep(5);
		driver.findElement(By.xpath(cp.saveBtn)).click();
		Reporter.log("customer"+name+"is successfully created ", true );
		sl.iSleep(5);

		String verCoustomer = "//h1/span[text()='" + name + "']";
		String actualTxt = driver.findElement(By.xpath(verCoustomer)).getText();
		String[] customerName = eu.readData("Sheet1", "CreateCustomer_ID");
		String expectedTxt = customerName[3];
		Assert.assertEquals(actualTxt, expectedTxt);
		Reporter.log(name + " customer has been created and veryfy successfully ", true);
	}

}
