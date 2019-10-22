package com.odoo.steps;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.odoo.generic.ExcelUtilities;
import com.odoo.generic.SeleniumLib;
import com.odoo.pageobjects.CustomersPage;

public class DeleteCustStpes {
	WebDriver driver;
	CustomersPage cp;
	SeleniumLib sl;
	ExcelUtilities eu;

	public DeleteCustStpes(WebDriver driver) {
		this.driver = driver;
		cp = new CustomersPage();
		sl = new SeleniumLib(driver);
		eu = new ExcelUtilities();
	}

	public void selectCust(String name) {
		driver.findElement(By.xpath("//strong[contains(@class,'title')]/span[text()='" + name + "']")).click();
	}

	public void clickOnAction() {
		driver.findElement(By.xpath(cp.Action)).click();
	}

	public void clickOnDel() {
		driver.findElement(By.xpath(cp.DeleteBtn)).click();
	}

	public void confDel() {
		driver.findElement(By.xpath(cp.ConfOKBtn)).click();
	}

	public void vryDeleteCustomer(String name) {
		sl.iSleep(3);
		driver.findElement(By.xpath(cp.customerslink)).click();
		sl.iSleep(3);

		List<WebElement> customernamesize = driver.findElements(By.xpath(cp.allCustomerName));
		int count = customernamesize.size();
		System.out.println("all customer present " + count);
		// String[] data = eu.readData("Sheet1", "CreateCustomer_ID");
		for (int i = 0; i < count; i++) {
			WebElement ele = customernamesize.get(i);
			String text = ele.getText();
			System.out.println(text);

			Assert.assertNotEquals(text, name);

		}

	}

}
